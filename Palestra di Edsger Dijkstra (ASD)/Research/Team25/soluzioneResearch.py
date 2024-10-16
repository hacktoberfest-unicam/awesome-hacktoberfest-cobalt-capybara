# Define the linear search function 
def linear_search(pokedex, name_or_id):
    for pokemon in pokedex:
        # Check if the current Pokémon matches the search name or id
        if pokemon["name"] == name_or_id or pokemon["id"] == name_or_id:
            return pokemon
    return None

# Helper function to print the list of Pokémon
def print_pokemons(pokemons):
    for pokemon in pokemons:
        print(pokemon)
    print()

# Main function to execute the testing of search
def main():
    # Sample Pokedex (list of Pokémon with id and name)
    pokedex = [
        {"id": 1, "name": "Bulbasaur"},
        {"id": 2, "name": "Ivysaur"},
        {"id": 3, "name": "Venusaur"},
        {"id": 4, "name": "Charmander"},
        {"id": 5, "name": "Pikachu"},
    ]

    # Print the original list
    print("List:")
    print_pokemons(pokedex)
    
    ## Prompt user for input
    search_key = input("Enter the name or ID of the Pokémon to search: ")
    
    # Perform the linear search
    # Try to convert input to integer to search by ID
    try:
        search_key = int(search_key)  # Convert to integer if it's an ID
    except ValueError:
        pass  # Keep search_key as string if conversion fails
    
    # Perform the linear search
    result = linear_search(pokedex, search_key)
    
    # Check the result and print accordingly
    if result is not None:
        print("Pokémon found:", result)
    else:
        print("Pokémon not found.")

# Entry point of the script
if __name__ == "__main__":
    main()
