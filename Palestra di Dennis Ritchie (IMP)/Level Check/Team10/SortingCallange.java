

class EvenAndOddPokemonsArrays{
    int Max_N_Pokemons;
    public int N_EvenPokemons = 0;
    public int EvenPokemons[] = new int[Max_N_Pokemons];

    public int N_OddPokemons = 0;
    public int OddPokemons[] = new int[Max_N_Pokemons];


    public EvenAndOddPokemonsArrays(int Max_N_Pokemons){
        this.Max_N_Pokemons = Max_N_Pokemons;
        EvenPokemons = new int[Max_N_Pokemons];
        OddPokemons = new int[Max_N_Pokemons];
    }
    void AddPokemon(int Pokemon, boolean Eaven)
    {
        if (Eaven)
        {
            EvenPokemons[N_EvenPokemons] = Pokemon;
             N_EvenPokemons ++;
        }
        else
        {
            OddPokemons[N_OddPokemons] = Pokemon;
             N_OddPokemons ++;
        }
    }
}
public class SortingCallange {



    static boolean IsEven (int Number){return Number % 2 == 0;}

    static EvenAndOddPokemonsArrays sort_pokemon_levels(int Pokemons[], int N_Pokemons){

        EvenAndOddPokemonsArrays EvenAndOddArray = new EvenAndOddPokemonsArrays(N_Pokemons);

        for (int i = 0; i < N_Pokemons; i++)
        {
            int Pokemon = Pokemons[i];
            EvenAndOddArray.AddPokemon(Pokemon, IsEven(Pokemon));
        }
        return EvenAndOddArray;
    }

    public static void main(String[] args) {
        int N_Pokemons = 3;
        int Pokemons[] = {5, -1, 1}; //The levels of the pokemons


        Pokemons = bubbleSort(Pokemons);
        EvenAndOddPokemonsArrays SortedPokemons = sort_pokemon_levels(Pokemons, N_Pokemons);

        // Visualization
        if (SortedPokemons.N_EvenPokemons + SortedPokemons.N_OddPokemons == 0)
        {
            System.out.println("Nessun Pokemon");
            return;
        }

        // Eaven
        if (SortedPokemons.N_EvenPokemons > 0)
        {
            System.out.println("Even Pokemon levels:");
            for (int i = 0; i < SortedPokemons.N_EvenPokemons; i++) {
                System.out.println(SortedPokemons.EvenPokemons[i]);
            }
        }

        // Odd
        if (SortedPokemons.N_OddPokemons > 0)
        {
            System.out.println("Odd Pokemon levels:");
            for (int i = 0; i < SortedPokemons.N_OddPokemons; i++) {
                System.out.println(SortedPokemons.OddPokemons[i]);
            }
        }
    }
       public static int[] bubbleSort(int[] myArray) {

       int temp = 0;  //  temporary element for swapping
       int counter = 0;  //  element to count quantity of steps

       for (int i = 0; i < myArray.length; i++) {
           counter = i + 1;
           for (int j = 1; j < (myArray.length - i); j++) {

               if (myArray[j - 1] > myArray[j]) {
                   //  swap array’s elements using temporary element
                   temp = myArray[j - 1];
                   myArray[j - 1] = myArray[j];
                   myArray[j] = temp;
               }
           }
       }
       return myArray;
   }
}