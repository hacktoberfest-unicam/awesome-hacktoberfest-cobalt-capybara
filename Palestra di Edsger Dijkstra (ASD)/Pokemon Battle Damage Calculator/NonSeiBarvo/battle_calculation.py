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
        self.moves = moves

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
    charizard = Pokemon("charizard", "fuoco", 100, 40, [])
    carnivine = Pokemon("CARNIVINE", "erba", 50, 60, [])
    damage = charizard.calculate_damage(carnivine)
    assert damage == (40 * 1.5)
    print(f"{charizard.name} deals {damage} damage to {carnivine.name}!")

    torterra = Pokemon("torterra", "erba", 60, 110, [])
    damage = charizard.calculate_damage(torterra)
    assert damage == 0
    print(f"{charizard.name} deals {damage} damage to {torterra.name}!")

    pikachu = Pokemon("pikachu", "elettro", 55, 40, [{"move_name": "Thunderbolt", "power": 40}])
    charmander = Pokemon("charmander ", "fuoco", 52, 43, [{"move_name": "Ember", "power": 40}])
    damage = pikachu.calculate_damage(charmander)
    assert damage == (55 - 43)
    print(f"{pikachu.name} deals {damage} damage to {charmander.name}!")


test_battle()
