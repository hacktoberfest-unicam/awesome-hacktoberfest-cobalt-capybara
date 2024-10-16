data PokemonType = Acqua | Fuoco | Erba
    deriving (Show, Eq)

data Pokemon = Pokemon {
    nome :: String,
    tipi :: [PokemonType]  
} deriving (Show)

pokemonList :: [Pokemon]
pokemonList = [
    Pokemon "Bulbasaur" [Erba],
    Pokemon "Charmander" [Fuoco],
    Pokemon "Squirtle" [Acqua]
    ]


typeFilter :: PokemonType -> [Pokemon] -> [Pokemon]
typeFilter tipo = filter (\p -> tipo ⁠ elem ⁠ (tipi p))


main :: IO ()
main = do
    let t = Acqua
    let searchedPokemon = typeFilter t pokemonList
    print "Pokemon types "
    print t
    print searchedPokemon