pokemon_list :: [([Char],[Char],[Char])]
pokemon_list = [("Bulbasaur","Grass","Poison"),("Charmander","Fire","/"),("Squirle","Water","/"),("Oddish","Grass","Poison")]

--pokedex_filter :: [([Char],[Char],[Char])] -> [Char] -> [[Char]]
--pokedex_filter [(name,type_1,type_2)] name_type = map (\(x,y,z,w)->x) (filter check_type [(name,type_1,type_2,name_type)])
--            where check_type::([Char],[Char],[Char],[Char]) -> Bool
--                  check_type (_,type_1,type_2,name_type) | (type_1==name_type) = True
 --                                                        | (type_2==name_type) = True
--                                                         | otherwise = False

pokedex_filter :: [([Char],[Char],[Char])] -> [Char] -> [[Char]]
pokedex_filter [(name,type_1,type_2)] name_type = map (\(x,y,z,w)->x) (filter (\(x,y,z,w)->(or ([y==w,z==w]))) [(name,type_1,type_2,name_type)])