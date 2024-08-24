# Managing an Item Inventory

## Overview
Welcome to the Item Inventory Management Challenge! In this exercise, you will implement a simple system to manage an inventory of items such as potions, Pokéballs, and other in-game objects. This challenge is designed to help you understand and apply control structures and data management techniques in an imperative programming style.

## Objective
The primary objectives of this challenge are to:
- Learn how to use basic control structures (loops, conditionals) to manage program flow.
- Practice adding, removing, and managing items within a data structure, such as a list or dictionary.
- Develop skills in imperative programming, focusing on state management and data manipulation.

## Instructions

### 1. **Setup**
   - Choose your preferred programming language from the list of accepted languages.
   - Create a new project directory for this challenge.
   - Initialize a Git repository in the project directory (optional).

### 2. **Design the Inventory System**
   - Create a simple inventory system that can store items. The system should allow:
     - Adding items to the inventory.
     - Removing items from the inventory.
     - Displaying the current list of items in the inventory.
   - The items could be represented as strings (e.g., `"Potion"`, `"Pokéball"`).

### 3. **Implement the Functions**
   - Implement the following functions (or equivalent methods in your chosen language):
     - `add_item(inventory, item)`: Adds an item to the inventory.
     - `remove_item(inventory, item)`: Removes an item from the inventory, if it exists.
     - `display_inventory(inventory)`: Displays all items currently in the inventory.

   - Example in Pseudocode:
     ```
     FUNCTION add_item(inventory, item)
         APPEND item TO inventory
         PRINT item + " added to inventory."
     END FUNCTION

     FUNCTION remove_item(inventory, item)
         IF item EXISTS IN inventory THEN
             REMOVE item FROM inventory
             PRINT item + " removed from inventory."
         ELSE
             PRINT item + " not found in inventory."
         END IF
     END FUNCTION

     FUNCTION display_inventory(inventory)
         PRINT "Current Inventory:"
         FOR EACH item IN inventory DO
             PRINT item
         END FOR
     END FUNCTION
     ```

### 4. **Interact with the Inventory**
   - Create a simple interface or main program loop that allows the user to interact with the inventory:
     - The user should be able to add and remove items using commands or inputs.
     - Display the inventory after each operation to reflect the current state.

   - Example of a simple loop in Pseudocode:
     ```
     WHILE True DO
         PRINT "Options: [1] Add Item [2] Remove Item [3] Show Inventory [4] Quit"
         SET choice TO GET USER INPUT

         IF choice = "1" THEN
             SET item TO GET USER INPUT "Enter item to add: "
             CALL add_item(inventory, item)
         ELSE IF choice = "2" THEN
             SET item TO GET USER INPUT "Enter item to remove: "
             CALL remove_item(inventory, item)
         ELSE IF choice = "3" THEN
             CALL display_inventory(inventory)
         ELSE IF choice = "4" THEN
             BREAK
         ELSE
             PRINT "Invalid option. Please choose again."
         END IF
     END WHILE
     ```

### 5. **Testing the Program**
   - Test your inventory system by adding, removing, and displaying items.
   - Ensure that your program handles cases where the user tries to remove an item that doesn’t exist in the inventory.

### 6. **Optional Enhancements**
   - Allow for quantity management by storing the number of each item in the inventory.
   - Add categories for items (e.g., healing items, capture items) and allow users to view items by category.

## Accepted Languages
You can choose to implement the solution in any of the following programming languages:
- JavaScript
- Java
- C#
- C++
- Python
- PHP

## Submission
- Create a GitHub repository for your project.
- Push your code to the repository.
- Ensure your repository includes the following files:
  - Your implementation file.
  - `README.md` (this file).
  - Any additional files needed to run your program.

## Example (Pseudocode)
```pseudocode
FUNCTION add_item(inventory, item)
    APPEND item TO inventory
    PRINT item + " added to inventory."
END FUNCTION

FUNCTION remove_item(inventory, item)
    IF item EXISTS IN inventory THEN
        REMOVE item FROM inventory
        PRINT item + " removed from inventory."
    ELSE
        PRINT item + " not found in inventory."
    END IF
END FUNCTION

FUNCTION display_inventory(inventory)
    PRINT "Current Inventory:"
    FOR EACH item IN inventory DO
        PRINT item
    END FOR
END FUNCTION

WHILE True DO
    PRINT "Options: [1] Add Item [2] Remove Item [3] Show Inventory [4] Quit"
    SET choice TO GET USER INPUT

    IF choice = "1" THEN
        SET item TO GET USER INPUT "Enter item to add: "
        CALL add_item(inventory, item)
    ELSE IF choice = "2" THEN
        SET item TO GET USER INPUT "Enter item to remove: "
        CALL remove_item(inventory, item)
    ELSE IF choice = "3" THEN
        CALL display_inventory(inventory)
    ELSE IF choice = "4" THEN
        BREAK
    ELSE
        PRINT "Invalid option. Please choose again."
    END IF
END WHILE

