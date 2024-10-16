def is_even(level):
    return (level % 2 == 0)

def sort_pokemon_levels(pk_levels):
    odd_levels = []
    even_levels = []

    for level in pk_levels:
        if(is_even(level)):
            even_levels.append(level)
        else:
            odd_levels.append(level)
    return odd_levels, even_levels
    
def main():
    pk_levels = [1,4,7,9,15,30,56,47,100]
    odd_levels, even_levels = sort_pokemon_levels(pk_levels)
    print("Odd levels: ",odd_levels)
    print("Even levels: ",even_levels)

main()