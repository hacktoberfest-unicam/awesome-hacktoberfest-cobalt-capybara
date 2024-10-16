def is_even(n):
    return n % 2 == 0

def sort_pokemon_levels(pokemon):
    even_pokemon=[]
    odd_pokemon=[]
    for i in pokemon:
        if is_even(i):
            even_pokemon.append(i)
        else:
            odd_pokemon.append(i)
    return even_pokemon, odd_pokemon

risposta=""
pokemon=[]
while risposta!="exit":
    risposta=input("Inserisci il livello del pokemon, 'exit' per uscire: ")
    if risposta=="exit":
        break
    else:
        pokemon.append(int(risposta))
risultato=sort_pokemon_levels(pokemon)
print("Pokemon con livello pari: ", risultato[0])
print("Pokemon con livello dispari: ", risultato[1])