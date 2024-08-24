# Sfida 7: Simulazione di una Battaglia Pokémon

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
   - Example in Python:
     ```python
     class Pokemon:
         def __init__(self, name, hp, attack, defense):
             self.name = name
             self.hp = hp
             self.attack = attack
             self.defense = defense
     ```

### 3. **Simulate the Battle**
   - Implement a function or method that simulates the battle. The battle should proceed in turns, with each Pokémon attacking the other until one of them runs out of HP.
   - The damage dealt should be calculated based on the attacker's attack power and the defender's defense power.
   - Use loops to alternate turns between the two Pokémon and conditionals to check if either Pokémon has fainted (i.e., `hp <= 0`).
   - Example battle loop in Python:
     ```python
     def battle(pokemon1, pokemon2):
         while pokemon1.hp > 0 and pokemon2.hp > 0:
             # Pokémon 1 attacks Pokémon 2
             damage = max(pokemon1.attack - pokemon2.defense, 0)
             pokemon2.hp -= damage
             print(f"{pokemon1.name} attacks {pokemon2.name} for {damage} damage. {pokemon2.name} has {pokemon2.hp} HP left.")
             
             if pokemon2.hp <= 0:
                 print(f"{pokemon2.name} has fainted! {pokemon1.name} wins!")
                 break

             # Pokémon 2 attacks Pokémon 1
             damage = max(pokemon2.attack - pokemon1.defense, 0)
             pokemon1.hp -= damage
             print(f"{pokemon2.name} attacks {pokemon1.name} for {damage} damage. {pokemon1.name} has {pokemon1.hp} HP left.")
             
             if pokemon1.hp <= 0:
                 print(f"{pokemon1.name} has fainted! {pokemon2.name} wins!")
     ```

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
  - Your implementation file (e.g., `pokemon_battle.py` for Python).
  - `README.md` (this file).
  - Any additional files needed to run your program.

## Example (Python)
```python
class Pokemon:
    def __init__(self, name, hp, attack, defense):
        self.name = name
        self.hp = hp
        self.attack = attack
        self.defense = defense

def battle(pokemon1, pokemon2):
    while pokemon1.hp > 0 and pokemon2.hp > 0:
        # Pokémon 1 attacks Pokémon 2
        damage = max(pokemon1.attack - pokemon2.defense, 0)
        pokemon2.hp -= damage
        print(f"{pokemon1.name} attacks {pokemon2.name} for {damage} damage. {pokemon2.name} has {pokemon2.hp} HP left.")
        
        if pokemon2.hp <= 0:
            print(f"{pokemon2.name} has fainted! {pokemon1.name} wins!")
            break

        # Pokémon 2 attacks Pokémon 1
        damage = max(pokemon2.attack - pokemon1.defense, 0)
        pokemon1.hp -= damage
        print(f"{pokemon2.name} attacks {pokemon1.name} for {damage} damage. {pokemon1.name} has {pokemon1.hp} HP left.")
        
        if pokemon1.hp <= 0:
            print(f"{pokemon1.name} has fainted! {pokemon2.name} wins!")

if __name__ == "__main__":
    pikachu = Pokemon("Pikachu", 100, 55, 40)
    bulbasaur = Pokemon("Bulbasaur", 105, 50, 45)
    battle(pikachu, bulbasaur)

