def linear_search(pokedex, name_or_id):
    for pokemon in pokedex:
        # Search by ID if the input is an integer
        if isinstance(name_or_id, int) and pokemon['id'] == name_or_id:
            return pokemon
        # Search by name if the input is a string (case insensitive)
        if isinstance(name_or_id, str) and pokemon['name'].lower() == name_or_id.lower():
            return pokemon
    return None


def main():
    # Sample Pokédex dataset with ID and name
    pokedex = [
        {"id": 1, "name": "Bulbasaur"},
        {"id": 2, "name": "Ivysaur"},
        {"id": 3, "name": "Venusaur"},
        {"id": 4, "name": "Charmander"},
        {"id": 5, "name": "Pickachu"},
        {"id": 6, "name": "GigoloPuff"},
        {"id": 7, "name": "padrePio"},
        # You can add more Pokémon to the dataset
    ]
    search_query = input("Enter the name or ID of the Pokémon you want to search for: ")
    try:
        search_query = int(search_query)
    except ValueError:
        # If the conversion fails, assume the input is a name (string)
        pass

    # Call the search_pokemon function
    result = linear_search(pokedex, search_query)
    
    if result:
        print(f"Pokémon found: {result}")
    else:
        print("Pokémon not found in the Pokédex.")

if __name__ == "__main__":
    main()