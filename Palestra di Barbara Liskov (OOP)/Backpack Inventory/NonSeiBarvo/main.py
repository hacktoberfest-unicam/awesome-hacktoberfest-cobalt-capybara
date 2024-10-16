
from Backpack import Backpack
from Item import Item

def main():
    backpack = Backpack()

    while True:
        print("Choose an option: [1] List Items, [2] Add Item, [3] Remove Item, [4] Exit\n")
        user_choice = input()

        if user_choice == "1":
            backpack.list_items()
        elif user_choice == "2":
            item_name = input("Enter item name: ")
            item_category = input("Enter item category: ")
            item_quantity = int(input("Enter item quantity: "))
            new_item = Item(item_name, item_category, item_quantity)
            backpack.add_item(new_item)
        elif user_choice == "3":
            item_name = input("Enter the name of the item to remove: ")
            backpack.remove_item(item_name)
        elif user_choice == "4":
            print("Exiting the program. Goodbye!")
            break
        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()