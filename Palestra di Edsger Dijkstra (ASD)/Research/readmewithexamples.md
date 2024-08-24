# Pokémon Search Challenge

## Overview
Welcome to the Pokémon Search Challenge! In this challenge, you will implement a search algorithm to find a specific Pokémon in a Pokedex. You can use any search algorithm of your choice, such as binary search or linear search.

## Objective
The primary objective of this challenge is to understand and implement search algorithms. By the end of this challenge, you should be able to:
- Implement a search algorithm.
- Understand the time complexity and efficiency of different search algorithms.
- Apply search algorithms to a practical problem.

## Accepted Languages
You can choose to implement the solution in any of the following programming languages:
- JavaScript
- Java
- C#
- C
- C++
- Haskell
- Python
- Go
- Rust
- PHP

## Instructions
1. **Setup the Environment:**
   - Ensure you have the necessary environment set up for your chosen programming language.
   - Create a new project directory for this challenge.
   - Initialize a Git repository in the project directory (optional).

2. **Dataset:**
   - You will be provided with a list of Pokémon, each having a name and ID.
   - Example:
     ```python
     pokedex = [
         {"id": 1, "name": "Bulbasaur"},
         {"id": 2, "name": "Ivysaur"},
         {"id": 3, "name": "Venusaur"},
         {"id": 4, "name": "Charmander"},
         # Add more Pokémon as needed
     ]
     ```

3. **Implement Search Algorithm:**
   - Choose any search algorithm (e.g., Binary Search, Linear Search) to find a specific Pokémon in the Pokedex.
   - Implement the chosen search algorithm in your preferred programming language.

4. **Code Structure:**
   - Create a file for your implementation (e.g., `search_pokemon.py` for Python, `SearchPokemon.java` for Java).
   - Implement the search function in this file.
   - The function should take the Pokedex list and the Pokémon name or ID as input and return the Pokémon details if found.

5. **Function Signatures:**
   - Ensure your search function follows the signature for your chosen language. Examples:
     - **Python:** `def search_pokemon(pokedex: list, name_or_id) -> dict`
     - **Java:** `public static Pokemon searchPokemon(List<Pokemon> pokedex, String nameOrId)`
     - **JavaScript:** `function searchPokemon(pokedex, nameOrId) { return pokemon; }`
     - **C#:** `public static Pokemon SearchPokemon(List<Pokemon> pokedex, string nameOrId)`
     - **C:** `Pokemon* search_pokemon(Pokemon pokedex[], int size, const char* name_or_id)`
     - **C++:** `Pokemon searchPokemon(std::vector<Pokemon> pokedex, std::string nameOrId)`
     - **Haskell:** `searchPokemon :: [Pokemon] -> String -> Maybe Pokemon`
     - **Go:** `func searchPokemon(pokedex []Pokemon, nameOrId string) *Pokemon`
     - **Rust:** `fn search_pokemon(pokedex: &Vec<Pokemon>, name_or_id: &str) -> Option<&Pokemon>`
     - **PHP:** `function searchPokemon(array $pokedex, $nameOrId): array`

6. **Testing:**
   - Create test cases to validate your search function.
   - Ensure that your implementation handles edge cases, such as an empty Pokedex or a Pokémon not found.

## Submission
- Create a GitHub repository for your project.
- Push your code to the repository.
- Ensure your repository includes the following files:
  - Your implementation file (e.g., `search_pokemon.py`, `SearchPokemon.java`).
  - `README.md` (this file).
  - `tests/` (directory containing your test cases).

## Example (Python)
```python
# search_pokemon.py

def linear_search(pokedex, name_or_id):
    for pokemon in pokedex:
        if pokemon["name"] == name_or_id or pokemon["id"] == name_or_id:
            return pokemon
    return None

if __name__ == "__main__":
    pokedex = [
        {"id": 1, "name": "Bulbasaur"},
        {"id": 2, "name": "Ivysaur"},
        {"id": 3, "name": "Venusaur"},
        {"id": 4, "name": "Charmander"},
    ]
    
    search_key = "Charmander"
    result = linear_search(pokedex, search_key)
    if result:
        print(f"Pokémon found: {result}")
    else:
        print("Pokémon not found.")

