# Pokémon Health Sorting Challenge

## Overview
Welcome to the Pokémon Health Sorting Challenge! In this challenge, you will implement an algorithm to sort a list of Pokémon based on their health points (HP). You are free to use any sorting algorithm of your choice (e.g., Bubble Sort, Merge Sort, Quick Sort, etc.).

## Objective
The primary objective of this challenge is to understand and implement sorting algorithms. By the end of this challenge, you should be able to:
- Implement a sorting algorithm of your choice.
- Understand the time complexity and efficiency of different sorting algorithms.
- Apply sorting algorithms to a practical problem.

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
   - You will be provided with a list of Pokémon, each having a name and health points (HP).
   - Example:
     ```pseudocode
     pokemons = [
         {"name": "Pikachu", "hp": 35},
         {"name": "Charizard", "hp": 78},
         {"name": "Bulbasaur", "hp": 45},
         {"name": "Squirtle", "hp": 44},
         # Add more Pokémon as needed
     ]
     ```

3. **Implement Sorting Algorithm:**
   - Choose any sorting algorithm (e.g., Bubble Sort, Merge Sort, Quick Sort) to sort the list of Pokémon by their health points in ascending order.
   - Implement the chosen sorting algorithm in your preferred programming language.

4. **Code Structure:**
   - Create a file for your implementation (e.g., `sort_pokemons.pseudo`).
   - Implement the sorting function in this file.
   - The function should take the list of Pokémon as input and return a sorted list.

5. **Function Signatures:**
   - Ensure your sorting function follows the signature for your chosen language. Examples:
     - **Pseudocode:** `FUNCTION sort_pokemons(pokemons) RETURNS sorted_pokemons`

6. **Testing:**
   - Create test cases to validate your sorting function.
   - Ensure that your implementation handles edge cases, such as an empty list or a list with one Pokémon.

## Submission
- Create a GitHub repository for your project.
- Push your code to the repository.
- Ensure your repository includes the following files:
  - Your implementation file (e.g., `sort_pokemons.pseudo`).
  - `README.md` (this file).
  - `tests/` (directory containing your test cases).

## Example in Pseudocode

```pseudocode
# sort_pokemons.pseudo

FUNCTION bubble_sort(pokemons)
    n = LENGTH(pokemons)
    FOR i FROM 0 TO n-1 DO
        FOR j FROM 0 TO n-i-2 DO
            IF pokemons[j]["hp"] > pokemons[j+1]["hp"] THEN
                SWAP pokemons[j] WITH pokemons[j+1]
            END IF
        END FOR
    END FOR
    RETURN pokemons
END FUNCTION

# Main execution starts here
FUNCTION main()
    pokemons = [
        {"name": "Pikachu", "hp": 35},
        {"name": "Charizard", "hp": 78},
        {"name": "Bulbasaur", "hp": 45},
        {"name": "Squirtle", "hp": 44},
    ]
    
    sorted_pokemons = bubble_sort(pokemons)
    PRINT "Sorted by HP: " + sorted_pokemons
END FUNCTION

