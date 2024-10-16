class Pokemon:
    _lastDamage = 0

    def __init__(self, name, hp, attack, defense = 1):
        self.name = name
        self.hp = hp
        self.attack = attack
        self.defense = defense

class PokemonDeck: #inventory
    def __init__(self):
        self.PokemonList = [] #Massimo 100 pokemon per deck
        self.N_Pokemons = 0
    def addPokemon(self, Pokemon):
        self.PokemonList.append(Pokemon)
        self.N_Pokemons += 1
    def tryRemovePokemon(self, Pokemon):
        self.PokemonList.remove(Pokemon)
        self.N_Pokemons -= 1


class Trainers:
    def __init__(self, name):
        self.Deck = PokemonDeck()
        self.name = name

def add_pokemon(Treiner, Pokemon):
    Treiner.Deck.addPokemon(Pokemon)

def remove_pokemon(Treiner, Pokemon):
    Treiner.Deck.tryRemovePokemon(Pokemon)

def try_trade_pokemon(Treiner1, Treiner2, Pokemon):
    if (Pokemon in Treiner1.Deck.PokemonList):
        Treiner1.Deck.tryRemovePokemon(Pokemon)
        Treiner2.Deck.addPokemon(Pokemon)
    elif (Pokemon in Treiner2.Deck.PokemonList):
        Treiner2.Deck.tryRemovePokemon(Pokemon)
        Treiner1.Deck.addPokemon(Pokemon)
    else:
        print("Nessun dei due traders ha il pokemon "+Pokemon.name)
def trade_pokemon(Treiner1, Treiner2, Pokemon):
    Treiner1.Deck.tryRemovePokemon(Pokemon)
    Treiner2.Deck.addPokemon(Pokemon)

def display_inventory(Treiner):
    for Pokemon in Treiner.Deck.PokemonList:
        print(Pokemon.name)
        print("---------")
        print(Pokemon.hp)
        print(Pokemon.attack)
        print(Pokemon.defense+ "\n")

#PokemonDatabase
PokemonDatabase = [
    Pokemon("Pica", 100, 50, 2),
    Pokemon("Geodude", 50, 45, 1),
    Pokemon("Giganotosaurus", 220, 125, 1.2)
]
TradersDatabase = [
    Trainers("Gino"),
    Trainers("Giorgia"),
    Trainers("Francesca")
]

def Main():
    print("welcome to the trading system!"+"\n")
    print("This is the list of avelable comands, please select the number of the comand to execute:")
    print("1) add a pokemon to a trader deck")
    print("2) remove a pokemon from a trader deck")
    print("3) transfer a pokemon between two traders")
    print("4) display the deck of a trader")
    print("5) exit")

    
    Imput = UI_IntInput("Comand : ")

    if (Imput == 1):
        print("Seleziona il trader")
        Trader = UI_ListaTraders(TradersDatabase)
        if (Trader == -1):
            Main()
            return
        print("Seleziona il pokemon che vuoi aggiungere")
        Pokemon = UI_ListaPokemon(PokemonDatabase)
        if (Pokemon == -1):
            Main()
            return
        add_pokemon(Trader, Pokemon)
    elif (Imput == 2):
        print("Seleziona il trader")
        Trader = UI_ListaTraders(TradersDatabase)
        if (Trader == -1):
            Main()
            return
        print("Seleziona il pokemon che vuoi rimuovere")
        Pokemon = UI_ListaPokemon(Trader.Deck.PokemonList)
        if (Pokemon == -1):
            Main()
            return
        remove_pokemon(Trader, Pokemon)
    elif (Imput == 3):
        print("Seleziona il trader origine")
        Trader1 = UI_ListaTraders(TradersDatabase)
        if (Trader1 == -1):
            Main()
            return
        print("Seleziona il trader destinazione")
        Trader2 = UI_ListaTraders(TradersDatabase)
        if (Trader2 == -1):
            Main()
            return
        
        print("Seleziona il pokemon che vuoi scambiare dal trader origine")
        Pokemon = UI_ListaPokemon(Trader1.Deck.PokemonList)
        if (Pokemon == -1):
            Main()
            return
        trade_pokemon(Trader1, Trader2, Pokemon)
    elif (Imput == 4):
        print("Seleziona il trader")
        Trader = UI_ListaTraders(TradersDatabase)
        if (Trader == -1):
            Main()
            return
        Visualizza_ListaPokemon(Trader.Deck.PokemonList)
    elif (Imput == 5):
        exit()
    else:
        print("Comando non valido ' ì '")
        Main()
        return
    Main()
def UI_ListaPokemon(ListaPokemon):
    Visualizza_ListaPokemon(ListaPokemon)
    input_r = UI_IntInput("Pokemon n: ")
    if (input_r > len(ListaPokemon) + 1 or input_r < 1):
        print("Numero invalido")
        return -1
    return ListaPokemon[input_r - 1]

def Visualizza_ListaPokemon(ListaPokemon):
    i = 1
    for Pokemon in ListaPokemon:
        print(str(i)+ ")" + Pokemon.name + "-" + "hp:" + str(Pokemon.hp)  + " attack:"+ str(Pokemon.attack)  + " defense:" + str(Pokemon.defense))
        i = i+1

def UI_ListaTraders(ListaTraders):
    i = 1
    for Trader in ListaTraders:
        print(str(i)+ ")" + Trader.name + "-")
        i = i+1
    input_r = int(UI_IntInput("Traders n: "))
    if (input_r > len(ListaTraders) + 1 or input_r < 1):
        print("Numero invalido")
        return -1
    return ListaTraders[input_r - 1]

def UI_IntInput(str):
    try:
        return int(input(str))
    except ValueError:
        print("User input is not an integer ):")
        return -1
Main()