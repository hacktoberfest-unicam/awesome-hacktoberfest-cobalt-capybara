class Pokemon:
    name = ""
    hp = 0
    attack = 0
    defense = 0

    def __init__(self, name, hp, attack, defense):
        self.name = name
        self.hp = hp
        self.attack = attack
        self.defense = defense

    def get_damage(self, damage):
        self.hp -= damage

    def get_hp(self):
        return self.hp

def battle(pokemon1,pokemon2):
    while (pokemon1.hp > 0 and pokemon2.hp > 0):
        #pk1 attack pk2
        damage = max(pokemon1.attack - pokemon2.defense, 0)
        pokemon2.get_damage(damage)

        print(pokemon1.name, "attacks" , pokemon2.name," for ", damage," damage. " ,pokemon2.name, " has "
              ,pokemon2.hp, " HP left.")    
        
        if (pokemon2.hp <= 0):
            print(pokemon2.name, " HAS FAINTED! ",pokemon1.name, " WINS!")

        #pk2 attack pk1
        damage = max(pokemon2.attack - pokemon1.defense, 0)
        pokemon1.get_damage(damage)

        print(pokemon2.name, "attacks" , pokemon1.name," for ", damage," damage. " ,pokemon1.name, " has "
              ,pokemon1.hp, " HP left.")
        
        if (pokemon1.hp <= 0):
            print(pokemon1.name, " HAS FAINTED! ",pokemon2.name, " WINS!")

def main():
    pokemon1 = Pokemon("Rayquaza", 100, 30, 20)
    pokemon2 = Pokemon("Rattata", 50, 10, 20)
    battle(pokemon1,pokemon2)

main()