type_advantage = {
    "elettro": ["volante", "acqua"],
    "fuoco": ["coleottero", "erba", "ghiaccio", "acciaio"]
}


class Pokemon:
    name: str
    type: str
    attack: int
    defense: int
    moves: list[dict[str, int]]

    def __init__(self, name, type, attack, defense, moves):
        self.name = name.lower()
        self.type = type.lower()
        self.attack = attack
        self.defense = defense
        self.moves = [{name.lower(): power} for name, power in moves]

    def calculate_damage(self, target: 'Pokemon'):
        damage = self.attack - target.defense
        damage = max(0, damage)
        if self.type_advantage(target):
            damage *= 1.5
        return damage

    def type_advantage(self, target: 'Pokemon'):
        return target.type in type_advantage[self.type]


# -------------------------

def test_battle():
    charizard = Pokemon("charizard", "fuoco", 100, 40, {})
    carnivine = Pokemon("CARNIVINE", "erba", 50, 60, {})
    damage = charizard.calculate_damage(carnivine)
    assert damage == (40*1.5)

test_battle()