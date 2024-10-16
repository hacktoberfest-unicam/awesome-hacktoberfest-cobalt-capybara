-- Define the possible Pokémon types
data Type = Normal | Fire | Water | Grass | Electric | Ice
    deriving (Show, Eq)

-- Define a Pokemon with a type, HP, and possibly other stats
data Pokemon = Pokemon {
    pokemonName :: String,
    pokemonType :: Type,
    hitPoints   :: Double
} deriving (Show)

-- Function to filter Pokémon by type
filterPokemonType :: Type -> [Pokemon] -> [Pokemon]
filterPokemonType targetType = filter (\pokemon -> pokemonType pokemon == targetType)

-- ESEMPIO DI UTILIZZO:
-- Example Pokémon list
pikachu :: Pokemon
pikachu = Pokemon { pokemonName = "Pikachu", pokemonType = Electric, hitPoints = 200 }

charizard :: Pokemon
charizard = Pokemon { pokemonName = "Charizard", pokemonType = Fire, hitPoints = 450 }

blastoise :: Pokemon
blastoise = Pokemon { pokemonName = "Blastoise", pokemonType = Water, hitPoints = 300 }

bulbasaur :: Pokemon
bulbasaur = Pokemon { pokemonName = "Bulbasaur", pokemonType = Grass, hitPoints = 200 }

-- Example usage with a list of pokemon, here I filter the grass type
main :: IO ()
main = do
    let pokemonList = [pikachu, charizard, blastoise, bulbasaur]
    let grassTypePokemons = filterPokemonType Grass pokemonList
    putStrLn "Grass-type Pokémon:"
    mapM_ (putStrLn . pokemonName) grassTypePokemons

