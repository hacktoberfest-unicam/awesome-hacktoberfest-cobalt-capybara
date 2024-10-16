# O(n log n) power sort
def inbuild_sorting(pokemons):
    return sorted(pokemons, key=lambda pokemon: pokemon["hp"])


# O(n^2)
def bubble_sort(pokemons):
    for i in range(len(pokemons)):
        for j in range(i + 1, len(pokemons)):
            if pokemons[i]["hp"] > pokemons[j]["hp"]:
                pokemons[i], pokemons[j] = pokemons[j], pokemons[i]
    return pokemons


# ------------------------
pokemons = [
    {"name": "Pikachu", "hp": 35},
    {"name": "Charizard", "hp": 78},
    {"name": "Bulbasaur", "hp": 45},
    {"name": "Squirtle", "hp": 44},
    # Add more Pokémon as needed
]
functions = [inbuild_sorting, bubble_sort]


def test_sort(sort_funciton, pokemons):
    sorted_pokemons = sort_funciton(pokemons)
    assert all(sorted_pokemons[i - 1]["hp"] <= sorted_pokemons[i]["hp"] for i in range(1, len(sorted_pokemons)))


def test_empty(sort_function):
    assert sort_function([]) == []


def test_one(sort_function):
    assert sort_function([{"name": "Squirtle", "hp": 44}]) == [{"name": "Squirtle", "hp": 44}]


def test_descending_order(sort_function, pokemons):
    reversed = sorted(pokemons, key=lambda pokemon: pokemon["hp"], reverse=True)
    test_sort(sort_function, reversed)


for fun in functions:
    test_sort(fun, pokemons)
    test_empty(fun)
    test_one(fun)
    test_descending_order(fun, pokemons)
