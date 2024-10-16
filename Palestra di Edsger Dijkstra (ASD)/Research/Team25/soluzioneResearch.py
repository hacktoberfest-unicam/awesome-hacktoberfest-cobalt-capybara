# Define the linear search function 
def linear_search(pokedex, name_or_id):
    for pokemon in pokedex:
        # Check if the current Pokémon matches the search name or id
        if pokemon["name"] == name_or_id or pokemon["id"] == name_or_id:
            return pokemon
    return None

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
    
    # Search key, can be a Pokémon name or id
    search_key = "Charmander"  # Can also try with 4 or any other name/id
    
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
