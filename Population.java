package NaturalSelection;

import java.util.ArrayList;
import java.util.Random;

public class Population {
    
    private Random random;

    public String targetStr = "Hello there.";
    private int size = 100;
    private double mutRate = 0.05;

    public double avgFitness = 0.0;

    public int maxFitness = -1;
    public String bestStr = "";

    private Monkey[] pop;

    private ArrayList<Monkey> breedingPop;

    public Population(String targetStr, int size, double mutRate) {

        this.random = new Random();

        this.targetStr = targetStr;
        this.size = size;
        this.mutRate = mutRate;

        this.pop = new Monkey[size];


        for(int i = 0; i < size; i++) {
            this.pop[i] = new Monkey(targetStr.length());
        }

    }

    public void calcFitness() {
        this.avgFitness = 0;

        this.bestStr = "";
        this.maxFitness = -1;

        this.breedingPop = new ArrayList<Monkey>();
        for(int i = 0; i < this.pop.length; i++) {
            
            this.pop[i].calcFitness(this.targetStr);
            this.avgFitness += this.pop[i].fitness;

            this.maxFitness = this.maxFitness > this.pop[i].fitness ? this.maxFitness : this.pop[i].fitness;
            this.bestStr = this.maxFitness > this.pop[i].fitness ? this.bestStr : this.pop[i].str;


            for(int j = 0; j < this.pop[i].fitness; j++) {
                breedingPop.add(this.pop[i]);
            }
        }
        this.avgFitness = this.avgFitness/this.size;
    }

    public void getNextGeneration() {
        Monkey[] nextGen = new Monkey[this.size];
        for(int i = 0; i < this.size; i++) {
            Monkey a = this.breedingPop.get(this.random.nextInt(this.breedingPop.size()));
            Monkey b =this. breedingPop.get(this.random.nextInt(this.breedingPop.size()));
            Monkey child = a.cross(b);

            for (int j = 0; j < child.str.length(); j++) {
                if(this.random.nextDouble() < this.mutRate) {
                    child.str = child.str.substring(0, j) + Helper.newRandomChar() + child.str.substring(j + 1, child.str.length());
                }
            }
            nextGen[i] = child;
        }
        this.pop = nextGen.clone();
    }
}
