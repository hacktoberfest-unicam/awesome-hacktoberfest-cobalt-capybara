
class Item:
    def __init__(self, name, category, quantity):
        self.name = name
        self.category = category
        self.quantity = quantity

    def use(self):
        print(f"You used a {self.name}!")