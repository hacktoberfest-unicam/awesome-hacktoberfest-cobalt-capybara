# Challenge: Sanity Check - Basic Array Manipulation

## Overview
Welcome to the "Sanity Check" challenge in the Palestra di Dennis Ritchie! This challenge focuses on ensuring that you are comfortable with basic array operations and manipulation in an imperative programming context. It will help you practice handling arrays, iterating through them, and performing simple operations like summing elements or finding the maximum value.

## Objective
The primary objective of this challenge is to:
- Understand and implement basic array manipulation techniques.
- Use loops to iterate over arrays.
- Perform simple calculations or operations on array elements.

## Task Description
In this challenge, you will write a program that reads a list of integers from the user, stores them in an array, and then performs the following operations:
1. Calculate the sum of all elements in the array.
2. Find the maximum value in the array.
3. Reverse the array and print the reversed array.

## Instructions
1. **Setup the Environment:**
   - Ensure you have the necessary environment set up for your chosen programming language.
   - Create a new project directory for this challenge.
   - Initialize a Git repository in the project directory (optional).

2. **Write the Program:**
   - Your task is to implement functions to:
     1. Calculate the sum of all elements in an array.
     2. Find the maximum value in an array.
     3. Reverse the elements of the array.

3. **Array Operations:**
   - Use loops to iterate over the array for summing elements and finding the maximum value.
   - Use a loop or a built-in function (if applicable) to reverse the array.

4. **Code Structure:**
   - Create a file for your implementation (e.g., `array_manipulation.c` for C, `ArrayManipulation.java` for Java).
   - Implement the logic in a straightforward, imperative style.

5. **Function Signatures:**
   - Ensure your functions follow the signature for your chosen language. Examples:
     - **C:**
       ```c
       int calculate_sum(int arr[], int size);
       int find_max(int arr[], int size);
       void reverse_array(int arr[], int size);
       ```
     - **Java:**
       ```java
       public static int calculateSum(int[] arr);
       public static int findMax(int[] arr);
       public static void reverseArray(int[] arr);
       ```
     - **Python:**
       ```python
       def calculate_sum(arr: list) -> int:
       def find_max(arr: list) -> int:
       def reverse_array(arr: list) -> list:
       ```
     - **JavaScript:**
       ```javascript
       function calculateSum(arr) {
       }
       function findMax(arr) {
       }
       function reverseArray(arr) {
       ```
     - **Go:**
       ```go
       func calculateSum(arr []int) int {
       }
       func findMax(arr []int) int {
       }
       func reverseArray(arr []int) []int {
       ```

6. **Testing:**
   - Test your program with various input arrays, including arrays of different lengths and containing negative numbers.
   - Make sure your program handles edge cases, such as an empty array or an array with all elements being the same.

## Submission
- Create a GitHub repository for your project.
- Push your code to the repository.
- Ensure your repository includes the following files:
  - Your implementation file (e.g., `array_manipulation.c`, `ArrayManipulation.java`).
  - `README.md` (this file).
  - `tests/` (directory containing your test cases, if applicable).

