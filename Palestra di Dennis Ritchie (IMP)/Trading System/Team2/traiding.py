class pokemon():
    def __init__(self, name, type, level):
        self.name = name
        self.type = type
        self.level = level
class trainer():
    def __init__(self, name,surname, pokemon):
        self.name = name
        self.surname = surname
        self.pokemon = pokemon

def add_pokemon(inventory, trainer, pokemon):
    if trainer.name+"_"+trainer.surname in inventory:
        inventory[trainer.name+"_"+trainer.surname].append(pokemon)
        print("Pokemon added")
    else:
        inventory[trainer.name+"_"+trainer.surname] = [pokemon]
        print("Trainer added")
def remove_pokemon(inventory, trainer, pokemon):
    if trainer in inventory:
        inventory[trainer.name+"_"+trainer.surname].remove(pokemon)
        print("Pokemon removed")
    else:
        print("Trainer not found")

def trade_pokemon(inventory, trainer1_name, trainer1_surname, trainer2_name,trainer2_surname, pokemon):

        inventory[trainer1_name+"_"+trainer1_surname].remove(pokemon)
        inventory[trainer2_name+"_"+trainer2_surname].append(pokemon)


def show_pokemon(inventory, trainer_name, trainer_surname):

    for i in inventory[trainer_name+"_"+trainer_surname]:
        print(i.name, i.type, i.level)

selezione=0
inventory={}
#menu
while selezione!=5:
    print("1. Add pokemon")
    print("2. Remove pokemon")
    print("3. Trade pokemon")
    print("4. SHow inventory")
    print("5. Exit")
    selezione = int(input())
    if selezione==1:
        name = input("Enter the name of the pokemon: ")
        type = input("Enter the type of the pokemon: ")
        level = int(input("Enter the level of the pokemon: "))
        pokemon1 = pokemon(name, type, level)
        name = input("Enter the name of the trainer: ")
        surname = input("Enter the surname of the trainer: ")
        trainer1 = trainer(name, surname, pokemon1)
        add_pokemon(inventory, trainer1, pokemon1)
    elif selezione==2:
        name = input("Enter the name of the pokemon: ")
        type = input("Enter the type of the pokemon: ")
        level = int(input("Enter the level of the pokemon: "))
        pokemon1 = pokemon(name, type, level)
        name = input("Enter the name of the trainer: ")
        surname = input("Enter the surname of the trainer: ")
        trainer1 = trainer(name, surname, pokemon1)
        remove_pokemon(inventory, trainer1, pokemon1)
    elif selezione==3:
        namePoke = input("Enter the name of the pokemon: ")
        name = input("Enter the name of the trainer1: ")
        surname = input("Enter the surname of the trainer1: ")
        name2 = input("Enter the name of the trainer2: ")
        surname2 = input("Enter the surname of the trainer2: ")
        for i in inventory[name+"_"+surname]:
            if i.name==namePoke:
                pokemon=i
        trade_pokemon(inventory, name,+surname, name2,surname2, pokemon)
    elif selezione==4:
        name = input("Enter the name of the trainer: ")
        surname = input("Enter the surname of the trainer: ")
        show_pokemon(inventory, name,surname)
    else:
        print("Invalid selection")


