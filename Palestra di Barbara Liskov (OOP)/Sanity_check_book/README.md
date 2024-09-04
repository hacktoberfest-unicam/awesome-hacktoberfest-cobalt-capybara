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
- PHP

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

5. **Function Signatures:**
   - Ensure your methods follow the signature conventions of your chosen language. Examples:

     - **Python:**
       ```python
       class Book:
           def __init__(self, title, author, isbn):
               # Initialization code

           def get_info(self):
               # Return book info

           def borrow(self):
               # Borrow the book

           def return_book(self):
               # Return the book
       ```

     - **Java:**
       ```java
       public class Book {
           private String title;
           private String author;
           private String isbn;
           private boolean available;

           public Book(String title, String author, String isbn) {
               // Initialization code
           }

           public String getInfo() {
               // Return book info
           }

           public String borrow() {
               // Borrow the book
           }

           public String returnBook() {
               // Return the book
           }
       }
       ```

     - **JavaScript:**
       ```javascript
       class Book {
           constructor(title, author, isbn) {
               // Initialization code
           }

           getInfo() {
               // Return book info
           }

           borrow() {
               // Borrow the book
           }

           returnBook() {
               // Return the book
           }
       }
       ```

     - **C#:**
       ```csharp
       public class Book {
           private string title;
           private string author;
           private string isbn;
           private bool available;

           public Book(string title, string author, string isbn) {
               // Initialization code
           }

           public string GetInfo() {
               // Return book info
           }

           public string Borrow() {
               // Borrow the book
           }

           public string ReturnBook() {
               // Return the book
           }
       }
       ```

     - **C++:**
       ```cpp
       class Book {
       private:
           std::string title;
           std::string author;
           std::string isbn;
           bool available;

       public:
           Book(std::string title, std::string author, std::string isbn) {
               // Initialization code
           }

           std::string getInfo() {
               // Return book info
           }

           std::string borrow() {
               // Borrow the book
           }

           std::string returnBook() {
               // Return the book
           }
       };
       ```

     - **PHP:**
       ```php
       class Book {
           private $title;
           private $author;
           private $isbn;
           private $available;

           public function __construct($title, $author, $isbn) {
               // Initialization code
           }

           public function getInfo() {
               // Return book info
           }

           public function borrow() {
               // Borrow the book
           }

           public function returnBook() {
               // Return the book
           }
       }
       ```

6. **Testing:**
   - Create test cases to validate your class and its methods.
   - Ensure that your implementation handles edge cases, such as attempting to borrow an already borrowed book.

## Submission
- Create a GitHub repository for your project.
- Push your code to the repository.
- Ensure your repository includes the following files:
  - Your implementation file (e.g., `book.py`, `Book.java`).
  - `README.md` (this file).
  - `tests/` (directory containing your test cases).
