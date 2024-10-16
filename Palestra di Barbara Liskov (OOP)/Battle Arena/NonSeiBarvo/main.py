from battle import Battle
from fire_pokemon import FirePokemon
from water_pokemon import WaterPokemon
from enums.pokemons_enum import PokemonType


def main():
    print("Welcome to the Battle Arena!\n Choose your Pokemon: \n 1. Charmander \n 2. Squirtle")
    choice = int(input())
    Pokemon1 = FirePokemon("Charmander", PokemonType.FIRE, 20, [], {})
    Pokemon2 = WaterPokemon("Squirtle", PokemonType.WATER, 25, [], {})
    if choice == 1:
        print("You chose Charmander!")

    elif choice == 2:
        print("You chose Squirtle!")

    else:
        print("Invalid choice. You automatically get Charmander!")

    Battle.start_battle(Pokemon1, Pokemon2)


if __name__ == "__main__":
    main()
