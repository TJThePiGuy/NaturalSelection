package NaturalSelection;

public class NaturalSelection {
    
    public static void main(String[] args) {

        double[] results = new double[5];
        int index = 0; 

        final int TRIALS = 10;

        for(double mut = 0.01; mut <= 0.01 * results.length; mut += 0.01) {

            for(int trial = 0; trial < TRIALS; trial++) {


            Population population = new Population("To be or not to be.", 100, mut);

            int i = 0;

            while(population.maxFitness < population.targetStr.length()) {

                population.calcFitness();


                System.out.println(i + " iterations: Max Fitness: "  + population.maxFitness + ", Best String: " + population.bestStr);

                population.getNextGeneration();

                i++;

                }
               results[index] += i;
            }
            results[index] = results[index] / (double) TRIALS;
            
            index++;
        }
        for (int i = 0; i < results.length; i++) {
            System.out.println("Mutation rate: " + 0.01 * (i + 1) + ", Generations until success: " + results[i]);
        }
    }   
}
