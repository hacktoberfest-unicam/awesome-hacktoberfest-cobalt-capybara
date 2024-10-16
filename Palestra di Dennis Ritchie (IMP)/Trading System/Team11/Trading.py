def menu():
    print("[1] Add Pokemon")
    print("[2] Remove Pokemon")
    print("[3] Trade Pokemon")
    print("[4] Show Inventory")
    print("[0] Quit")
    choice = int(input("Select a choice [0-4]: "))
    return choice

def add_pokemon(inventory, Trainer, pokemon):
    t =  get_trainer_by_name(Trainer, inventory)
    if(t == 0):
       new_trainer =  {'Name': Trainer, 'Pokemon': []}
       inventory.append(new_trainer)
       t =  get_trainer_by_name(Trainer, inventory)
    t['Pokemon'].append(pokemon)
    print(pokemon, " added to ", t['Name'], "'s inventory.")
      



def remove_pokemon(inventory, Trainer, pokemon):
    t =  get_trainer_by_name(Trainer, inventory)
    if( t != 0):
        if(pokemon in t['Pokemon']):
            t['Pokemon'].remove(pokemon)
            print(pokemon, " removed from "+ t['Name'],"'s inventory")
        else:
            print(pokemon, " not found in "+ t['Name'],"'s inventory")
    else:
        print(Trainer , " not found.")

def display_inventory(inventory, Trainer):
    t =  get_trainer_by_name(Trainer, inventory)
    if(t != 0):
        print(t['Name'], "'s Inventory")
        for p in t['Pokemon']:
            print(p, " ")
    else:
        print(Trainer , " not found.")

def trade_pokemon(inventory, trainer_from, trainer_to, pokemon):
    t1 = get_trainer_by_name(trainer_from, inventory)
    t2 = get_trainer_by_name(trainer_to, inventory)
    if(t1 != 0 and t2 != 0):
        if(pokemon in t1['Pokemon']):
            remove_pokemon(inventory,t1['Name'],pokemon)
            add_pokemon(inventory,t2['Name'],pokemon)
            print(t1['Name'], " traded ", pokemon, " to " , t2['Name'])
        else:
            print(pokemon, " not found in ", t1['Name'] , " inventory")
    else:
        print("One or both trainerso not found")

def get_trainer_by_name(name, inventory):
    for trainer in inventory:
        if trainer['Name'] == name:
            return trainer
    return 0

def switch_choice(inventory, sc):
     match sc:
        case 0:
            return
        case 1:
            t = input("Enter Trainer Name: ")
            p = input("Enter Pokemon to add: ")
            add_pokemon(inventory, t, p)
        case 2:
            t = input("Enter Trainer Name: ")
            p = input("Enter Pokemon to remove: ")
            remove_pokemon(inventory, t, p)
        case 3:
            t1 = input("Enter Trainer Name to trade from: ")
            t2 = input("Enter Trainer Name to trade to: ")
            p = input("Enter Pokemon to trade: ")
            trade_pokemon(inventory, t1, t2, p)
        case 4:
            t = input("Enter Trainer Name to display: ")
            display_inventory(inventory, t)
        case _:
            print("Invalid choice")

def main():
    Trainer1 = {'Name': 'Ash', 'Pokemon': ["Pikachu"]}
    Trainer2 = {'Name': 'Giovanni', 'Pokemon': ["Persian"]}
    inventory = [Trainer1, Trainer2]

    sc = ""
    while(sc != 0):
        sc = int(menu())
        switch_choice(inventory,sc)

    
main()