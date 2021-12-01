package NaturalSelection;

public class NaturalSelection {
    
    public static void main(String[] args) {

        double[] results = new double[5];
        int index = 0; 

        final int TRIALS = 100;
        final double MUT_INCREASE = 0.005;

        for(double mut = MUT_INCREASE; mut <= MUT_INCREASE * results.length; mut += MUT_INCREASE) {

            for(int trial = 0; trial < TRIALS; trial++) {


            Population population = new Population("Hello there.", 100, mut);

            int i = 0;

            while(population.maxFitness < population.targetStr.length()) {

                population.calcFitness();


                // System.out.println(i + " iterations: Max Fitness: "  + population.maxFitness + ", Best String: " + population.bestStr);

                population.getNextGeneration();

                i++;

                }
               results[index] += i;
               System.out.println("Mutation Rate " + mut + " Trial " + trial + " Done.");
            }


            results[index] = results[index] / (double) TRIALS;
            
            index++;
        }
        for (int i = 0; i < results.length; i++) {
            System.out.println("Mutation rate: " + MUT_INCREASE * (i + 1) + ", Generations until success: " + results[i]);
        }
    }   
}
