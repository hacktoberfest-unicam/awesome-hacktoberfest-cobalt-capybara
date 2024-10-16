/*
    0 = Normal
    1 = Fire
    2 = Water
    3 = Grass
    4 = Electric
    5 = Ice
    6 = Fighting
    7 = Poison
    8 = Ground
    9 = Flying
    10 = Psychic
    11 = Bug
    12 = Rock
    13 = Ghost
    14 = Dragon
    15 = Dark
    16 = Steel
    17 = Fairy
 */

public class Advantage {
    private double[][] damageMatrix;
    public Advantage() {
        damageMatrix = new double[18][18];
        setDamage();
    }

    private void setDamage() {
        damageMatrix[0] = new double[]{1,1,1,1,1,1,1,1,1,1,1,1,0.5,0,1,1,0.5,1};
        damageMatrix[1] = new double[]{1,0.5,0.5,2,1,2,1,1,1,1,1,2,0.5,1,0.5,1,2,1};
        damageMatrix[2] = new double[]{1,2,0.5,0.5,1,1,1,1,2,1,1,1,2,1,0.5,1,1,1};
        damageMatrix[3] = new double[]{1,0.5,2,0.5,1,1,1,0,2,1,1,1,1,1,0.5,1,1,1};
        damageMatrix[4] = new double[]{1,1,2,0.5,0.5,1,1,1,0,2,1,1,1,1,0.5,1,1,1};
        damageMatrix[5] = new double[]{1,0.5,0.5,2,1,0.5,1,1,2,2,1,1,1,1,2,1,0.5,1};
        damageMatrix[6] = new double[]{2,1,1,1,2,1,0.5,1,0.5,0.5,0.5,2,0,1,2,2,0.5};
        damageMatrix[7] = new double[]{1,1,1,2,1,1,1,0.5,0.5,1,1,1,0.5,0.5,1,1,0,2};
        damageMatrix[8] = new double[]{1,2,1,0.5,2,1,1,2,1,0,1,0.5,2,1,1,1,2,1};
        damageMatrix[9] = new double[]{1,1,1,2,0.5,1,2,1,1,1,1,2,0.5,1,1,1,0.5,1};
        damageMatrix[10] = new double[]{1,1,1,1,1,1,2,2,1,1,0.5,1,1,1,1,0,0.5,1};
        damageMatrix[11] = new double[]{1,0.5,1,2,1,1,0.5,0.5,1,0.5,2,1,1,0.5,1,2,0.5,0.5};
        damageMatrix[12] = new double[]{1,2,1,1,1,2,0.5,1,0.5,2,1,2,1,1,1,1,0.5,1};
        damageMatrix[13] = new double[]{0,1,1,1,1,1,1,1,1,1,2,1,1,2,1,0.5,1,1};
        damageMatrix[14] = new double[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,0.5,0};
        damageMatrix[15] = new double[]{1,1,1,1,1,1,0.5,1,1,1,2,1,1,2,1,0.5,1,0.5};
        damageMatrix[16] = new double[]{1,0.5,0.5,1,0.5,2,1,1,1,1,1,1,2,1,1,1,0.5,2};
        damageMatrix[17] = new double[]{1,0.5,1,1,1,1,2,0.5,1,1,1,1,1,1,2,2,0.5,1};

    }

    public int getNumberType(String type){
        switch(type){
            case "Normal":
                return 0;
            case "Fire":
                return 1;
            case "Water":
                return 2;
            case "Grass":
                return 3;
            case "Electric":
                return 4;
            case "Ice":
                return 5;
            case "Fighting":
                return 6;
            case "Poison":
                return 7;
            case "Ground":
                return 8;

            case "Flying":
                return 9;
            case "Psychic":
                return 10;
            case "Bug":
                return 11;
            case "Rock":
                return 12;
            case "Ghost":
                return 13;
            case "Dragon":
                return 14;
            case "Dark":
                return 15;
            case "Stell":
                return 16;
            case "Fairy":
                return 17;
            default:
                return -1;
        }
    }

    public double getMultiplier(int i,int j){
        return damageMatrix[i][j];
    }
}