class Move:
    def __init__(self, name, type: str, damage: int, pp: int):
        self.name: str = name
        self.type: str = type
        self.damage: int = damage
        self.pp: int = pp
