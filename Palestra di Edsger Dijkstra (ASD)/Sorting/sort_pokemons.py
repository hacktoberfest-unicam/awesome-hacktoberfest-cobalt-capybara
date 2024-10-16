def quick_sort(pokemons):

    if len(pokemons) <= 1:
        return pokemons  # Base case: a list of 0 or 1 elements is already sorted

    pivot = pokemons[0]

    less = [pokemon for pokemon in pokemons[1:] if pokemon['hp'] < pivot['hp']]
    greater = [pokemon for pokemon in pokemons[1:] if pokemon['hp'] >= pivot['hp']]

    # Recursively sort the 'less' and 'greater' sub-lists and combine them
    return quick_sort(less) + [pivot] + quick_sort(greater)


def main():
    pokemons = [
        {"name": "Pikachu", "hp": 35},
        {"name": "Charizard", "hp": 78},
        {"name": "Bulbasaur", "hp": 45},
        {"name": "Squirtle", "hp": 44},
    ]

    # Print the original list
    print("Original list of Pokémon:")
    for pokemon in pokemons:
        print(pokemon)

    # Sort the list of Pokémon by HP using the quick_sort function
    sorted_pokemons = quick_sort(pokemons)

    # Print the sorted list
    print("\nSorted list of Pokémon by HP:")
    for pokemon in sorted_pokemons:
        print(pokemon)

if __name__ == "__main__":
    main()