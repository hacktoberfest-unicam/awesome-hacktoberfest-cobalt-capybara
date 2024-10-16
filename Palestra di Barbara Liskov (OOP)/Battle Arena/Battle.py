class Pokemon():
    def __init__(self, name, type, level,hp, stats, moves=[]):
        self.name = name
        self.type = type
        self.level = level
        self.hp = hp
        self.stats = stats
        self.moves = moves

    def level_up(self):
        self.level += 1
        self.hp += 10
        print (self.name + " ha raggiunto il livello " + str(self.level) + "!")
        self.evolve()

    def evolve(self):
        return self

    def defend(self, damage):
        self.hp -= damage
        print(self.name + " ha subito " + str(damage) + " danni!")
        if self.hp <= 0:
            print(self.name + " è esausto!")
            return False
        else:
            print(self.name + " ha ancora " + str(self.hp) + " HP!")
            return

    def calculate_damage(self, move, enemy):
        if move.type == "Water" and enemy.type == "Grass":
            damage = move.damage / 2
        elif move.type == "Grass" and enemy.type == "Water":
            damage = move.damage * 2
        else:
            damage = move.damage
        return damage

    def attack(self, move, enemy):
        if move in self.moves:
            if move.pp > 0:
                print(self.name + " usa " + move.name + "!")
                move.pp -= 1
                damage = self.calculate_damage(move, enemy)
                enemy.defend(damage)

            else:
                print("Non hai più PP per questo attacco!")
        else:
            print("Mossa non valida!")



class WaterType(Pokemon):
    def __init__(self, name, level, hp, stats, moves=[]):
        super().__init__(name, "Water", level, hp, stats, moves)

class GrassType(Pokemon):
    def __init__(self, name, level, hp, stats, moves=[]):
        super().__init__(name, "Grass", level, hp, stats, moves)

class Moves():
    def __init__(self, name, damage, type,pp):
        self.name = name
        self.damage = damage
        self.type = type
        self.pp = pp

class Battle():
    def start_battle(self,Pokemon1, Pokemon2):
        while Pokemon1.hp > 0 and Pokemon2.hp > 0:
            Pokemon1.attack(Pokemon1.moves[0], Pokemon2)
            if Pokemon2.hp > 0:
                Pokemon2.attack(Pokemon2.moves[0], Pokemon1)
        if Pokemon1.hp <= 0:
            print(Pokemon1.name + " ha perso!")
            print(Pokemon2.name + " ha vinto!")
        elif Pokemon2.hp <= 0:
            print(Pokemon2.name + " ha perso!")
            print(Pokemon1.name + " ha vinto!")
        return


pokemon1= WaterType("Squirtle", 5, 50, [10, 10, 10, 10], [Moves("Water Gun", 10, "Water", 10)])
pokemon2= GrassType("Bulbasaur", 5, 50, [10, 10, 10, 10], [Moves("Vine Whip", 10, "Grass", 10)])
battle = Battle()
battle.start_battle(pokemon1, pokemon2)


