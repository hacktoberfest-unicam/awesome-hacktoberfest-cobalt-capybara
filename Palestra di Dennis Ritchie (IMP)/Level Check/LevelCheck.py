

pokemon_levels_list = [1, 5, 12, 6, 9, 11]

def level_check(pokemon_levels_list):
    for level in pokemon_levels_list:
        if level % 2 == 0:
            print(f"{level} is an even number.")
        else:
            print(f"{level} is an odd number.")

level_check(pokemon_levels_list)
