from move import Move
from enums.pokemons_enum import PokemonType


class Pokemon:
    def __init__(self, name: str, type, hp, moves, stats):
        """
        Initializes a Pokemon object with a name, type, hp, moves, and stats
        :param name: The name of the Pokemon
        :param type: The type of the Pokemon
        :param hp: The health points of the Pokemon
        :param moves: The moves the Pokemon can use (list of Move objects)
        :param stats: The stats of the Pokemon (attack, defense, speed, etc.)
        """
        self.name: str = name
        self.type: PokemonType = type
        self.hp: int = hp
        self.moves: [Move] = moves
        self.stats: {} = stats

    def attack(self, target: 'Pokemon', move: Move):
        """
        Attacks the target Pokemon with a move
        :param target: The target Pokemon
        :param move: The move used to attack the target Pokemon
        :return: None
        """
        target.hp -= move.damage
        print(f"{self.name} uses {move.name} on {target.name}!")

    def defend(self, damage: int):
        """
        Defends against an attack
        :param damage: The int amount of damage the Pokemon takes
        :return: None
        """
        self.hp -= damage
        print(f"{self.name} takes {damage} damage. {self.hp} HP left.")
