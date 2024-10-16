# Pokémon Battle Challenge

## Overview
Welcome to the Pokémon Battle Simulation Challenge! In this exercise, you will create a simple program that simulates a battle between two Pokémon using loops and conditional statements. This challenge is designed to help you grasp the basics of imperative programming, focusing on control flow through loops and conditionals.

## Objective
The primary objective of this challenge is to:
- Understand and apply basic programming constructs such as loops and conditionals.
- Simulate a turn-based battle where two Pokémon exchange attacks until one of them faints.
- Practice writing clean, structured, and well-documented code.

## Instructions
### 1. **Setup**
   - Choose your preferred programming language from the list of accepted languages.
   - Create a new project directory for this challenge.
   - Initialize a Git repository in the project directory (optional).

### 2. **Define the Pokémon**
   - Create a simple class or structure for a Pokémon with the following attributes:
     - `name`: The name of the Pokémon (e.g., "Pikachu").
     - `hp`: Health points (e.g., 100).
     - `attack`: Attack power (e.g., 20).
     - `defense`: Defense power (e.g., 15).

### 3. **Simulate the Battle**
   - Implement a function or method that simulates the battle. The battle should proceed in turns, with each Pokémon attacking the other until one of them runs out of HP.
   - The damage dealt should be calculated based on the attacker's attack power and the defender's defense power.
   - Use loops to alternate turns between the two Pokémon and conditionals to check if either Pokémon has fainted (i.e., `hp <= 0`).

### 4. **Testing the Program**
   - Test your battle simulation with different Pokémon having various levels of `hp`, `attack`, and `defense`.
   - Ensure the battle plays out logically, and the correct winner is declared at the end.

### 5. **Optional Enhancements**
   - Add additional features such as special moves, critical hits, or a randomized attack damage range.
   - Implement a simple UI or text-based interface to make the battle more interactive.

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
  - Your implementation file (e.g., `pokemon_battle.pseudo`).
  - `README.md` (this file).
  - Any additional files needed to run your program.

## Example in Pseudocode

```pseudocode
CLASS Pokemon
    ATTRIBUTE name
    ATTRIBUTE hp
    ATTRIBUTE attack
    ATTRIBUTE defense

    METHOD init(name, hp, attack, defense)
        SET self.name TO name
        SET self.hp TO hp
        SET self.attack TO attack
        SET self.defense TO defense
    END METHOD
END CLASS

FUNCTION battle(pokemon1, pokemon2)
    WHILE pokemon1.hp > 0 AND pokemon2.hp > 0 DO
        # Pokémon 1 attacks Pokémon 2
        SET damage TO MAX(pokemon1.attack - pokemon2.defense, 0)
        SET pokemon2.hp TO pokemon2.hp - damage
        PRINT pokemon1.name + " attacks " + pokemon2.name + " for " + damage + " damage. " + pokemon2.name + " has " + pokemon2.hp + " HP left."
        
        IF pokemon2.hp <= 0 THEN
            PRINT pokemon2.name + " has fainted! " + pokemon1.name + " wins!"
            BREAK
        END IF

        # Pokémon 2 attacks Pokémon 1
        SET damage TO MAX(pokemon2.attack - pokemon1.defense, 0)
        SET pokemon1.hp TO pokemon1.hp - damage
        PRINT pokemon2.name + " attacks " + pokemon1.name + " for " + damage + " damage. " + pokemon1.name + " has " + pokemon1.hp + " HP left."
        
        IF pokemon1.hp <= 0 THEN
            PRINT pokemon1.name + " has fainted! " + pokemon2.name + " wins!"
            BREAK
        END IF
    END WHILE
END FUNCTION

FUNCTION main()
    CREATE pikachu AS Pokemon("Pikachu", 100, 55, 40)
    CREATE bulbasaur AS Pokemon("Bulbasaur", 105, 50, 45)
    CALL battle(pikachu, bulbasaur)
END FUNCTION

