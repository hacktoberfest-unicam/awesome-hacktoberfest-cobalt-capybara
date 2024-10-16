#FUNCTION is_even(level)
#     RETURN level % 2 == 0
# END FUNCTION
#
# FUNCTION sort_pokemon_levels(levels)
#     even_levels = []
#     odd_levels = []
#     FOR EACH level IN levels
#         IF is_even(level) THEN
#             APPEND level TO even_levels
#         ELSE
#             APPEND level TO odd_levels
#         END IF
#     END FOR
#     RETURN even_levels, odd_levels
# END FUNCTION

def is_even(level):
    return level % 2 == 0

def sort_pokemon_levels(levels):
    even_levels = []
    odd_levels = []
    for level in levels:
        if is_even(level):
            even_levels.append(level)
        else:
            odd_levels.append(level)
    print(even_levels)
    print(odd_levels)