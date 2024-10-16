# Pokémon Damage Calculator Challenge

## Overview
Implements a function that, given a Pokémon and a list of enemy moves, calculates the total damage the Pokémon would suffer considering the Pokémon's type weaknesses. <br>
Use a weakness table to determine how vulnerable the Pokémon is to enemy move types. <br>
Weaknesses are expressed as damage multipliers (e.g. a "Grass" type Pokémon is weak to the "Fire" type with a multiplier of 2.0). <br>

## Objective
The primary objective of this challenge is to implement a function that calculates the total damage a Pokémon would suffer from a list of enemy moves, taking into account the Pokémon's type weaknesses. You will achieve this by: <br>
- Using a weakness table to determine how vulnerable the Pokémon is to different enemy move types.
- Computing the damage multiplier based on the Pokémon's types and the move types.
- Summing up the total damage suffered by the Pokémon from all enemy moves, considering the calculated multipliers.

## Accepted Languages
You can choose to implement the solution in any of the following programming languages:
- Java
- Haskell
- Python

## Instructions
1. Add new pokemon moves in the mosseNemiche list
2. Add new weaknesses in the tabellaDebolezze list (Use this site to get info on the real weaknesses https://www.pkmn.help/defense/)
1. Write a recursive function to calculate the total damage suffered by the Pokémon. The function should take the following inputs: <br>
  -- The Pokémon's type information. <br>
  -- A list of enemy moves, each with its type and base damage. <br>
  -- A weakness table that maps Pokémon types and move types to their respective damage multipliers.<br>

4. Ensure that your function:<br>
  -- Iterates through each enemy move recursively to compute the total damage.<br>
  -- Applies the weakness multipliers based on the Pokémon's types and the move types.<br>

## Submission
- Create a GitHub repository for your project.
- Push your code to the repository.
- Ensure your repository includes the following files:
  - Your implementation file.
  - `README.md` (this file).
  - `tests/` (directory containing your test cases).