# Pokémon Level Sorting Challenge

## Overview
Welcome to the **Pokémon Level Sorting Challenge**! In this exercise, you will create a program that processes a list of Pokémon levels, determines whether each level is even or odd, and sorts them into two separate arrays. This challenge is designed to help you understand and apply basic programming concepts like loops and conditionals in an imperative programming style.

## Objective
The primary objectives of this challenge are to:
- Understand and apply loops to iterate through arrays.
- Use conditional statements to check if a number is even or odd.
- Separate the elements of an array based on a condition into two new arrays (one for even numbers and one for odd numbers).
- Practice writing clean, structured, and well-documented code.

## Instructions

### 1. Setup
- Choose your preferred programming language from the list of accepted languages (e.g., Python, JavaScript, Java, C++).
- Create a new project directory for this challenge.
- Initialize a Git repository in the project directory (optional).

### 2. Processing the Pokémon Levels
- You will be given an array of Pokémon levels (integers).
- Your task is to iterate over this array, checking each level to determine whether it is **even** or **odd**.
- Based on the result, separate the levels into two new arrays: one for **even levels** and one for **odd levels**.

### 3. Implement the Functions
Implement the following functions (or their equivalent in your chosen language):

- **is_even(level)**: A helper function that returns `True` if the given level is even and `False` if the level is odd.
- **sort_pokemon_levels(levels)**: This function should:
  - Accept an array of levels.
  - Use a loop to check each level using the `is_even` function.
  - Sort the levels into two separate arrays: one for even levels and one for odd levels.
  - Return both arrays.

Example in Pseudocode:
```pseudo
FUNCTION is_even(level)
    RETURN level % 2 == 0
END FUNCTION

FUNCTION sort_pokemon_levels(levels)
    even_levels = []
    odd_levels = []
    FOR EACH level IN levels
        IF is_even(level) THEN
            APPEND level TO even_levels
        ELSE
            APPEND level TO odd_levels
        END IF
    END FOR
    RETURN even_levels, odd_levels
END FUNCTION
```

### 4. Output the Result
- After processing the levels, display both arrays (even and odd) to the user.
- Example output:
  ```
  Even Levels: [12, 34, 56]
  Odd Levels: [11, 33, 55]
  ```

### 5. Testing the Program
- Test your program by providing different arrays of Pokémon levels to ensure that it properly separates even and odd numbers.
- Edge cases to consider:
  - An empty array.
  - Arrays with only even or only odd numbers.
  - Arrays with negative numbers (optional).

### 6. Optional Enhancements
- Sort the even and odd arrays in ascending or descending order before displaying them.
- Add error handling for invalid inputs (e.g., non-integer values).

## Example

Sample input array of Pokémon levels:
```python
levels = [5, 10, 15, 20, 25, 30]
```

Expected output:
```
Even Levels: [10, 20, 30]
Odd Levels: [5, 15, 25]
```

## Accepted Languages
You can choose to implement the solution in any of the following programming languages:
- Python
- JavaScript
- Java
- C++
- C#

## Submission
To submit your solution, follow these steps:
1. Create a GitHub repository for your project.
2. Push your code to the repository.
3. Ensure your repository includes the following files:
   - Your implementation file.
   - A `README.md` file (this file).
   - Any additional files required to run your program.
