# Pokémon Battle Arena Challenge (Advanced OOP)

## Overview
Welcome to the **Pokémon Battle Arena Challenge**! This challenge will push your understanding of Object-Oriented Programming (OOP) to the next level by having you build a complete battle system. You will define classes that represent Pokémon, moves, and a battle environment, utilizing advanced OOP concepts like inheritance, polymorphism, and composition to simulate a fully functional Pokémon battle.

## Objective
The primary goal of this challenge is to deepen your understanding of advanced OOP principles. By the end of this challenge, you should be able to:
- Implement class hierarchies using inheritance and polymorphism.
- Create objects that interact dynamically using method overriding and polymorphic behavior.
- Design modular and reusable code by applying composition.

## Accepted Languages
You can choose to implement the solution in any of the following programming languages:
- JavaScript
- Java
- C#
- C++
- Python

## Instructions

### 1. **Setup the Environment:**
   - Set up the necessary development environment for your chosen language.
   - Create a new project directory for this challenge.
   - (Optional) Initialize a Git repository to track your work.

### 2. **Class Definitions:**
   - Define a base `Pokemon` class with attributes like:
     - `name` (string)
     - `type` (string) – Fire, Water, Electric, etc.
     - `hp` (integer, health points)
     - `stats` (dictionary of attack, defense, speed, etc.)
     - `moves` (list of Move objects)
   - Implement subclasses for different types of Pokémon (e.g., `FirePokemon`, `WaterPokemon`), leveraging inheritance.
   - Define a `Move` class to represent individual attacks, with attributes like:
     - `name` (string)
     - `type` (string)
     - `damage` (integer)
     - `pp` (power points)

### 3. **Battle System:**
   - Implement a `Battle` class that manages battles between two Pokémon. This should include:
     - Turn-based logic where each Pokémon takes turns using moves.
     - Damage calculation based on move type, Pokémon type, and stats.
     - Handling of status effects (e.g., burn, paralyze) and special moves.
     - Logic for determining type effectiveness (e.g., Fire is weak to Water).

### 4. **Core Methods to Implement:**
   - `attack(target, move)` – One Pokémon attacks another, using a specific move.
   - `defend(damage)` – The target Pokémon defends and reduces its HP based on the attack.
   - `calculateDamage(move, target)` – Implement type advantages/disadvantages and critical hits.
   - `startBattle(pokemon1, pokemon2)` – Manage turns, moves, and outcomes in a battle.

### 5. **Additional Features:**
   - Implement status conditions such as burn, paralyze, or poison, and make them affect the battle.
   - Introduce additional battle mechanics like switching Pokémon or healing between turns.
   - Expand the system to allow multiple Pokémon on each side, such as in double battles.

## Code Structure
Create a file for your implementation (e.g., `battle.py` for Python, `Battle.java` for Java). 
Structure the code into logical blocks that handle Pokémon creation, move definitions, and battle logic.

## Testing
- Write test cases to simulate different battle scenarios (e.g., Fire vs. Water Pokémon, weak vs. strong moves).
- Test your classes to ensure damage calculation is correct and the battle proceeds as expected.
- Test status effects, turn order, and critical hits.

## Submission
- Create a GitHub repository for your project.
- Push your code to the repository, ensuring it includes:
  - Your implementation files (e.g., `battle.py`, `Battle.java`).
  - A `README.md` file (this file).
  - A `tests/` directory for test cases.

---

## Pseudocode Example

```pseudocode
CLASS Pokemon
    ATTRIBUTE name
    ATTRIBUTE type
    ATTRIBUTE hp
    ATTRIBUTE moves
    ATTRIBUTE stats

    METHOD init(name, type, hp, moves, stats)
        SET self.name TO name
        SET self.type TO type
        SET self.hp TO hp
        SET self.moves TO moves
        SET self.stats TO stats
    END METHOD

    METHOD attack(target, move)
        PRINT self.name + " uses " + move.name + " on " + target.name + "!"
        CALCULATE damage BASED ON move AND target.type
        CALL target.defend(damage)
    END METHOD

    METHOD defend(damage)
        SUBTRACT damage FROM self.hp
        PRINT self.name + " takes " + damage + " damage. " + self.hp + " HP left."
    END METHOD
END CLASS

CLASS Battle
    METHOD startBattle(pokemon1, pokemon2)
        WHILE pokemon1.hp > 0 AND pokemon2.hp > 0
            CALL pokemon1.attack(pokemon2, SELECTED_MOVE)
            IF pokemon2.hp > 0 THEN
                CALL pokemon2.attack(pokemon1, SELECTED_MOVE)
        END WHILE
        DECLARE winner BASED ON REMAINING hp
    END METHOD
END CLASS
```

