from BattleDamageCalculator import Pokemon 

if __name__ == "__main__":
    # Define two Pokémon with moves
    charizard = Pokemon("Charizard", "Fire", 84, 78, [{"move_name": "Flamethrower", "power": 90}, {"move_name": "Fly", "power": 70}])
    blastoise = Pokemon("Blastoise", "Water", 83, 100, [{"move_name": "Hydro Pump", "power": 110}, {"move_name": "Ice Beam", "power": 90}])

    # Charizard attacks Blastoise
    damage = charizard.calculate_damage(blastoise, "Flamethrower")
    print(f"Charizard dealt {damage} damage to Blastoise!")

    # Blastoise attacks Charizard
    damage = blastoise.calculate_damage(charizard, "Hydro Pump")
    print(f"Blastoise dealt {damage} damage to Charizard!")