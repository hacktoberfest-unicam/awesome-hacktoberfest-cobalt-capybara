class Pokemon:
    def __init__(self, name, hp, attack, defense):
        """
        Initialize the Pokemon with the given name, hp, attack, and defense
        :param name: the name of the pokemon
        :param hp: the hp of the pokemon
        :param attack: the attack of the pokemon
        :param defense: the defense of the pokemon
        """
        self.name = name
        self.hp = hp
        self.attack = attack
        self.defense = defense

    def __str__(self):
        return f'{self.name} has {self.hp} hp, {self.attack} attack, and {self.defense} defense.'

    def attack_pokemon(self, enemy):
        """
        Attack the enemy pokemon
        :param enemy: the pokemon to attack
        """
        damage = self.attack - enemy.defense
        enemy.hp -= damage
        print(f'{self.name} attacks {enemy.name} for {damage} damage!')
        print(f'{enemy.name} has {enemy.hp} hp remaining.')
        print('')

    def is_fainted(self):
        """
        Check if the pokemon has fainted
        :return: True if the pokemon has fainted, False otherwise
        """
        return self.hp <= 0

    def battle(self, enemy):
        print('Battle Start!')
        while not self.is_fainted() and not enemy.is_fainted():
            self.attack_pokemon(enemy)
            if enemy.is_fainted():
                print(f'{enemy.name} has fainted!')
                print(f'{self.name} wins the battle!')
                break
            enemy.attack_pokemon(self)
            if self.is_fainted():
                print(f'{self.name} has fainted!')
                print(f'{enemy.name} wins the battle!')
                break


def main():
    pikachu = Pokemon('Pikachu', 35, 55, 40)
    charmander = Pokemon('Charmander', 39, 52, 43)
    print('Battle start!')
    pikachu.battle(charmander)


if __name__ == '__main__':
    main()
