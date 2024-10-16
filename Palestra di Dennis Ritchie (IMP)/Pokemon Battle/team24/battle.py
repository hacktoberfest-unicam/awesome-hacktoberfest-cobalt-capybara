
class Pokemon:
    def __init__(self, name, hp, attack, defense):
        self.name = name
        self.hp = hp
        self.attack = attack
        self.defense = defense


    def calculate_damage(self, opponent):
        damage = max(self.attack - opponent.defense, 0)
        return damage


    def has_fainted(self):
        return self.hp <= 0

def battle(pokemon1, pokemon2):
    print("Battle Start!\n")
    

    while pokemon1.hp > 0 and pokemon2.hp > 0:

        damage = pokemon1.calculate_damage(pokemon2)
        pokemon2.hp -= damage
        print(f"{pokemon1.name} attacks {pokemon2.name} for {damage} damage. {pokemon2.name} has {pokemon2.hp} HP left.")
        
        if pokemon2.has_fainted():
            print(f"\n{pokemon2.name} has fainted! {pokemon1.name} wins!")
            break


        damage = pokemon2.calculate_damage(pokemon1)
        pokemon1.hp -= damage
        print(f"{pokemon2.name} attacks {pokemon1.name} for {damage} damage. {pokemon1.name} has {pokemon1.hp} HP left.")
        
        if pokemon1.has_fainted():
            print(f"\n{pokemon1.name} has fainted! {pokemon2.name} wins!")
            break


def main():

    pikachu = Pokemon("Pikachu", 100, 55, 40)
    bulbasaur = Pokemon("Bulbasaur", 105, 50, 45)


    battle(pikachu, bulbasaur)


if __name__ == "__main__":
    main()
