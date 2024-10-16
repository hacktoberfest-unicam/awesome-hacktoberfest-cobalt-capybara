def searchPokemon(pokedex, name):
    for pokemon in pokedex:
        if (pokemon['name'] == name):
            return pokemon
    return None

def main():
    pokedex = [
        {"id": 1, "name": "Bulbasaur"},
        {"id": 2, "name": "Ivysaur"},
        {"id": 3, "name": "Venusaur"},
        {"id": 4, "name": "Charmander"},
    ]

    pkmnSearched = "Charmander"
    result = searchPokemon(pokedex, pkmnSearched)
    if (result == None):
        print("Pokemon not found")
    else: 
        print("Pokemon found: ", result)

main()
    