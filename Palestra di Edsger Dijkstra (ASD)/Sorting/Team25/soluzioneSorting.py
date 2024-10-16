class Pokemon:
    def __init__(self, name, hp):
        self.name = name
        self.hp = hp

    def __str__(self):
        return f"{self.name}: {self.hp}"

# 1. Bubble Sort
    """
    Bubble Sort works by repeatedly swapping adjacent elements if they
    are in the wrong order. It continues until the list is fully sorted of course.
    
    Time complexity: O(n^2) in the worst and average cases.
    Space complexity: O(1), as it works in-place.
    Information taken from the study book of ASD ;)
    """
def bubble_sort(pokemons):
    n = len(pokemons)
    for i in range(n - 1):
        for j in range(n - i - 1):
            if pokemons[j].hp > pokemons[j + 1].hp:
                # Swap pokemons[j] and pokemons[j+1]
                pokemons[j], pokemons[j + 1] = pokemons[j + 1], pokemons[j]

# 2. Quick Sort
    """
    Quick Sort is a divide-and-conquer algorithm (I like it!). 
    It selects a pivot element, partitions the array around the pivot, and recursively sorts the partitions.

    Time complexity: O(n log n) on average; O(n^2) in the worst case.
    Space complexity: O(log n) due to the recursion stack.
    Again, from the ASD study book ;)
    """
def quick_sort(pokemons, low, high):
    if low < high:
        pi = partition(pokemons, low, high)
        quick_sort(pokemons, low, pi - 1)  # Before pi
        quick_sort(pokemons, pi + 1, high) # After pi

# That was the difficult part of the algorithm, good luck if you haven't study for ASD :)
def partition(pokemons, low, high):
    pivot = pokemons[high].hp
    i = low - 1  # Index of smaller element
    for j in range(low, high):
        if pokemons[j].hp < pivot:
            i += 1
            pokemons[i], pokemons[j] = pokemons[j], pokemons[i]
    pokemons[i + 1], pokemons[high] = pokemons[high], pokemons[i + 1]
    return i + 1

# Helper function to print the list of Pokémon
def print_pokemons(pokemons):
    for pokemon in pokemons:
        print(pokemon)
    print()

# I create a main just for testing
def main():
    # Create a list of Pokémon
    pokemons = [
        Pokemon("Pikachu", 35),
        Pokemon("Charizard", 78),
        Pokemon("Bulbasaur", 45),
        Pokemon("Squirtle", 44)
    ]

    # Print the original list
    print("Original List:")
    print_pokemons(pokemons)

    # 1. Using Bubble Sort
    bubble_sorted = pokemons.copy()
    bubble_sort(bubble_sorted)
    print("After Bubble Sort:")
    print_pokemons(bubble_sorted)

    # 2. Using Quick Sort
    quick_sorted = pokemons.copy()
    quick_sort(quick_sorted, 0, len(quick_sorted) - 1)
    print("After Quick Sort:")
    print_pokemons(quick_sorted)

if __name__ == "__main__":
    main()
