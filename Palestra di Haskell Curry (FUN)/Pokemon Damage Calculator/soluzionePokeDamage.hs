-- Define the possible Pokémon types
data Type = Normal | Fire | Water | Grass | Electric | Ice | Fighting | Poison | Ground | Flying | Psychic | Bug | Rock | Ghost | Dragon | Dark | Steel | Fairy
    deriving (Show, Eq)

-- Define the weaknesses table as a function that returns a damage multiplier
weaknessMultiplier :: Type -> Type -> Double
weaknessMultiplier Normal    Fighting = 2.0
weaknessMultiplier Normal    Ghost    = 0.0
weaknessMultiplier Fire      Water    = 2.0
weaknessMultiplier Fire      Grass    = 0.5
weaknessMultiplier Fire      Ice      = 0.5
weaknessMultiplier Fire      Fire     = 0.5
weaknessMultiplier Water     Electric = 2.0
weaknessMultiplier Water     Grass    = 2.0
weaknessMultiplier Water     Fire     = 0.5
weaknessMultiplier Grass     Fire     = 2.0
weaknessMultiplier Grass     Water    = 0.5
weaknessMultiplier Grass     Grass    = 0.5
weaknessMultiplier Grass     Ice      = 2.0
weaknessMultiplier Electric  Ground   = 0.0
weaknessMultiplier Electric  Water    = 0.5
-- I don't know all the combination... soooooo here a default function at the end ;)
weaknessMultiplier _         _        = 1.0

-- Define a move with a type and base damage
data Move = Move { moveType :: Type, baseDamage :: Double }
    deriving (Show)

-- Define a Pokemon with a type, HP, and possibly other stats, in that case it's really basic
data Pokemon = Pokemon {
    pokemonName :: String,
    pokemonType :: Type,
    hitPoints   :: Double
} deriving (Show)

-- Calculate the damage a Pokémon takes from a move, considering weaknesses defined above
calculateDamage :: Pokemon -> Move -> Double
calculateDamage (Pokemon _ pokeType _) (Move moveType baseDmg) =
    baseDmg * weaknessMultiplier pokeType moveType

-- Function to apply damage to a Pokémon, reducing its HP
applyDamage :: Pokemon -> Move -> Pokemon
applyDamage pokemon move =
    let damage = calculateDamage pokemon move
        newHP = max 0 (hitPoints pokemon - damage)  -- HP cannot go below 0
    in pokemon { hitPoints = newHP }

-- Calculate the total damage a Pokémon takes from a list of moves using foldl
applyAllMoves :: Pokemon -> [Move] -> Pokemon
applyAllMoves pokemon moves = foldl applyDamage pokemon moves

-- ESEMPIO DI UTILIZZO:
-- Defining some example moves (I'm not an expert on Pokemon, I hope that makes sense...)
thunderbolt = Move Electric 30
waterGun    = Move Water 25
flamethrower = Move Fire 50

-- Example Pokémon
bulbasaur :: Pokemon
bulbasaur = Pokemon { pokemonName = "Bulbasaur", pokemonType = Grass, hitPoints = 300 }

-- Example to calculate total damage taken by Bulbasaur, but you can change wherever you want for the sake of testing!
main :: IO ()
main = do
    let enemyMoves = [thunderbolt, waterGun, flamethrower]
    let damagedBulbasaur = applyAllMoves bulbasaur enemyMoves
    putStrLn $ pokemonName damagedBulbasaur ++ " now has " ++ show (hitPoints damagedBulbasaur) ++ " HP remaining."

