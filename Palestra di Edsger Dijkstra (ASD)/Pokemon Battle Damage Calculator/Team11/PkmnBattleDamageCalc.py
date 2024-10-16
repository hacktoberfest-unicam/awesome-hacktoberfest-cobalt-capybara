from enum import Enum

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
    def __init__(self,name, type, attack, defense, moves):
        self.name = name
        self.type = type
        self.attack = attack
        self.defense = defense
        self.moves = moves
    
    def calculate_damage(self,target):
        base_damage = max(self.attack - target.defense,0)
        return base_damage * self.type_advantage(target)

    def type_advantage(self,target):
        return efficacy.get(self.type,{}).get(target.type)   
    
def main():
    bulbasaur = Pokemon("Bulbasaur", Type.grass, 55, 40, [{"move_name": "Bullet Seed", "power": 40}])
    charmander = Pokemon("Charmander", Type.fire, 52, 43, [{"move_name": "Ember", "power": 40}])

    damage = charmander.calculate_damage(bulbasaur)
    print(charmander.name, " deals ", damage, " damage to ", bulbasaur.name, "!")

main()