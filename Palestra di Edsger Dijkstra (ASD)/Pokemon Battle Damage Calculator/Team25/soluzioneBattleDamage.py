class Pokemon:
    def __init__(self, name, attack, defense, pokemon_type):
        self.name = name
        self.attack = attack
        # Here I invented a system where the damage should be higher than the defense to have an effect
        self.defense = defense
        self.pokemon_type = pokemon_type

    def __str__(self):
        return f"{self.name} (Type: {self.pokemon_type}, Attack: {self.attack}, Defense: {self.defense})"


class Battle:
    # Type effectiveness chart (hope it makes sense)
    type_effectiveness = {
        'Fire': {'Grass': 2, 'Water': 0.5, 'Fire': 1},
        'Water': {'Fire': 2, 'Grass': 0.5, 'Water': 1},
        'Grass': {'Water': 2, 'Fire': 0.5, 'Grass': 1}
    }

    @staticmethod
    def calculate_damage(attacker: Pokemon, defender: Pokemon):
        """
        Calculate damage inflicted by attacker on defender.
        Damage formula: Damage = (Attack - Defense) * Effectiveness
        Effectiveness is determined by type advantages.

        How it works it's based on the solution already presented on the FUN section ;)
        """
        # Base damage calculation
        base_damage = attacker.attack - defender.defense

        # Ensure base damage is not negative, a pokemon cannot disappear in the void :)
        if base_damage < 0:
            base_damage = 0

        # Get type effectiveness based on the chart
        effectiveness = Battle.get_type_effectiveness(attacker.pokemon_type, defender.pokemon_type)

        # Calculate total damage
        total_damage = base_damage * effectiveness
        return total_damage

    @staticmethod
    def get_type_effectiveness(attacker_type, defender_type):
        """
        Get the effectiveness multiplier based on Pokémon types.
        Returns 1 if no specific effectiveness is defined (default behavior)
        """
        return Battle.type_effectiveness.get(attacker_type, {}).get(defender_type, 1)


def main():
    # Create Pokémon
    charizard = Pokemon(name="Charizard", attack=84, defense=78, pokemon_type="Fire")
    venusaur = Pokemon(name="Venusaur", attack=82, defense=83, pokemon_type="Grass")
    blastoise = Pokemon(name="Blastoise", attack=83, defense=100, pokemon_type="Water")

    # Print Pokémon details
    print(charizard)
    print(venusaur)
    print(blastoise)

    # Battle scenarios
    print("\nBattle Scenarios:")
    
    damage_to_venusaur = Battle.calculate_damage(charizard, venusaur)
    print(f"{charizard.name} attacks {venusaur.name}: Damage = {damage_to_venusaur}")

    damage_to_blastoise = Battle.calculate_damage(venusaur, blastoise)
    print(f"{venusaur.name} attacks {blastoise.name}: Damage = {damage_to_blastoise}")

    damage_to_charizard = Battle.calculate_damage(blastoise, charizard)
    print(f"{blastoise.name} attacks {charizard.name}: Damage = {damage_to_charizard}")

if __name__ == "__main__":
    main()
