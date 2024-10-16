data Pokeball = Pokeball | Megaball | Ultraball deriving (Show, Read)

catchRate :: Int -> Float
catchRate level
    | level >= 0 && level <= 10 = 80 
    | level > 10 && level <= 20 = 70 
    | level > 20 && level <= 30 = 60
    | level > 40 && level <= 50 = 50
    | otherwise = 20  

pokeballBonus :: Pokeball -> Float
pokeballBonus Pokeball = 0    
pokeballBonus Megaball = 0.2    
pokeballBonus Ultraball = 1.0   

finalCatchRate :: Int -> Pokeball -> Float
finalCatchRate level ball = baseRate + (baseRate * pokeballBonus ball)
  where baseRate = catchRate level

main :: IO ()
main = do
    putStrLn "Insert Pokemon Level:"
    inputLevel <- getLine
    let level = read inputLevel :: Int

    putStrLn "Insert Type of Pokeball (Pokeball, Megaball, Ultraball):"
    inputBall <- getLine
    let ball = read inputBall :: Pokeball

    let finalRate = finalCatchRate level ball
    putStrLn $ "Catch rate : " ++ show finalRate ++ "%"