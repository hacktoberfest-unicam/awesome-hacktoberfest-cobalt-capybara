class Pokemon:
    type_advantages = {
        "Fire": ["Grass", "Ice", "Bug", "Steel"],
        "Water": ["Fire", "Ground", "Rock"],
        "Grass": ["Water", "Ground", "Rock"],
        "Electric": ["Water", "Flying"],
        "Ice": ["Grass", "Ground", "Flying", "Dragon"],

    }
    
    def __init__(self, name, poke_type, attack, defense, moves):
        self.name = name
        self.type = poke_type
        self.attack = attack
        self.defense = defense
        self.moves = moves  # List of dictionaries with 'move_name' and 'power'

    def calculate_damage(self, target, move_name):
        """
        Calculate the damage dealt to the target Pokemon based on the 
        attacker's attributes and the target's defense, taking into account the move's power.
        """
        # Find the move
        move = next((m for m in self.moves if m['move_name'] == move_name), None)
        if not move:
            print(f"{self.name} doesn't know {move_name}!")
            return 0

        # Base damage calculation: (attacker's attack / target's defense) * move power
        base_damage = (self.attack / target.defense) * move['power']

        # Check for type advantage
        if self.type_advantage(target):
            base_damage *= 1.5  # Increase damage by 50% if type advantage exists
            print(f"{self.name} has a type advantage against {target.name}!")

        return int(base_damage)

    def type_advantage(self, target):
        advantages = self.type_advantages.get(self.type, [])
        return target.type in advantages


