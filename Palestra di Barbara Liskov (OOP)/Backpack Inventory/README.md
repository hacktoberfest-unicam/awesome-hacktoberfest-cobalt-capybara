# Pokémon Inventory Management Challenge (OOP)
## Overview
Welcome to the **Pokémon Inventory Management Challenge!** In this challenge, you'll create an object-oriented inventory system that simulates a Pokémon Trainer's backpack. You'll define classes to represent the backpack and items, allowing trainers to add or remove items just like in the Pokémon games. Interaction with the backpack will occur via the terminal, providing a hands-on experience with user input and output in your chosen programming language.

## Objective
The primary goal of this challenge is to enhance your understanding of Object-Oriented Programming (OOP) principles. By the end of this challenge, you should be able to:

- Implement classes and objects to model a real-world system.
- Utilize methods to manipulate object states and interact with users.
- Design a terminal-based interface for user interaction.

## Accepted Languages
You can choose to implement the solution in any of the following programming languages:
- JavaScript
- Java
- C#
- C++
- Python

## Instructions

### 1. **Class Definitions:**
Define a `Item` class with attributes and classes like:

- `name` (string)
- `category` (string) – Examples include "Potion", "Poké Ball", "Berry", "Key Item", etc. 
- `quantity` (integer)
- `use()` – Defines what happens when the item is used (optional).
  
Define a `Backpack` class with attributes and classes like:

- `items` (a collection of Item objects)
- `capacity` (integer) – Maximum number of items the backpack can hold (optional).
- `add_item(item)`– Adds an item to the backpack.
- `remove_item(item_name)` – Removes an item from the backpack.
- `list_items()` – Displays all items in the backpack.
- `find_item(item_name)` – Searches for an item in the backpack.

### 3. **Terminal Interaction:**
Implement a menu-driven interface that allows the user to:
- View all items in the backpack.
- Add a new item.
- Remove an existing item.
- Use an item (optional).
- Exit the program.
- Ensure the interface handles invalid inputs gracefully.
- 
### 3. **Core Functionalities to Implement:**
**Adding Items:**

- Prompt the user for item details (name, category, quantity).
- Create an Item object and add it to the backpack.
- If the item already exists, update its quantity.

**Removing Items:**

- Prompt the user for the item name to remove.
- Remove the item from the backpack or decrease its quantity.
- Handle cases where the item does not exist.
**Listing Items:**
- Display all items in the backpack, optionally grouped by category.
- Show item names and quantities.

## Submission
- Create a GitHub repository for your project.
- Push your code to the repository, ensuring it includes:
  - Your implementation files (e.g., backpack.py, Backpack.java).
  - A README.md file (this file).
  - A tests/ directory for any test scripts or cases you've created.
  
---

## Pseudocode Example

```pseudocode
  Copy code
  CLASS Item
      ATTRIBUTE name
      ATTRIBUTE category
      ATTRIBUTE quantity

      METHOD __init__(name, category, quantity)
          SET self.name TO name
          SET self.category TO category
          SET self.quantity TO quantity
      END METHOD

      METHOD use()
          PRINT "You used a " + self.name + "!"
          // Additional behavior can be implemented here
      END METHOD
  END CLASS

CLASS Backpack
    ATTRIBUTE items

    METHOD __init__()
        SET self.items TO empty dictionary
    END METHOD

    METHOD add_item(item)
        IF item.name IN self.items THEN
            INCREASE self.items[item.name].quantity BY item.quantity
        ELSE
            SET self.items[item.name] TO item
        END IF
        PRINT item.quantity + " " + item.name + "(s) added to the backpack."
    END METHOD

    METHOD remove_item(item_name)
        IF item_name IN self.items THEN
            DECREASE self.items[item_name].quantity BY 1
            IF self.items[item_name].quantity <= 0 THEN
                REMOVE item_name FROM self.items
            END IF
            PRINT "One " + item_name + " removed from the backpack."
        ELSE
            PRINT item_name + " is not in the backpack."
        END IF
    END METHOD

    METHOD list_items()
        IF self.items IS EMPTY THEN
            PRINT "The backpack is empty."
        ELSE
            FOR EACH item IN self.items VALUES
                PRINT item.name + " (" + item.category + "): " + item.quantity
            END FOR
        END IF
    END METHOD

    METHOD find_item(item_name)
        IF item_name IN self.items THEN
            RETURN self.items[item_name]
        ELSE
            RETURN NULL
        END IF
    END METHOD
END CLASS

// Main Program
CREATE backpack INSTANCE OF Backpack

WHILE TRUE
    PRINT "Choose an option:"
    PRINT "1. List Items"
    PRINT "2. Add Item"
    PRINT "3. Remove Item"
    PRINT "4. Use Item"
    PRINT "5. Exit"
    GET user_choice

    IF user_choice == 1 THEN
        CALL backpack.list_items()
    ELSE IF user_choice == 2 THEN
        PROMPT "Enter item name:"
        GET item_name
        PROMPT "Enter item category:"
        GET item_category
        PROMPT "Enter item quantity:"
        GET item_quantity
        CREATE new_item INSTANCE OF Item WITH item_name, item_category, item_quantity
        CALL backpack.add_item(new_item)
    ELSE IF user_choice == 3 THEN
        PROMPT "Enter the name of the item to remove:"
        GET item_name
        CALL backpack.remove_item(item_name)
    ELSE IF user_choice == 4 THEN
        PROMPT "Enter the name of the item to use:"
        GET item_name
        SET item TO backpack.find_item(item_name)
        IF item IS NOT NULL THEN
            CALL item.use()
            CALL backpack.remove_item(item_name)
        ELSE
            PRINT item_name + " is not in the backpack."
        END IF
    ELSE IF user_choice == 5 THEN
        PRINT "Exiting the program. Goodbye!"
        BREAK
    ELSE
        PRINT "Invalid choice. Please try again."
    END IF
END WHILE
```