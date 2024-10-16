class Item:
    def __init__(self, name, category,quantity):
        self.name = name
        self.category = category
        self.quantity = quantity
    
    def use(self):
        print("You used a ", self.name,"!")

class Backpack:
    items = []
    capacity = 0
    quantity = 0

    def __init__(self, items, capacity, quantity):
        self.items = []
        self.capacity = capacity
        self.quantity = quantity

    def find_item(self,item_name):
        for item in self.items:
            if (item.name == item_name):
                return item
        return None

    def add_item(self,item):
        print("self quant ",self.quantity)
        print("item quant ",item.quantity)
        print("capacity ",self.capacity)
        if (self.quantity + item.quantity) > self.capacity: #checking if quantity > capacity
            print("Backpack capacity limit reached.")
            return 

        foundItem = self.find_item(item.name)
        if(foundItem != None):
            foundItem.quantity += item.quantity
            print(item.quantity ," ", item.name + "(s) added to the backpack.")
        else:
            self.items.append(item)
            print(item.quantity ," ", item.name + "(s) added to the backpack.")
        self.quantity += item.quantity #updating backpack quantity

    def remove_item(self,item_name):
        item = self.find_item(item_name)
        if(item == None):
            print("Item not found in the backpack.")
            return

        if(item_name == item.name): #if item already present I update the quantity
            if((item.quantity - 1) <= 0):
                self.items.remove(item)
                print(item_name + "(s) removed from the backpack.")
            else:
                item.quantity -= 1
                print("1 ", item_name + "(s) removed from the backpack.")
            return

    def use_item(self,item_name):
        item = self.find_item(item_name)
        item.use()
        self.remove_item(item_name)

    def list_items(self):
        if not self.items:
            print("The backpack is empty!")
        else:
            for item in self.items:
                print ("Item: ",item.name,", Category: ",item.category,", Quantity: ", item.quantity,".")
        return
    

def menu():
    choice = 1
    print("\n[1] List Items")
    print("[2] Add Item")
    print("[3] Remove Item")
    print("[4] Use Item")
    print("[0] Quit")
    choice = int(input("Select a choice [0-4]: "))
    return choice

def main():
    backpack = Backpack({} ,10, 0)
    choice = 1

    while(choice != 0):
        choice = menu()
        match choice:
            case 0:
                return

            case 1:
                backpack.list_items()
            case 2:
                itemName = input("Item name to add: ")
                itemCategory = input("Item category: ")
                itemQuantity = int(input("Quantity: "))

                item = Item(itemName, itemCategory, itemQuantity)
                backpack.add_item(item)
            
            case 3:
                itemName = input("Item name to remove: ")
                backpack.remove_item(itemName)
                
            case 4:
                itemName = input("Item name to use: ")
                backpack.use_item(itemName)
                
main()