public class Main {

    public static void main(String[] args)
    {
        Dice dice = new Dice(4 , new int[]{3, 4, 2});
        System.out.println(dice.probability[0]);
    }
}
