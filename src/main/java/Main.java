public class Main {

    public static void main(String[] args)
    {
        Dice dice = new Dice(4 , new int[]{3, 4, 2});
        System.out.println("Number of sides "+dice.getSides());;

        System.out.println("Rolled dice" + dice.roll());

        System.out.println("Weighted value" + dice.getWeighted_value());


    }
}
