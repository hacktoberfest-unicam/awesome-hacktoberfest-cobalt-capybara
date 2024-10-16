from enum import Enum
import random

class Type(Enum):
    fire = 1
    water = 2
    grass = 3

efficacy = {
    Type.fire: {Type.grass: 2.0, Type.water: 0.5},
    Type.grass: {Type.water: 2.0, Type.fire: 0.5},
    Type.water: {Type.fire: 2.0, Type.grass: 0.5},
}

class Pokemon:
    name = ""
    type = ""
    hp = 0
    moves = []
    stats = {}
    def _init_(self,name,type,hp,moves,stats):
        self.name = name 
        self.type = type
        self.hp = hp
        self.moves = moves
        self.stats = stats
    
    def get_random_move(self):
        return random.choice(self.moves) if self.moves else None
    
    def attack(self,targert_pokemon, move):
        print(self.name," uses ", move.name, " on ", targert_pokemon.name )
        multiplier = efficacy.get(move.type, {}).get(targert_pokemon.type)
        damage = move.damage * multiplier
        targert_pokemon.defend(damage)

    def defend(self,damage):
        self.hp = max(self.hp-damage,0)
        print(self.name, " takes ", damage , " damage. ", self.hp, " HP left.")

class Move:
    name = ""
    type = ""
    damage = 0
    pp = 0
    def _init_ (self,name,type,damage,pp):
        self.name = name
        self.type = type
        self.damage = damage
        self.pp = pp

class Battle:
    def startBattle(self, pokemon1,pokemon2):
        while(pokemon1.hp > 0 and pokemon2.hp>0):
            pokemon1.attack(pokemon2,pokemon1.get_random_move() )
            if(pokemon2.hp >0):
                pokemon2.attack(pokemon1,pokemon2.get_random_move() )
        if(pokemon2.hp > pokemon1.hp):
            print(pokemon2.name, " win")
        else:
            print(pokemon1.name, " win")

def main():
    ember = Move("ember",Type.fire,30,15)
    hydropump = Move("hydropump",Type.water,15,10)
    bulletseed = Move("bulletseed",Type.grass,5,5)
    charmander = Pokemon("charmander",Type.fire,60,[ember],{'Attack':123, 'Speed':23, 'Defence':40})
    bulbasaur = Pokemon("bulbasaur",Type.grass,100,[bulletseed],{'Attack':12, 'Speed':3, 'Defence':5})

    battle = Battle()
    battle.startBattle(charmander,bulbasaur)

main()