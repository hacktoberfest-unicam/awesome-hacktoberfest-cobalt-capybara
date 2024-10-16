
class Pokemon:
    def __init__(self, name, hp, attack, defense):
        self.name = name
        self.hp = hp
        self.attack = attack
        self.defense = defense


    def calculate_damage(self, opponent):
        damage = self.attack - opponent.defense
        if damage < 0:
            damage = 0
        return damage

    def take_damage(self, damage):
        self.hp -= damage

    def is_fainted(self):
        return self.hp <= 0


def simulate_battle(pokemon1, pokemon2):
    print("Battle Start!\n")
    
    while True:

        damage = pokemon1.calculate_damage(pokemon2)
        pokemon2.take_damage(damage)
        print(f"{pokemon1.name} attacks {pokemon2.name} and deals {damage} damage.")
        print(f"{pokemon2.name}'s HP is now {pokemon2.hp}.\n")
        
        if pokemon2.is_fainted():
            print(f"{pokemon2.name} has fainted!")
            print(f"{pokemon1.name} wins the battle!")
            break
        

        damage = pokemon2.calculate_damage(pokemon1)
        pokemon1.take_damage(damage)
        print(f"{pokemon2.name} attacks {pokemon1.name} and deals {damage} damage.")
        print(f"{pokemon1.name}'s HP is now {pokemon1.hp}.\n")
        
        if pokemon1.is_fainted():
            print(f"{pokemon1.name} has fainted!")
            print(f"{pokemon2.name} wins the battle!")
            break


if __name__ == "__main__":
    pikachu = Pokemon("Pikachu", 100, 20, 10)
    bulbasaur = Pokemon("Bulbasaur", 90, 15, 8)

    simulate_battle(pikachu, bulbasaur)

