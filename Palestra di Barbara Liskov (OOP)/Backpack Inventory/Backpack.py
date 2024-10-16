class Item():
    def __init__(self, name, category,quantity):
        self.name = name
        self.category = category
        self.quantity = quantity
    def use(self):
        print(f'You use the {self.name}')


class Backpack():
    def __init__(self, items, capacity):
        self.items = items
        self.capacity = capacity

    def add_item(self, item):
        self.items.append(item)
    def remove_items(self, item):
        self.items.remove(item)
    def list_items(self):
        for item in self.items:
            print(item.quantity,item.name)
    def find_item(self, name):
        if name in [item.name for item in self.items]:
            return [item for item in self.items if item.name == name][0]
        return False


#menu
print("Scegli:\n1. Aggiungi oggetto\n2. Rimuovi oggetto\n3. Lista oggetti\n4. Usa\n5. Esci")
scelta = input()
backpack = Backpack([], 10)
while scelta != '5':
    if scelta == '1':
        name = input('Nome: ')
        category = input('Categoria: ')
        quantity = int(input('Quantità: '))
        item = Item(name, category, quantity)
        backpack.add_item(item)
    elif scelta == '2':
        name = input('Nome: ')
        if backpack.find_item(name)!= False:
            backpack.remove_items(backpack.find_item(name))
        else:
            print('Oggetto non trovato')
    elif scelta == '3':
        backpack.list_items()
    elif scelta == '4':
        name = input('Nome: ')
        if backpack.find_item(name)!= False:
            backpack.find_item(name).use()
            #subtract the quantity
            backpack.items[backpack.items.index(backpack.find_item(name))].quantity -= 1
            if backpack.find_item(name).quantity == 0:
                backpack.remove_items(backpack.find_item(name))

        else:
            print('Oggetto non trovato')
    print("Scegli:\n1. Aggiungi oggetto\n2. Rimuovi oggetto\n3. Lista oggetti\n4. Usa\n5. Esci")
    scelta = input()

print('Arrivederci')



