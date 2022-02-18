package NaturalSelection;

public class NaturalSelection {
    
    public static void main(String[] args) {

        long firstTime = System.nanoTime();

        double[] results = new double[10];
        int index = 0; 

        final int TRIALS = 1000;
        final double MUT_INCREASE = 0.005;

        for(int j = 1; j <= results.length; j++) {

            double mut = MUT_INCREASE * j;

            for(int trial = 0; trial < TRIALS; trial++) {


            Population population = new Population("Hello there.", 1000, mut);

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
            System.out.println("Mutation rate: " + MUT_INCREASE * (i + 1) + ", Average number of generations until success: " + results[i]);
        }

        long secondTime = System.nanoTime();
        System.out.println("Total time (seconds): " + (secondTime - firstTime) / 1000000000);
    }   
}
