# Sanity Check - Basic Class Implementation

## Overview
Welcome to the Sanity Check Challenge! This challenge is designed to ensure you have a solid understanding of the fundamental concepts of Object-Oriented Programming (OOP). In this challenge, you will create a simple `Book` class that models a basic book in a library. This exercise will help confirm your ability to define classes, manage private attributes, and implement basic methods.

## Objective
The primary objective of this challenge is to:
- Verify your understanding of class creation and object-oriented principles.
- Practice defining private attributes and providing methods to interact with them.
- Ensure you can implement simple, yet functional, classes that model real-world entities.

## Accepted Languages
You can choose to implement the solution in any of the following programming languages:
- JavaScript
- Java
- C#
- C++
- Python

## Instructions

1. **Setup the Environment:**
   - Ensure you have the necessary environment set up for your chosen programming language.
   - Create a new project directory for this challenge.
   - Initialize a Git repository in the project directory (optional).

2. **Class Definition:**
   - Define a class named `Book` that models a basic book in a library.
   - The class should have the following **private** attributes:
     - `title` (string): The title of the book.
     - `author` (string): The author of the book.
     - `isbn` (string): The ISBN number of the book.
     - `available` (boolean): A flag indicating if the book is available for borrowing (default is `True`).

3. **Methods:**
   - Implement the following methods in the `Book` class:
     - `get_info()` - Returns a string containing the book's title, author, and ISBN.
     - `borrow()` - If the book is available, sets `available` to `False` and returns a message indicating that the book has been borrowed. If not available, returns a message that the book is already borrowed.
     - `return_book()` - Sets `available` to `True` and returns a message indicating that the book has been returned.

4. **Code Structure:**
   - Create a file for your implementation (e.g., `book.py` for Python, `Book.java` for Java).
   - Implement the `Book` class and its methods in this file.

5. **Testing:**
   - Create test cases to validate your class and its methods.
   - Ensure that your implementation handles edge cases, such as attempting to borrow an already borrowed book.

## Submission
- Create a GitHub repository for your project.
- Push your code to the repository.
- Ensure your repository includes the following files:
  - Your implementation file (e.g., `book.py`, `Book.java`).
  - `README.md` (this file).
  - `tests/` (directory containing your test cases).
