class pokemon():
    def __init__(self, name, hp, attack, defense):
        self.name = name
        self.hp = hp
        self.attack = attack
        self.defense = defense

    def attack_enemy(self, enemy):
        damage = self.attack - enemy.defense
        enemy.hp -= damage


def battle(pokemon1,pokemon2):
    while pokemon1.hp > 0 and pokemon2.hp > 0:
        pokemon1.attack_enemy(pokemon2)
        print(pokemon1.name, " attacca!")
        if pokemon2.hp <= 0:
            return pokemon1.name
        else:
            pokemon2.attack_enemy(pokemon1)
            print(pokemon2.name, " attacca!")
            if pokemon1.hp <= 0:
                return pokemon2.name

pokemon1 = pokemon("Pikachu", 100, 50, 20)
pokemon2 = pokemon("Charizard", 120, 40, 30)
print("ha vinto: ", battle(pokemon1, pokemon2), "!")
