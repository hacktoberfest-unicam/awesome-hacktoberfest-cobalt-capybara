class Pokemon():
    def __init__(self, name, type, level,hp,moves=[]):
        self.name = name
        self.type = type
        self.level = level
        self.hp = hp
        self.moves = moves
    def level_up(self):
        self.level += 1
        self.hp += 10
        print (self.name + " ha raggiunto il livello " + str(self.level) + "!")
        self.evolve()

    def evolve(self):
        return self

class Charmander(Pokemon):
    def __init__(self, name, type, level, hp, moves=[]):
        self.name = name
        self.type = type
        self.level = level
        self.hp = hp
        self.moves = moves



    def evolve(self):
        if self.level == 16:
            print("Charmander ha evoluto in Charmeleon!")
            return Charmeleon(self.name,self.type, self.level, self.hp, self.moves)
        else:
            return self

class Charmeleon(Pokemon):
    def __init__(self, name, type, level, hp, moves=[]):
        self.name = name
        self.type = type
        self.level = level
        self.hp = hp
        self.moves = moves


    def evolve(self):
        if self.level >= 36:
            print("Charmeleon ha evoluto in Charizard!")
            return Charizard(self.name, self.level)
        else:
            return self

class Charizard(Pokemon):
    def __init__(self, name, type, level, hp, moves=[]):
        self.name = name
        self.type = type
        self.level = level
        self.hp = hp
        self.moves = moves

    def evolve(self):
        return self



charmander = Charmander("Charmander", "Fire", 15, 39, ["Scratch", "Ember"])
charmander.level_up()
charmander.level_up()

