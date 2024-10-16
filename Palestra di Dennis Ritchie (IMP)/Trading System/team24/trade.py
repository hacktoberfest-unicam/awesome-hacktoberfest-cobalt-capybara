

def add_pokemon(inventory, trainer, pokemon):

    if trainer not in inventory:
        inventory[trainer] = []
    
 
    inventory[trainer].append(pokemon)
    print(f"{pokemon} added to {trainer}'s inventory.")

def remove_pokemon(inventory, trainer, pokemon):
    
    if trainer in inventory:
        
        if pokemon in inventory[trainer]:
            inventory[trainer].remove(pokemon)
            print(f"{pokemon} removed from {trainer}'s inventory.")
        else:
            print(f"{pokemon} not found in {trainer}'s inventory.")
    else:
        print(f"{trainer} not found.")

def trade_pokemon(inventory, trainer_from, trainer_to, pokemon):
    
    if trainer_from in inventory and trainer_to in inventory:
        
        if pokemon in inventory[trainer_from]:
            remove_pokemon(inventory, trainer_from, pokemon)  
            add_pokemon(inventory, trainer_to, pokemon)       
            print(f"{trainer_from} traded {pokemon} to {trainer_to}.")
        else:
            print(f"{pokemon} not found in {trainer_from}'s inventory.")
    else:
        print("One or both trainers not found.")

def display_inventory(inventory, trainer):
   
    if trainer in inventory:
        print(f"{trainer}'s Inventory:")
   
        for pokemon in inventory[trainer]:
            print(pokemon)
    else:
        print(f"{trainer} not found.")

if __name__ == "__main__":

    inventory = {}


    add_pokemon(inventory, "Ash", "Pikachu")
    add_pokemon(inventory, "Misty", "Starmie")
    add_pokemon(inventory, "Ash", "Bulbasaur")


    display_inventory(inventory, "Ash")
    display_inventory(inventory, "Misty")


    remove_pokemon(inventory, "Ash", "Pikachu")
    display_inventory(inventory, "Ash")


    trade_pokemon(inventory, "Ash", "Misty", "Bulbasaur")
    display_inventory(inventory, "Ash")
    display_inventory(inventory, "Misty")
