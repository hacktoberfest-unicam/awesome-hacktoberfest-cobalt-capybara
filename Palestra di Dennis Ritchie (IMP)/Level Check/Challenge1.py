class Level:
    def __init__(self):
        self.pari = []
        self.dispari = []
        self.pok = {
            "Charmander": 15,
            "Wartortle": 32,
            "Venusaur": 67,
            "Vaporeon": 54,
        }
        self.pokemon = []
        for n in self.pok:
            self.pokemon.append(n)
    def ordina(self):
        self.pari = []
        self.dispari = []
        for n in self.pokemon:
            if self.pok[n] % 2 == 0:
                self.pari.append(n)
            else:
                self.dispari.append(n)
        return self.pari, self.dispari


