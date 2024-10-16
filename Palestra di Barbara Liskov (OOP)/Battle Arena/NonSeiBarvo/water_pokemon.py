from pokemon import Pokemon
from enums.pokemons_enum import PokemonType
from move import Move


class WaterPokemon(Pokemon):

    def __init__(self, name, type, hp, moves, stats):
        """
        Initializes a WaterPokemon object
        :param name: The name of the WaterPokemon
        :param type: The type of the WaterPokemon
        :param hp: The health points of the WaterPokemon
        :param moves: The moves the WaterPokemon can use (list of Move objects)
        :param stats: The stats of the WaterPokemon (attack, defense, speed, etc.)
        """
        super().__init__(name, PokemonType.WATER, hp, [], {})
        move1 = Move("Water Gun", "WATER", 6, 6)
        move2 = Move("Surf", "WATER", 8, 7)
        move3 = Move("Hydro Pump", "WATER", 10, 8)
        self.moves = [move1, move2, move3]
        self.type = type
        self.stats = {
            'attack': 8,
            'defense': 6,
            'speed': 5
        }
        self.hp = 25
