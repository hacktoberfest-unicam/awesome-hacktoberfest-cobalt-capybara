class Pokemon:
    def __init__(self, name, type, level, hp, moves):
        self.name = name
        self.type = type
        self.level = level
        self.hp = hp
        self.moves = moves
    
    def evolve(self):
        pass

    def level_up(self):
        self.level += 1
        print(self.name, " leveled up to ", self.level, "!")
        evolved_pokemon = self.evolve()
        if evolved_pokemon:
            return evolved_pokemon
        return self

class Charizard(Pokemon):
    pass

class Charmeleon(Pokemon):
    def evolve(self):
        if (self.level >= 36):
            print(self.name, " is evolving into Charizard!")
            return Charizard("Charizard", self.type, self.level, 110, ["Scratch", "Ember","Dragon Breath","Flamethrower"])
        return None

class Charmander(Pokemon):
    def evolve(self):
        if(self.level >= 16):
            print(self.name, " is evolving into Charmeleon!")
            return Charmeleon("Charmeleon", self.type, self.level, 60, ["Scratch", "Ember","Dragon Breath"])
        return None

def main():
    pkmn = Charmander("Charmander", "Fire", 15, 39, ["Scratch", "Ember"])
    print("Pokemon moves: ",pkmn.moves)
    pkmn = pkmn.level_up()  #Evolving to Charmeleon at level 16
    print("Pokemon moves: ",pkmn.moves)
    while (pkmn.level < 36):
        pkmn = pkmn.level_up()  #Remains Charmeleon
    print("Pokemon moves: ",pkmn.moves)
main()