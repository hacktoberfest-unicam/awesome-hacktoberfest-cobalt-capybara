-- To simulate the random catch feature
import System.Random (randomRIO)

-- Define the possible Pokémon types
data Type = Normal | Fire | Water | Grass | Electric | Ice
    deriving (Show, Eq)

-- Define a Pokemon with a name, type and HP, this time with a new catch rate for the new system
data Pokemon = Pokemon {
    pokemonName   :: String,
    pokemonType   :: Type,
    hp            :: Double,
    hitPoints     :: Double,
    catchRate     :: Double
} deriving (Show)

-- Define a Pokeball type with a catch multiplier (as simple as it seems, the higher the better)
data Pokeball = Pokeball {
    ballName       :: String,
    catchModifier  :: Double
} deriving (Show)

-- Function to attempt catching a Pokémon
catchPokemon :: Pokemon -> Pokeball -> IO Bool
catchPokemon pokemon ball = do
    let hpFactor = (hp pokemon - hitPoints pokemon) / hp pokemon -- I think more damage = easier to catch
        baseCatchChance = catchRate pokemon * catchModifier ball * hpFactor
    randomNumber <- randomRIO (0.0, 1.0)  -- Generate a random number between 0 and 1
    let success = randomNumber < baseCatchChance
    return success

-- Example Poké Balls
basicPokeball = Pokeball { ballName = "Poké Ball", catchModifier = 1.0 }
greatBall     = Pokeball { ballName = "Great Ball", catchModifier = 1.5 }
ultraBall     = Pokeball { ballName = "Ultra Ball", catchModifier = 2.0 }

-- Example Pokémon
pikachu :: Pokemon
pikachu = Pokemon { pokemonName = "Pikachu", pokemonType = Electric, hitPoints = 30, hp = 50, catchRate = 0.3 }

charizard :: Pokemon
charizard = Pokemon { pokemonName = "Charizard", pokemonType = Fire, hitPoints = 10, hp = 150, catchRate = 0.2 }

bulbasaur :: Pokemon
bulbasaur = Pokemon { pokemonName = "Bulbasaur", pokemonType = Grass, hitPoints = 40, hp = 100, catchRate = 0.25 }

-- Simulate an attempt to catch a Pokémon
simulateCatch :: Pokemon -> Pokeball -> IO ()
simulateCatch pokemon ball = do
    putStrLn $ "Throwing a " ++ ballName ball ++ " at " ++ pokemonName pokemon ++ "!"
    success <- catchPokemon pokemon ball
    if success
        then putStrLn $ "Success! You caught " ++ pokemonName pokemon ++ "!"
        else putStrLn $ pokemonName pokemon ++ " broke free!"

-- ESEMPIO DI UTILIZZO:
-- Example usage
main :: IO ()
main = do
    let pokemonToCatch = pikachu  -- Try with Pikachu (I don't know many pokemon...)
    let ballToUse = greatBall     -- Use a Great Ball
    simulateCatch pokemonToCatch ballToUse
