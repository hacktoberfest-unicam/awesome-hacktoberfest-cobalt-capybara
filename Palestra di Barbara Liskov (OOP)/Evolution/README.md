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
   - Create a file for your implementation (e.g., `pokemon.py` for Python, `Pokemon.java` for Java).
   - Implement the `Pokemon` class and its derived classes in this file.
   - Ensure the `level_up` and `evolve` methods interact correctly with the Pokémon's attributes.

4. **Function Signatures:**
   - Ensure your methods follow the signature for your chosen language. Examples:
     - **Python:**
       ```python
       class Pokemon:
           def __init__(self, name, type, level, hp, moves):
               # Initialization code

           def level_up(self):
               # Level up code

           def evolve(self):
               # Evolve code
       ```
     - **Java:**
       ```java
       public class Pokemon {
           private String name;
           private String type;
           private int level;
           private int hp;
           private List<String> moves;

           public Pokemon(String name, String type, int level, int hp, List<String> moves) {
               // Initialization code
           }

           public void levelUp() {
               // Level up code
           }

           public Pokemon evolve() {
               // Evolve code
           }
       }
       ```
     - **JavaScript:**
       ```javascript
       class Pokemon {
           constructor(name, type, level, hp, moves) {
               // Initialization code
           }

           levelUp() {
               // Level up code
           }

           evolve() {
               // Evolve code
           }
       }
       ```
     - **C#:**
       ```csharp
       public class Pokemon {
           private string name;
           private string type;
           private int level;
           private int hp;
           private List<string> moves;

           public Pokemon(string name, string type, int level, int hp, List<string> moves) {
               // Initialization code
           }

           public void LevelUp() {
               // Level up code
           }

           public Pokemon Evolve() {
               // Evolve code
           }
       }
       ```
     - **C++:**
       ```cpp
       class Pokemon {
       private:
           std::string name;
           std::string type;
           int level;
           int hp;
           std::vector<std::string> moves;

       public:
           Pokemon(std::string name, std::string type, int level, int hp, std::vector<std::string> moves) {
               // Initialization code
           }

           void levelUp() {
               // Level up code
           }

           Pokemon* evolve() {
               // Evolve code
           }
       };
       ```
     - **PHP:**
       ```php
       class Pokemon {
           private $name;
           private $type;
           private $level;
           private $hp;
           private $moves;

           public function __construct($name, $type, $level, $hp, $moves) {
               // Initialization code
           }

           public function levelUp() {
               // Level up code
           }

           public function evolve() {
               // Evolve code
           }
       }
       ```

5. **Testing:**
   - Create test cases to validate your classes and their methods.
   - Ensure that your implementation handles edge cases, such as a Pokémon that cannot evolve or reaching the maximum level.

## Submission
- Create a GitHub repository for your project.
- Push your code to the repository.
- Ensure your repository includes the following files:
  - Your implementation file (e.g., `pokemon.py`, `Pokemon.java`).
  - `README.md` (this file).
  - `tests/` (directory containing your test cases).

## Example (Python)
```python
# pokemon.py

class Pokemon:
    def __init__(self, name, type, level, hp, moves):
        self.name = name
        self.type = type
        self.level = level
        self.hp = hp
        self.moves = moves

    def level_up(self):
        self.level += 1
        print(f"{self.name} leveled up to {self.level}!")
        self.evolve()

    def evolve(self):
        pass

class Charmander(Pokemon):
    def evolve(self):
        if self.level >= 16:
            print(f"{self.name} is evolving into Charmeleon!")
            return Charmeleon(self.name, self.type, self.level, self.hp, self.moves)

class Charmeleon(Pokemon):
    def evolve(self):
        if self.level >= 36:
            print(f"{self.name} is evolving into Charizard!")
            return Charizard(self.name, self.type, self.level, self.hp, self.moves)

class Charizard(Pokemon):
    pass

if __name__ == "__main__":
    charmander = Charmander("Charmander", "Fire", 15, 39, ["Scratch", "Ember"])
    charmander.level_up()  # Should evolve to Charmeleon at level 16
    charmander.level_up()  # Should remain Charmeleon

