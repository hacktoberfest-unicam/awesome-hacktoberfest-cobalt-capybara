# Pokémon Trading System Challenge
# Overview
# Welcome to the Pokémon Trading System Challenge! In this exercise, you will develop a simple program that simulates a trading system for Pokémon. This challenge is designed to help you understand and apply control structures and data management techniques in an imperative programming style while managing Pokémon inventories.
#
# Objective
# The primary objectives of this challenge are to:
#
# Learn how to use basic control structures (loops, conditionals) to manage program flow.
# Practice adding, removing, and trading Pokémon within a data structure, such as a list or dictionary.
# Develop skills in imperative programming, focusing on state management and data manipulation.
# Instructions
# 1. Setup
# Choose your preferred programming language from the list of accepted languages.
# Create a new project directory for this challenge.
# Initialize a Git repository in the project directory (optional).
# 2. Design the Trading System
# Create a simple trading system that can manage trainers and their Pokémon. The system should allow:
#
# Adding Pokémon to a trainer's inventory.
# Removing Pokémon from a trainer's inventory.
# Trading Pokémon between trainers.
# The Pokémon could be represented as strings (e.g., "Pikachu", "Charmander").
#
# 3. Implement the Functions
# Implement the following functions (or equivalent methods in your chosen language):
#
# add_pokemon(inventory, trainer, pokemon): Adds a Pokémon to a trainer's inventory.
# remove_pokemon(inventory, trainer, pokemon): Removes a Pokémon from a trainer's inventory, if it exists.
# trade_pokemon(inventory, trainer_from, trainer_to, pokemon): Trades a Pokémon from one trainer to another, if the trade is valid.
# display_inventory(inventory, trainer): Displays all Pokémon currently in a trainer's inventory.
# Example in Pseudocode:
# FUNCTION add_pokemon(inventory, trainer, pokemon)
#     IF trainer NOT EXISTS IN inventory THEN
#         CREATE inventory[trainer] AS EMPTY LIST
#     END IF
#     APPEND pokemon TO inventory[trainer]
#     PRINT pokemon + " added to " + trainer + "'s inventory."
# END FUNCTION
#
# FUNCTION remove_pokemon(inventory, trainer, pokemon)
#     IF trainer EXISTS IN inventory THEN
#         IF pokemon EXISTS IN inventory[trainer] THEN
#             REMOVE pokemon FROM inventory[trainer]
#             PRINT pokemon + " removed from " + trainer + "'s inventory."
#         ELSE
#             PRINT pokemon + " not found in " + trainer + "'s inventory."
#         END IF
#     ELSE
#         PRINT trainer + " not found."
#     END IF
# END FUNCTION
#
# FUNCTION trade_pokemon(inventory, trainer_from, trainer_to, pokemon)
#     IF trainer_from EXISTS IN inventory AND trainer_to EXISTS IN inventory THEN
#         IF pokemon EXISTS IN inventory[trainer_from] THEN
#             CALL remove_pokemon(inventory, trainer_from, pokemon)
#             CALL add_pokemon(inventory, trainer_to, pokemon)
#             PRINT trainer_from + " traded " + pokemon + " to " + trainer_to + "."
#         ELSE
#             PRINT pokemon + " not found in " + trainer_from + "'s inventory."
#         END IF
#     ELSE
#         PRINT "One or both trainers not found."
#     END IF
# END FUNCTION
#
# FUNCTION display_inventory(inventory, trainer)
#     IF trainer EXISTS IN inventory THEN
#         PRINT trainer + "'s Inventory:"
#         FOR EACH pokemon IN inventory[trainer] DO
#             PRINT pokemon
#         END FOR
#     ELSE
#         PRINT trainer + " not found."
#     END IF
# END FUNCTION
# 4. Interact with the Trading System
# Create a simple interface or main program loop that allows the user to interact with the trading system:
#
# The user should be able to add and remove Pokémon using commands or inputs.
# Allow the user to trade Pokémon between trainers.
# Display the inventory after each operation to reflect the current state.
# Example of a simple loop in Pseudocode:
# WHILE True DO
#     PRINT "Options: [1] Add Pokémon [2] Remove Pokémon [3] Trade Pokémon [4] Show Inventory [5] Quit"
#     SET choice TO GET USER INPUT
#
#     IF choice = "1" THEN
#         SET trainer TO GET USER INPUT "Enter trainer name: "
#         SET pokemon TO GET USER INPUT "Enter Pokémon to add: "
#         CALL add_pokemon(inventory, trainer, pokemon)
#     ELSE IF choice = "2" THEN
#         SET trainer TO GET USER INPUT "Enter trainer name: "
#         SET pokemon TO GET USER INPUT "Enter Pokémon to remove: "
#         CALL remove_pokemon(inventory, trainer, pokemon)
#     ELSE IF choice = "3" THEN
#         SET trainer_from TO GET USER INPUT "Enter trainer name to trade from: "
#         SET trainer_to TO GET USER INPUT "Enter trainer name to trade to: "
#         SET pokemon TO GET USER INPUT "Enter Pokémon to trade: "
#         CALL trade_pokemon(inventory, trainer_from, trainer_to, pokemon)
#     ELSE IF choice = "4" THEN
#         SET trainer TO GET USER INPUT "Enter trainer name: "
#         CALL display_inventory(inventory, trainer)
#     ELSE IF choice = "5" THEN
#         BREAK
#     ELSE
#         PRINT "Invalid option. Please choose again."
#     END IF
# END WHILE
# 5. Testing the Program
# Test your trading system by adding, removing, and trading Pokémon. Ensure that your program handles cases where:
#
# The user tries to trade a Pokémon not in the inventory.
# The user tries to remove a Pokémon that doesn’t exist in the trainer's inventory.
# The user attempts to trade with a trainer that doesn’t exist.
# 6. Optional Enhancements
# Allow for multiple Pokémon to be traded in a single transaction.
# Add error handling to manage invalid inputs gracefully.
# Implement a graphical user interface (GUI) for easier interactions.
# Accepted Languages
# You can choose to implement the solution in any of the following programming languages:
#
# JavaScript
# Java
# C#
# C++
# Python
# PHP
# Submission
# Create a GitHub repository for your project.
# Push your code to the repository.
# Ensure your repository includes the following files:
# Your implementation file.
# README.md (this file).
# Any additional files needed to run your program.


def add_pokemon(inventory, trainer, pokemon):
    if trainer not in inventory:
        inventory[trainer] = []
    inventory[trainer].append(pokemon)
    print(f"{pokemon} added to {trainer}'s inventory.")

def remove_pokemon(inventory, trainer, pokemon):
    if trainer in inventory:
        if pokemon in inventory[trainer]:
            inventory[trainer].remove(pokemon)
            print(f"{pokemon} removed from {trainer}'s inventory.")
        else:
            print(f"{pokemon} not found in {trainer}'s inventory.")
    else:
        print(f"{trainer} not found.")

def trade_pokemon(inventory, trainer_from, trainer_to, pokemon):
    if trainer_from in inventory and trainer_to in inventory:
        if pokemon in inventory[trainer_from]:
            remove_pokemon(inventory, trainer_from, pokemon)
            add_pokemon(inventory, trainer_to, pokemon)
            print(f"{trainer_from} traded {pokemon} to {trainer_to}.")
        else:
            print(f"{pokemon} not found in {trainer_from}'s inventory.")
    else:
        print("One or both trainers not found.")

def display_inventory(inventory, trainer):
    if trainer in inventory:
        print(f"{trainer}'s Inventory:")
        for pokemon in inventory[trainer]:
            print(pokemon)
    else:
        print(f"{trainer} not found.")

inventory = {}

def main():
    while True:
        print("Options: [1] Add Pokémon [2] Remove Pokémon [3] Trade Pokémon [4] Show Inventory [5] Quit")
        choice = input("Enter your choice: ")
        if choice == "1":
            trainer = input("Enter trainer name: ")
            pokemon = input("Enter Pokémon to add: ")
            add_pokemon(inventory, trainer, pokemon)
        elif choice == "2":
            trainer = input("Enter trainer name: ")
            pokemon = input("Enter Pokémon to remove: ")
            remove_pokemon(inventory, trainer, pokemon)
        elif choice == "3":
            trainer_from = input("Enter trainer name to trade from: ")
            trainer_to = input("Enter trainer name to trade to: ")
            pokemon = input("Enter Pokémon to trade: ")
            trade_pokemon(inventory, trainer_from, trainer_to, pokemon)
        elif choice == "4":
            trainer = input("Enter trainer name: ")
            display_inventory(inventory, trainer)
        elif choice == "5":
            break
        else:
            print("Invalid option. Please choose again.")

if __name__ == "__main__":
    main()













