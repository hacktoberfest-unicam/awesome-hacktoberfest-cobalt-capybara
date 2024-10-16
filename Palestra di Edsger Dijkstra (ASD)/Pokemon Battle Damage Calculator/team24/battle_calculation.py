from pokemon import Pokemon

bulbasaur = Pokemon("Bulbasaur", "Grass", 49, 49, ["Vine Whip", "Razor Leaf"], ["Fire"])
charmander = Pokemon("Charmander", "Fire", 52, 43, ["Ember", "Flamethrower"], ["Grass"])

damage = charmander.calculate_damage(bulbasaur)
print(f"Charmander infligge {damage} danni a Bulbasaur")