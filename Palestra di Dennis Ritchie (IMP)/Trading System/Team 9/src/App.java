import java.util.ArrayList;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        int choice = 1;
        //create an array of inventory
        ArrayList<Inventory> inventory = new ArrayList<Inventory>();
        //let the user insert a number
        do{
            System.out.println("Options: [1] Add Pokémon [2] Remove Pokémon [3] Trade Pokémon [4] Show Inventory [5] Quit");
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter trainer's name: ");
                    String trainer = input.nextLine();
                    
                    System.out.println("Enter Pokemon to add: ");
                    String pokemon = input.nextLine();
                    add_pokemon(inventory, trainer, pokemon);
                break;
                case 2:
                    System.out.println("Enter trainer's name: ");
                    String trainer2 = input.nextLine();
                    
                    System.out.println("Enter Pokemon to remove: ");
                    String pokemon2 = input.nextLine();
                    remove_pokemon(inventory, trainer2, pokemon2);
                break;
                case 3:
                    System.out.println("Enter trainer's name to trade from: ");
                    String trainer_from = input.nextLine();
                    
                    System.out.println("Enter trainer's name to trade to: ");
                    String trainer_to = input.nextLine();
                    
                    System.out.println("Enter Pokemon to trade: ");
                    String pokemon3 = input.nextLine();
                    trade_pokemon(inventory, trainer_from, trainer_to, pokemon3);
                break;
                case 4:
                    System.out.println("Enter trainer's name: ");
                    String trainer4 = input.nextLine();
                    display_inventory(inventory, trainer4);
                break; 
            }
        }while((choice == 5) || (choice != 4) && (choice != 3) && (choice != 2) && (choice != 1));
    }
    
    public static void add_pokemon(ArrayList<Inventory> inventory, String trainer, String pokemon){
        //if the trainer is not any of the inventory, create a new inventory
        for(int i = 0; i < inventory.size(); i++){
            if(trainer != inventory.get(i).getTrainer()){
                Inventory newInventory = new Inventory();
                newInventory.setTrainer(trainer);
                inventory.add(newInventory);
            }else{
                inventory.get(i).getPokemon().add(pokemon);
                System.out.println(pokemon + " added to " + trainer + "'s inventory.");
            }
        }
    }
    public static void remove_pokemon(ArrayList<Inventory> inventory, String trainer, String pokemon){
        for(int i = 0; i < inventory.size(); i++){
            if(trainer == inventory.get(i).getTrainer()){
                if(inventory.get(i).getPokemon().contains(pokemon)){
                    inventory.get(i).getPokemon().remove(pokemon);
                    System.out.println(pokemon + " removed from " + trainer + "'s inventory.");
                }else{
                    System.out.println(pokemon + " not found in " + trainer + "'s inventory.");
                }
            }else{
                System.out.println(trainer + " not found.");
            }
        }
    }
    public static void trade_pokemon(ArrayList<Inventory> inventory, String trainer_from, String trainer_to, String pokemon){
        for(int i = 0; i < inventory.size(); i++){
            if(trainer_from == inventory.get(i).getTrainer() && trainer_to == inventory.get(i).getTrainer()){
                if(inventory.get(i).getPokemon().contains(pokemon)){
                    remove_pokemon(inventory, trainer_from, pokemon);
                    add_pokemon(inventory, trainer_to, pokemon);
                    System.out.println(trainer_from + " traded " + pokemon + " to " + trainer_to + ".");
                }else{
                    System.out.println(pokemon + " not found in " + trainer_from + "'s inventory.");
                }
            }else{
                System.out.println("One or both trainers not found.");
            }
        }
    }

    public static void display_inventory(ArrayList<Inventory> inventory, String trainer){
        for(int i = 0; i < inventory.size(); i++){
            if(trainer == inventory.get(i).getTrainer()){
                System.out.println(trainer + "'s Inventory:");
                for(int j = 0; j < inventory.get(i).getPokemon().size(); j++){
                    System.out.println(inventory.get(i).getPokemon().get(j));
                }
            }else{
                System.out.println(trainer + " not found.");
            }
        }
    }
}

/*WHILE True DO
    PRINT "Options: [1] Add Pokémon [2] Remove Pokémon [3] Trade Pokémon [4] Show Inventory [5] Quit"
    SET choice TO GET USER INPUT

    IF choice = "1" THEN
        SET trainer TO GET USER INPUT "Enter trainer name: "
        SET pokemon TO GET USER INPUT "Enter Pokémon to add: "
        CALL add_pokemon(inventory, trainer, pokemon)
    ELSE IF choice = "2" THEN
        SET trainer TO GET USER INPUT "Enter trainer name: "
        SET pokemon TO GET USER INPUT "Enter Pokémon to remove: "
        CALL remove_pokemon(inventory, trainer, pokemon)
    ELSE IF choice = "3" THEN
        SET trainer_from TO GET USER INPUT "Enter trainer name to trade from: "
        SET trainer_to TO GET USER INPUT "Enter trainer name to trade to: "
        SET pokemon TO GET USER INPUT "Enter Pokémon to trade: "
        CALL trade_pokemon(inventory, trainer_from, trainer_to, pokemon)
    ELSE IF choice = "4" THEN
        SET trainer TO GET USER INPUT "Enter trainer name: "
        CALL display_inventory(inventory, trainer)
    ELSE IF choice = "5" THEN
        BREAK
    ELSE
        PRINT "Invalid option. Please choose again."
    END IF
END WHILE


FUNCTION add_pokemon(inventory, trainer, pokemon)
    IF trainer NOT EXISTS IN inventory THEN
        CREATE inventory[trainer] AS EMPTY LIST
    END IF
    APPEND pokemon TO inventory[trainer]
    PRINT pokemon + " added to " + trainer + "'s inventory."
END FUNCTION

FUNCTION remove_pokemon(inventory, trainer, pokemon)
    IF trainer EXISTS IN inventory THEN
        IF pokemon EXISTS IN inventory[trainer] THEN
            REMOVE pokemon FROM inventory[trainer]
            PRINT pokemon + " removed from " + trainer + "'s inventory."
        ELSE
            PRINT pokemon + " not found in " + trainer + "'s inventory."
        END IF
    ELSE
        PRINT trainer + " not found."
    END IF
END FUNCTION

FUNCTION trade_pokemon(inventory, trainer_from, trainer_to, pokemon)
    IF trainer_from EXISTS IN inventory AND trainer_to EXISTS IN inventory THEN
        IF pokemon EXISTS IN inventory[trainer_from] THEN
            CALL remove_pokemon(inventory, trainer_from, pokemon)
            CALL add_pokemon(inventory, trainer_to, pokemon)
            PRINT trainer_from + " traded " + pokemon + " to " + trainer_to + "."
        ELSE
            PRINT pokemon + " not found in " + trainer_from + "'s inventory."
        END IF
    ELSE
        PRINT "One or both trainers not found."
    END IF
END FUNCTION

FUNCTION display_inventory(inventory, trainer)
    IF trainer EXISTS IN inventory THEN
        PRINT trainer + "'s Inventory:"
        FOR EACH pokemon IN inventory[trainer] DO
            PRINT pokemon
        END FOR
    ELSE
        PRINT trainer + " not found."
    END IF
END FUNCTION




*/