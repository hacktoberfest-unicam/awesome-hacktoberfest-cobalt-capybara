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

4. **Function Signatures:**
   - Ensure your methods follow the signature for your chosen language. Examples:
     - **Python:**
       ```python
       class Pokemon:
           def __init__(self, name, type, hp, moves):
               # Initialization code

           def attack(self, target, move):
               # Attack code

           def defend(self, damage):
               # Defend code
       ```
     - **Java:**
       ```java
       public class Pokemon {
           private String name;
           private String type;
           private int hp;
           private List<String> moves;

           public Pokemon(String name, String type, int hp, List<String> moves) {
               // Initialization code
           }

           public void attack(Pokemon target, String move) {
               // Attack code
           }

           public void defend(int damage) {
               // Defend code
           }
       }
       ```
     - **JavaScript:**
       ```javascript
       class Pokemon {
           constructor(name, type, hp, moves) {
               // Initialization code
           }

           attack(target, move) {
               // Attack code
           }

           defend(damage) {
               // Defend code
           }
       }
       ```
     - **C#:**
       ```csharp
       public class Pokemon {
           private string name;
           private string type;
           private int hp;
           private List<string> moves;

           public Pokemon(string name, string type, int hp, List<string> moves) {
               // Initialization code
           }

           public void Attack(Pokemon target, string move) {
               // Attack code
           }

           public void Defend(int damage) {
               // Defend code
           }
       }
       ```
     - **C++:**
       ```cpp
       class Pokemon {
       private:
           std::string name;
           std::string type;
           int hp;
           std::vector<std::string> moves;

       public:
           Pokemon(std::string name, std::string type, int hp, std::vector<std::string> moves) {
               // Initialization code
           }

           void attack(Pokemon& target, std::string move) {
               // Attack code
           }

           void defend(int damage) {
               // Defend code
           }
       };
       ```
     - **PHP:**
       ```php
       class Pokemon {
           private $name;
           private $type;
           private $hp;
           private $moves;

           public function __construct($name, $type, $hp, $moves) {
               // Initialization code
           }

           public function attack($target, $move) {
               // Attack code
           }

           public function defend($damage) {
               // Defend code
           }
       }
       ```

5. **Testing:**
   - Create test cases to validate your class and its methods.
   - Ensure that your implementation handles edge cases, such as a Pokémon attacking itself or having zero health points.

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
    def __init__(self, name, type, hp, moves):
        self.name = name
        self.type = type
        self.hp = hp
        self.moves = moves

    def attack(self, target, move):
        print(f"{self.name} uses {move} on {target.name}!")
        damage = 10  # Simplified fixed damage for example
        target.defend(damage)

    def defend(self, damage):
        self.hp -= damage
        print(f"{self.name} takes {damage} damage and now has {self.hp} HP left.")

if __name__ == "__main__":
    pikachu = Pokemon("Pikachu", "Electric", 35, ["Thunder Shock", "Quick Attack"])
    charmander = Pokemon("Charmander", "Fire", 39, ["Scratch", "Ember"])

    pikachu.attack(charmander, "Thunder Shock")

