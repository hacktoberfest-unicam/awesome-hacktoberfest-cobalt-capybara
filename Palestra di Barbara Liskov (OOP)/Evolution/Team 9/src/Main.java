
public class Main
{
    public static void main(String[] args) throws Exception
    {
        Pokemon charmander = new Charmander("Charmander", "Fire", 14, 39, new String[]{"Scratch", "Ember"});
        int i = 0;
        while(i<30){
            charmander = charmander.levelUp();
            i++;
        }

    }
}
