def is_even(level):
    """
    Check if the given level is even
    :param level: the level to check
    :return: True if the level is even, False otherwise
    """
    return level % 2 == 0


def sort_pokemon_levels(pokemon_levels):
    """
    Sort the given pokemon levels into even and odd levels
    :param pokemon_levels: the list of pokemon levels
    :return: a tuple containing the even levels and odd levels
    """
    even_levels = []
    odd_levels = []
    for level in pokemon_levels:
        if is_even(level):
            even_levels.append(level)
        else:
            odd_levels.append(level)

    print("Even levels: ", even_levels)
    print("Odd levels: ", odd_levels)
    return even_levels, odd_levels

def main():
    input_levels = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    sort_pokemon_levels(input_levels)

if __name__ == '__main__':
    main()