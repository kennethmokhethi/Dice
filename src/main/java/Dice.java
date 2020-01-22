import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dice {
    //Attributes
    private int sides;
    private int[] probability;
    private int weighted_value;

    //Getter and setter for weighted value
    public int getWeighted_value() {
        return weighted_value;
    }

    public void setWeighted_value(int weighted_value) {
        this.weighted_value = weighted_value;
    }



    //Getter and setter for probability
    public int[] getProbability() {
        return probability;
    }

    public void setProbability(int[] probability) {
        this.probability = probability;
    }



   //Getter and setter for sides
    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }


    //Constructor
    public Dice(int sides, int[]  args){

        if(args != null){
            this.sides = sides;
            //Memory allocation
            this.probability = new int[args.length];
            this.probability = Arrays.copyOf(args,args.length);

        }else{
            this.sides = sides;
        }
    }

    //Error handling
    private void error_handling() throws Exception{
        if(getSides() != this.probability.length){
            throw new Exception("The probability array length is no equal to the number of sides");
        }

        int sum = 0;
        for(int i = 0;i < getSides() ;i++){
            if(this.probability[i] < 0){
                throw new Exception("Negative probability not allowed");
            }else{
                sum += this.probability[i];
            }
        }

        if(sum <= 0){
            throw new Exception("Sum must be greater than 0");
        }

    }

   //Generating numbers from 1 to number of sides
    public int roll(){
        return (int)(Math.random()*getSides() + 1);
    }

    //Update the weighted value
    public void update(){
       // int[] weighted_list;
        List<Integer> weighted_list = new ArrayList<Integer>();
        for(int a = 1;a <= getSides() ;a++){
            for(int b = 0;b < this.probability[a - 1] ;b++){
                weighted_list.add(a);
            }
        }

        int[] weighted_array= new int[weighted_list.size()];
        for(int a = 0;a <weighted_array.length ;a++){
            weighted_array[a] = weighted_list.get(a);
        }

        this.weighted_value = weighted_array[roll()];


    }


}
