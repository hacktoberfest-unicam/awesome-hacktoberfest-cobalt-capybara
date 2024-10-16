
from pokemon import Pokemon
from move import Move
import json

class Battle:
    def __init__(self, pokemon1:Pokemon, pokemon2:Pokemon):
        with open('effectiveness_chart.json') as file:
            effectiveness_chart = json.load(file)
        self.effectiveness_chart = effectiveness_chart
        self.pokemon1 = pokemon1
        self.pokemon2 = pokemon2


    @staticmethod
    def start_battle(pokemon1:Pokemon, pokemon2:Pokemon, selected_move=None):
        """
        Starts a battle between two Pokemon
        :param selected_move: The move the Pokemon will use
        :param pokemon1: The first Pokemon
        :param pokemon2: The second Pokemon
        """
        while pokemon1.hp > 0 and pokemon2.hp > 0:
            print(f"{pokemon1.name} HP: {pokemon1.hp}")
            print(f"{pokemon2.name} HP: {pokemon2.hp}")
            print("Select a move:")
            for i, move in enumerate(pokemon1.moves):
                print(f"{i}: {move.name}")
            move_index = int(input())
            selected_move = pokemon1.moves[move_index]
            pokemon1.attack(pokemon2, selected_move)
            if pokemon2.hp > 0:
                pokemon2.attack(pokemon1, selected_move)
        winner = pokemon1 if pokemon1.hp > 0 else pokemon2
        print(f"{winner.name} wins!")

    def calculate_damage(self, move:Move, target:Pokemon):
        """
        Calculates the damage dealt by a move to a target Pokemon
        :param move: The move used by the attacking Pokemon
        :param target: The target Pokemon
        :return: The damage dealt
        """
        effectiveness = self.effectiveness_chart[move.type.lower()][target.type.name.lower()]
        damage = move.damage * effectiveness
        return damage
