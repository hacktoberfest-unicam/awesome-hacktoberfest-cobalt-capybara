from pokemon import Pokemon
from enums.pokemons_enum import PokemonType
from move import Move


class FirePokemon(Pokemon):

    def __init__(self, name, type, hp, moves, stats):
        """
        Initializes a FirePokemon object
        :param name: The name of the FirePokemon
        :param type: The type of the FirePokemon
        :param hp: The health points of the FirePokemon
        :param moves: The moves the FirePokemon can use (list of Move objects)
        :param stats: The stats of the FirePokemon (attack, defense, speed, etc.)
        """
        super().__init__(name, PokemonType.FIRE, hp, moves, stats)
        move1 = Move("Fire Blast", "FIRE", 10, 5)
        move2 = Move("Flamethrower", "FIRE", 8, 4)
        move3 = Move("Thunder", "ELECTRIC", 12, 6)
        self.moves = [move1, move2, move3]

        self.stats = {
            'attack': 10,
            'defense': 5,
            'speed': 7
        }
        self.type = type
        self.hp = 20
