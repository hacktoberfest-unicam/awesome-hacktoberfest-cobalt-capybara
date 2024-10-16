
def main():
    pokemons = [
        {"name": "Pikachu", "hp": 35},
        {"name": "Charizard", "hp": 78},
        {"name": "Bulbasaur", "hp": 45},
        {"name": "Squirtle", "hp": 44},
    ]
    sorted_pokemons = bubble_sort(pokemons)
    print("Sorted by HP: "+ str(sorted_pokemons))

pokemon = []
def bubble_sort(pokemon:list):
    n = len(pokemon)
    for i in range(0,n-1):
        for j in range(0,n-i-2):
            if(pokemon[j]["hp"]>pokemon[j+1]["hp"]):
                pokemon[j], pokemon[j+1] = pokemon[j+1], pokemon[j]
    return pokemon

main()
        