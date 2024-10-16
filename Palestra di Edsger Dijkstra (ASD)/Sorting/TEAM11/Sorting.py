def bubble_sort_by_hp(pokemons):
    n = len(pokemons)
    for i in range(n):
        switched = False
        for j in range(0, n - i - 1):
            if pokemons[j]["hp"] < pokemons[j + 1]["hp"]:
                pokemons[j], pokemons[j + 1] = pokemons[j + 1], pokemons[j]
                switched = True
        if (not switched):
            break


def main():
    pokemons = [
        {"name": "Pikachu", "hp": 35},
        {"name": "Charizard", "hp": 78},
        {"name": "Bulbasaur", "hp": 45},
        {"name": "Squirtle", "hp": 44},
    ]

    bubble_sort_by_hp(pokemons)
    print("sorted pokedex: ", pokemons)
main()