# Pokémon Object-Oriented Programming Challenge

## Overview
Welcome to the Pokémon Object-Oriented Programming Challenge! In this challenge, you will define a class `Pokemon` with attributes and methods that represent a Pokémon's properties and actions. You will implement methods for attacking and defending to simulate a simple battle system.

## Objective
The primary objective of this challenge is to learn the basics of object-oriented programming (OOP). By the end of this challenge, you should be able to:
- Define a class with attributes and methods.
- Understand and apply the principles of encapsulation, inheritance, and polymorphism.
- Create objects and interact with their methods.

## Accepted Languages
You can choose to implement the solution in any of the following programming languages:
- JavaScript
- Java
- C#
- C++
- Python
- PHP

## Instructions
1. **Setup the Environment:**
   - Ensure you have the necessary environment set up for your chosen programming language.
   - Create a new project directory for this challenge.
   - Initialize a Git repository in the project directory (optional).

2. **Class Definition:**
   - Define a class `Pokemon` with the following attributes:
     - `name` (string)
     - `type` (string)
     - `hp` (integer, health points)
     - `moves` (list of strings)
   - Implement the following methods:
     - `attack(target, move)` - Simulate an attack on another Pokémon using a specified move.
     - `defend(damage)` - Reduce the Pokémon's HP based on the damage received.

3. **Code Structure:**
   - Create a file for your implementation (e.g., `pokemon.py` for Python, `Pokemon.java` for Java).
   - Implement the `Pokemon` class and its methods in this file.
   - The methods should interact with the Pokémon's attributes appropriately.

4. **Testing:**
   - Create test cases to validate your class and its methods.
   - Ensure that your implementation handles edge cases, such as a Pokémon attacking itself or having zero health points.

## Submission
- Create a GitHub repository for your project.
- Push your code to the repository.
- Ensure your repository includes the following files:
  - Your implementation file (e.g., `pokemon.py`, `Pokemon.java`).
  - `README.md` (this file).
  - `tests/` (directory containing your test cases).

## Pseudocode example
```pseudocode
CLASS Pokemon
    ATTRIBUTE name
    ATTRIBUTE type
    ATTRIBUTE hp
    ATTRIBUTE moves

    METHOD init(name, type, hp, moves)
        SET self.name TO name
        SET self.type TO type
        SET self.hp TO hp
        SET self.moves TO moves
    END METHOD

    METHOD attack(target, move)
        PRINT self.name + " uses " + move + " on " + target.name + "!"
        SET damage TO 10  # Example fixed damage
        CALL target.defend(damage)
    END METHOD

    METHOD defend(damage)
        SUBTRACT damage FROM self.hp
        PRINT self.name + " takes " + damage + " damage and now has " + self.hp + " HP left."
    END METHOD
END CLASS
```
# Example of creating Pokémon and simulating an attack
```
FUNCTION main()
    CREATE pikachu AS Pokemon("Pikachu", "Electric", 35, ["Thunder Shock", "Quick Attack"])
    CREATE charmander AS Pokemon("Charmander", "Fire", 39, ["Scratch", "Ember"])

    CALL pikachu.attack(charmander, "Thunder Shock")
END FUNCTION
```

