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
1. Write a recursive function to calculate the total damage suffered by the Pokémon. The function should take the following inputs:
- The Pokémon's type information.
- A list of enemy moves, each with its type and base damage.
- A weakness table that maps Pokémon types and move types to their respective damage multipliers.

2. Ensure that your function:
- Iterates through each enemy move recursively to compute the total damage.
- Applies the weakness multipliers based on the Pokémon's types and the move types.

## Submission
- Create a GitHub repository for your project.
- Push your code to the repository.
- Ensure your repository includes the following files:
  - Your implementation file.
  - `README.md` (this file).
  - `tests/` (directory containing your test cases).

## Example (Haskell)
```Haskell
import Data.Map (Map)
import qualified Data.Map as Map

main :: IO ()
main = do
  let pokemon = Pokemon "Bulbasaur" ["Grass", "Poison"]
      mosseNemiche = [Mossa "Ember" "Fire" 40, Mossa "Water Gun" "Water" 40]
      tabellaDebolezze = Map.fromList [ (("Grass", "Fire"), 2.0), (("Grass", "Water"), 0.5)
                                      , (("Poison", "Fire"), 1.0), (("Poison", "Water"), 1.0) ]
      dannoTotale = calcolaDannoTotale pokemon mosseNemiche tabellaDebolezze
  putStrLn $ "Danno totale: " ++ show dannoTotale


-- Definizione dei tipi di dati

-- Rappresenta un Pokémon
data Pokemon = Pokemon
  { nome :: String       -- Nome del Pokémon
  , tipi :: [String]     -- Lista dei tipi del Pokémon
  } deriving (Show)

-- Rappresenta una mossa nemica
data Mossa = Mossa
  { nomeMossa :: String  -- Nome della mossa
  , tipoMossa :: String  -- Tipo della mossa
  , dannoBase :: Int     -- Danno base della mossa
  } deriving (Show)

calcolaDannoTotale :: Pokemon -> [Mossa] -> Map (String, String) Double -> Double
calcolaDannoTotale pokemon mosse tabellaDebolezze =
-- Implementa la funzione qui
