data MoveType = Water | Fire | Grass


efficacy :: MoveType -> MoveType -> Double
efficacy Fire Grass = 2.0  
efficacy Water Fire = 2.0  
efficacy Grass Water = 2.0  
efficacy Fire Water = 0.5   
efficacy Water Grass = 0.5   
efficacy Grass Fire = 0.5    
efficacy _ _ = 1.0              

main :: IO ()
main = do
    putStrLn "Type of attacking pokemon (Fire, Water,Grass):"
    inputAttaccante <- getLine
    let attacker = read inputAttacker :: MoveType

    putStrLn "Type of defender pokemon (Fire, Water,Grass):"
    inputDefender <- getLine
    let defender = read inputDefender :: MoveType

    let result = efficacy attacker defender
    putStrLn $ "Attacker efficacy: " ++ show result