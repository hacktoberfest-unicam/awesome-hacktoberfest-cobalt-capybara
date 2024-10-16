# Pokémon Battle Damage Calculation Challenge

## Overview
Welcome to the Pokémon Battle Damage Calculation Challenge! In this exercise, you will create a program that simulates the calculation of damage dealt in a Pokémon battle. You will utilize various data structures to manage Pokémon attributes, moves, and their effectiveness in battle scenarios. This challenge is designed to deepen your understanding of algorithms and data structures through practical application.

## Objective
The primary objectives of this challenge are to:
- Utilize appropriate data structures to store and manage Pokémon attributes and move information.
- Apply mathematical algorithms to determine damage in a battle scenario based on attributes like attack, defense, and type advantages.
- Develop problem-solving skills by implementing algorithms that require logical reasoning and data manipulation.

## Accepted Languages
You can choose to implement the solution in any of the following programming languages:
- JavaScript
- Java
- C#
- C++
- Python
- PHP

## Instructions

### Setup the Environment
1. Ensure you have the necessary environment set up for your chosen programming language.
2. Create a new project directory for this challenge.
3. Initialize a Git repository in the project directory (optional).

### Class and Structure Definition
1. **Define Classes:**
   - Create a class `Pokemon` with the following attributes:
     - `name` (string): The name of the Pokémon.
     - `type` (string): The type of the Pokémon (e.g., Fire, Water).
     - `attack` (integer): The attack power of the Pokémon.
     - `defense` (integer): The defense power of the Pokémon.
     - `moves` (list of dictionaries): Each dictionary contains `move_name` (string) and `power` (integer) to represent the Pokémon's moves.
  
2. **Implement the Following Methods:**
   - `calculate_damage(target)` - Calculate the damage dealt to the target Pokémon based on the attacker's attributes and the target's defense.
   - `type_advantage(target)` - Determine if the attacker's move has a type advantage against the target's type.

### Code Structure
- Create a file for your implementation (e.g., `battle_calculation.py` for Python, `BattleCalculation.java` for Java).
- Implement the `Pokemon` class and its methods in this file.
- Ensure that your methods interact with the Pokémon's attributes appropriately.

### Testing
- Create test cases to validate your class and its methods.
- Ensure that your implementation handles edge cases, such as a Pokémon using a move with zero power or attacking a Pokémon with significantly higher defense.

## Submission
- Create a GitHub repository for your project.
- Push your code to the repository.
- Ensure your repository includes the following files:
  - Your implementation file (e.g., `battle_calculation.py`, `BattleCalculation.java`).
  - `README.md` (this file).
  - `tests/` (directory containing your test cases).

## Pseudocode Example
```pseudocode
CLASS Pokemon
    ATTRIBUTE name
    ATTRIBUTE type
    ATTRIBUTE attack
    ATTRIBUTE defense
    ATTRIBUTE moves

    METHOD init(name, type, attack, defense, moves)
        SET self.name TO name
        SET self.type TO type
        SET self.attack TO attack
        SET self.defense TO defense
        SET self.moves TO moves
    END METHOD

    METHOD calculate_damage(target)
        SET base_damage TO self.attack - target.defense
        IF base_damage < 0 THEN
            SET base_damage TO 0
        END IF
        RETURN base_damage * self.type_advantage(target)
    END METHOD

    METHOD type_advantage(target)
        # Implement logic for type advantage
    END METHOD
END CLASS
```

## Example of Simulating a Battle
```
FUNCTION main()
    CREATE pikachu AS Pokemon("Pikachu", "Electric", 55, 40, [{"move_name": "Thunderbolt", "power": 40}])
    CREATE charmander AS Pokemon("Charmander", "Fire", 52, 43, [{"move_name": "Ember", "power": 40}])

    SET damage TO pikachu.calculate_damage(charmander)
    PRINT pikachu.name + " deals " + damage + " damage to " + charmander.name + "!"
END FUNCTION
``` 

