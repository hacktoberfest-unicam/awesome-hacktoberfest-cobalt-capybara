class Pokemon:
    def __init__(self, name, p_type, attack, defense, moves, supereff:list):
        self.name = name
        self.type = p_type
        self.attack = attack
        self.defense = defense
        self.moves = moves
        self.supereff = supereff


    def calculate_damage(self, target):
        base_damage = self.attack - target.defense
        if base_damage < 0:
            base_damage = 0
        return base_damage * self.type_advantage(target)

    def type_advantage(self, target):
        if target.type in self.supereff:
            return 2



