def search(pokedex, key, value):
    index = -1
    if key == "name":
        index = linear_search(pokedex, value)
    if key == "id":
        index = binary_search(pokedex, value)
    return index

# O(log n) assumendo che gli id siano in ordine
def binary_search(pokedex, pokemon_id):
    l, r = 0, len(pokedex) - 1
    while l <= r:
        mid = (l + r) // 2
        if pokedex[mid]["id"] == pokemon_id:
            return mid
        if pokedex[mid]["id"] > pokemon_id:
            r = mid - 1
        else:
            l = mid + 1
    return -1

# O(n)
def linear_search(pokedex, name):
    for i, pok in enumerate(pokedex):
        if pok["name"] == name:
            return i
    return -1

# ---------------
pokedex = [
    {"id": 1, "name": "Bulbasaur"},
    {"id": 2, "name": "Ivysaur"},
    {"id": 3, "name": "Venusaur"},
    {"id": 4, "name": "Charmander"},
    # Add more Pokémon as needed
]
def test_search_name(pokedex):
    index = search(pokedex, "name", "Venusaur")
    assert index == 2
    index = search(pokedex, "name", "")
    assert index == -1

def test_search_id(pokedex):
    index = search(pokedex, "id", 1)
    assert index == 0
    index = search(pokedex, "id", -1)
    assert index == -1
    index = search(pokedex, "id", 1000)
    assert index == -1

test_search_name(pokedex)
test_search_id(pokedex)