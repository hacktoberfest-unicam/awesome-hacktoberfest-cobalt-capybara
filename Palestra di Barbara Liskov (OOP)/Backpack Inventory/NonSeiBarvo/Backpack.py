
class Backpack:

    def __init__(self):
        self.items = {}

    def add_item(self, item):
        """
        Add an item to the backpack.
        :param item: Item object to be added.
        :return: None
        """
        if item.name in self.items:
            self.items[item.name].quantity += item.quantity
        else:
            self.items[item.name] = item
        print(f"{item.quantity} {item.name}(s) added to the backpack.")

    def remove_item(self, item_name):
        """
        Remove an item from the backpack.
        :param item_name: Name of the item to be removed.
        :return: None
        """
        if item_name in self.items:
            self.items[item_name].quantity -= 1
            if self.items[item_name].quantity <= 0:
                del self.items[item_name]
            print(f"One {item_name} removed from the backpack.")
        else:
            print(f"{item_name} is not in the backpack.")

    def list_items(self):
        """
        Display all items in the backpack.
        :return: None
        """
        if not self.items:
            print("The backpack is empty.")
        else:
            for item in self.items.values():
                print(f"{item.name} ({item.category}): {item.quantity}")

    def find_item(self, item_name):
        """
        Find an item in the backpack.
        :param item_name: Name of the item to find.
        :return: Item object if found, None otherwise.
        """
        return self.items.get(item_name, None)


