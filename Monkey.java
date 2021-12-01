package NaturalSelection;
import java.util.Random;

public class Monkey {
    
    public String str = "";
    public int fitness = 0;
    private Random random;

    public Monkey(int length) {

        random = new Random();

        for(int i = 0; i < length; i++) {
            char nextChar = Helper.newRandomChar();
            this.str = this.str + (nextChar);
        }
    }

    public Monkey(String startString) {
        random = new Random();

        this.str = startString;
    }

    public void calcFitness(String targetStr) {
        this.fitness = 0;

        for(int i = 0; i < targetStr.length(); i++) {
            if(targetStr.charAt(i) == this.str.charAt(i)) { 
                this.fitness++;
            }
        }
    }

    public Monkey cross(Monkey other) {

        int cutOff = random.nextInt(this.str.length());

        String childStr = "";

        for(int i = 0; i < this.str.length(); i++) {
            if(i < cutOff) {
                childStr = childStr + this.str.charAt(i);
            } else {
                childStr = childStr + other.str.charAt(i);

            }
        }

        return new Monkey(childStr);
    }

}
