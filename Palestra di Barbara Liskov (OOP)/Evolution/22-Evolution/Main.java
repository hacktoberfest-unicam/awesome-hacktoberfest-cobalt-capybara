public class Main {
    public static void main(String[] args) {
        String[] charmanderMoves = {"Scratch", "Ember", "Growl"};
        Charmander charmander = new Charmander("Charmander", 15, 39, charmanderMoves);
        
        charmander.displayStatus();
        
        charmander.levelUp();
        charmander.displayStatus();
        

        charmander.levelUp();
        charmander.displayStatus();
        
        String[] charmeleonMoves = {"Scratch", "Ember", "Dragon Breath"};
        Charmeleon charmeleon = new Charmeleon("Charmeleon", 35, 58, charmeleonMoves);

        charmeleon.levelUp();
        charmeleon.displayStatus();
    }
}