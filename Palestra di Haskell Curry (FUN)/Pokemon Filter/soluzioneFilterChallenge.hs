filterPokemon :: String -> [(String,String)] -> [String]
filterPokemon x lst = map snd ((filter((==x).fst) lst))
