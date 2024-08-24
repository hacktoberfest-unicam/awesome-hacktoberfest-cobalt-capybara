# Pokémon Evolution System Challenge

## Overview
Welcome to the Pokémon Evolution System Challenge! In this challenge, you will create a class that manages the evolution of Pokémon when they reach a certain level. You will use inheritance and polymorphism to design a flexible and scalable system.

## Objective
The primary objective of this challenge is to understand and apply the concepts of inheritance and polymorphism. By the end of this challenge, you should be able to:
- Define base and derived classes.
- Implement methods that demonstrate polymorphic behavior.
- Create a system that evolves Pokémon based on their level.

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

2. **Class Definitions:**
   - Define a base class `Pokemon` with attributes:
     - `name` (string)
     - `type` (string)
     - `level` (integer)
     - `hp` (integer, health points)
     - `moves` (list of strings)
   - Define derived classes for specific Pokémon that can evolve, such as `Charmander`, `Charmeleon`, and `Charizard`.
   - Implement a method `level_up` in the `Pokemon` class to increase the level of a Pokémon.
   - Implement a method `evolve` that handles the evolution of a Pokémon when it reaches a certain level.

3. **Code Structure:**
   - Create a file for your implementation (e.g., `pokemon.pseudo`).
   - Implement the `Pokemon` class and its derived classes in this file.
   - Ensure the `level_up` and `evolve` methods interact correctly with the Pokémon's attributes.

4. **Pseudocode Example**

```pseudocode
CLASS Pokemon
    ATTRIBUTE name
    ATTRIBUTE type
    ATTRIBUTE level
    ATTRIBUTE hp
    ATTRIBUTE moves

    METHOD init(name, type, level, hp, moves)
        SET self.name TO name
        SET self.type TO type
        SET self.level TO level
        SET self.hp TO hp
        SET self.moves TO moves
    END METHOD

    METHOD level_up()
        ADD 1 TO self.level
        PRINT self.name + " leveled up to " + self.level + "!"
        CALL self.evolve()
    END METHOD

    METHOD evolve()
        # Base method to be overridden by derived classes
    END METHOD
END CLASS

CLASS Charmander EXTENDS Pokemon
    METHOD evolve()
        IF self.level >= 16 THEN
            PRINT self.name + " is evolving into Charmeleon!"
            RETURN CREATE Charmeleon(self.name, self.type, self.level, self.hp, self.moves)
        END IF
    END METHOD
END CLASS

CLASS Charmeleon EXTENDS Pokemon
    METHOD evolve()
        IF self.level >= 36 THEN
            PRINT self.name + " is evolving into Charizard!"
            RETURN CREATE Charizard(self.name, self.type, self.level, self.hp, self.moves)
        END IF
    END METHOD
END CLASS

CLASS Charizard EXTENDS Pokemon
    # Charizard does not evolve further
END CLASS

FUNCTION main()
    CREATE charmander AS Charmander("Charmander", "Fire", 15, 39, ["Scratch", "Ember"])
    CALL charmander.level_up()  # Should evolve to Charmeleon at level 16
    CALL charmander.level_up()  # Should remain Charmeleon
END FUNCTION

