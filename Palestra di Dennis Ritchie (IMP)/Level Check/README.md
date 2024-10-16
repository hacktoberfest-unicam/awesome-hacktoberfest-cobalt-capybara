# Pokémon Level Sorting Challenge

## Overview

Welcome to the Pokémon Level Sorting Challenge! In this exercise, you will create a program that processes a list of Pokémon levels, determines whether each level is even or odd, and separates them into two distinct arrays. This challenge is designed to help you grasp the basics of imperative programming, focusing on control flow using loops and conditional statements.

## Objective

The primary objectives of this challenge are to:

- Understand and apply loops to iterate over arrays.
- Use conditional statements to check if a number is even or odd.
- Separate elements of an array based on a condition into two new arrays.
- Practice writing clean, structured, and well-documented code.

## Instructions
   
### 1. **Define the Pokémon**
   - Create an array that contains the levels of various Pokémon. For example:
   - Create a simple class or structure for a Pokémon with the following attributes:
     - `name`: The name of the Pokémon (e.g., "Pikachu").
     - `hp`: Health points (e.g., 100).
     - `attack`: Attack power (e.g., 20).
     - `defense`: Defense power (e.g., 15).

### 2. **Simulate the Battle**

   - Implement a function or method that simulates the battle. The battle should proceed in turns, with each Pokémon attacking the other until one of them runs out of HP.
   - The damage dealt should be calculated based on the attacker's attack power and the defender's defense power.
   - Use loops to alternate turns between the two Pokémon and conditionals to check if either Pokémon has fainted (i.e., `hp <= 0`).

### 3. **Testing the Program**

   - Test your battle simulation with different Pokémon having various levels of `hp`, `attack`, and `defense`.
   - Ensure the battle plays out logically, and the correct winner is declared at the end.

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


## Example Output

```plaintext
Battle Start!

Pikachu attacks Bulbasaur and deals 10 damage.
Bulbasaur's HP is now 90.

Bulbasaur attacks Pikachu and deals 8 damage.
Pikachu's HP is now 92.


Bulbasaur has fainted!
Pikachu wins the battle!
```

