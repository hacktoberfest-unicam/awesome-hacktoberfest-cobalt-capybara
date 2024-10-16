def is_even(n):
    return n % 2 == 0

def sort_pokemon_levels(pokemon):
    even_pokemon=[]
    odd_pokemon=[]
    for i in pokemon:
        if is_even(i):
            ev