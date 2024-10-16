def linear_search(pokedex, name_or_id):
    for pokemon in pokedex:
        if pokemon["nome"] == name_or_id or pokemon["id"] == name_or_id:
            return pokemon
    return None

def main():
    pokedex = [
        {"id": 1, "nome": "Bulbasaur"},
        {"id": 2, "nome": "Ivysaur"},
        {"id": 3, "nome": "Venusaur"},
        {"id": 4, "nome": "Charmander"},
    ]
    
    search_key = "Charmander"
    result = linear_search(pokedex, search_key)
    
    if result is not None:
        print(pokedex)
        print("Pokémon trovato: " + str(result)) 
    else:
        print("Pokémon non trovato.")

main()
