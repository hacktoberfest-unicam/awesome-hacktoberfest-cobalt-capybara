from abc import ABC
from typing import Callable, Optional, List


class Pokemon(ABC):
    name: str
    type: str
    level: int
    hp: int
    moves: list[str]

    evolution_level: int
    next_evolution: Callable[[], 'Pokemon']

    def __init__(self, name: str, type: str, level: int, hp: int, moves: List[str], evolution_level: int,
                 next_evolution: Optional[Callable[[], 'Pokemon']]):
        self.name = name
        self.type = type
        self.level = level
        self.hp = hp
        self.moves = moves
        self.evolution_level = evolution_level
        self.next_evolution = next_evolution

    def level_up(self)->'Pokemon':
        self.level += 1
        self.level = min(self.level, 100)
        print(f"{self.name} leveled up to {self.level}!")
        if self.level == self.evolution_level:
            return self.evolve()
        return self

    def evolve(self) -> 'Pokemon':
        evolution = self.next_evolution()
        print(f"{self.name} evolved to {evolution.name}!")
        return evolution


class Charmander(Pokemon):
    def __init__(self, hp, moves=None, level=0):
        if moves is None:
            moves = []
        self.evolution_level = 16
        super().__init__("Charmander", "Fire", level, hp, moves, 16, lambda: Charmeleon(self.hp, self.moves, self.level))


class Charmeleon(Pokemon):
    def __init__(self, hp, moves=None, level=0):
        if moves is None:
            moves = []
        self.evolution_level = 16
        super().__init__("Charmeleon", "Fire", level, hp, moves, 36, lambda: Charizard(self.hp, self.moves, self.level))


class Charizard(Pokemon):
    def __init__(self, hp, moves=[], level=0):
        self.evolution_level = 16
        super().__init__("Charizard", "Fire", level, hp, moves, -1, None)


def main():
    pokemon = Charmander(100, ["Attacco"])
    for i in range(100):
        pokemon = pokemon.level_up()

if __name__ == '__main__':
    main()