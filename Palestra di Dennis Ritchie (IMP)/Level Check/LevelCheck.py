def check_even_or_odd(num):
    """
    Function to check if a number is even or odd.
    :param num: int
    :return: str "even" or "odd"
    """
    if num % 2 == 0:
        return "even"
    else:
        return "odd"


def level_check(arr):
    """
    Function to separate elements of an array based on a condition into two new arrays.
    :param arr: list
    :return: tuple of two lists
    """
    even = []
    odd = []
    for num in arr:
        if check_even_or_odd(num) == "even":
            even.append(num)
        else:
            odd.append(num)
    return even, odd

def main():
    arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    even, odd = level_check(arr)
    print("Even numbers:", even)
    print("Odd numbers:", odd)

if __name__ == "__main__":
    main()
