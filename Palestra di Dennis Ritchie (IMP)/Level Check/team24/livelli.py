def ispari(livello):
    return livello % 2 == 0

def ordina_livelli_pokemon(livelli):
    livelli_pari = []
    livelli_dispari = []
    for livello in livelli:
        if ispari(livello):
            livelli_pari.append(livello)
        else:
            livelli_dispari.append(livello)
    return livelli_pari, livelli_dispari

# Esempio di utilizzo:
livelli = [5, 10, 13, 24, 7, 18]
livelli_pari, livelli_dispari = ordina_livelli_pokemon(livelli)
print("Livelli Pari:", livelli_pari)
print("Livelli Dispari:", livelli_dispari)
