import java.util.Random;

public class SimulatedAnnealing {

    // 1. Initialization Parameters
    private static double temperature = 1000.0;
    private static final double coolingRate = 0.003;
    private static final double absoluteZero = 1e-4;

    public static void main(String[] args) {
        Random random = new Random();

        // Step 1a: Initial Solution (S0)
        double currentSolution = 50.0; // Starting at an arbitrary point
        double bestSolution = currentSolution;

        System.out.println("Starting SA Optimization...");
        System.out.println("Initial Energy: " + calculateEnergy(currentSolution));

        // 5. Termination (Loop until system reaches a low temperature)
        while (temperature > absoluteZero) {

            // 2. Neighborhood Search (Small change to current solution)
            double newSolution = currentSolution + (random.nextDouble() * 2 - 1);

            // 3. Objective Function Evaluation
            double currentEnergy = calculateEnergy(currentSolution);
            double neighborEnergy = calculateEnergy(newSolution);

            // 4. Acceptance Probability
            if (acceptanceProbability(currentEnergy, neighborEnergy, temperature) > random.nextDouble()) {
                currentSolution = newSolution;
            }

            // Keep track of the best solution found so far
            if (calculateEnergy(currentSolution) < calculateEnergy(bestSolution)) {
                bestSolution = currentSolution;
            }

            // 5. Cooling Schedule (Temperature decrease)
            temperature *= (1 - coolingRate);
        }

        System.out.println("--- Optimization Finished ---");
        System.out.println("Best Solution (x): " + bestSolution);
        System.out.println("Minimum Energy (f(x)): " + calculateEnergy(bestSolution));
    }

    /**
     * Objective Function: f(x) = x^2
     * We want to minimize this value (Energy).
     */
    private static double calculateEnergy(double x) {
        return Math.pow(x, 2);
    }

    /**
     * Acceptance Probability Function
     */
    private static double acceptanceProbability(double currentEnergy, double newEnergy, double temperature) {
        // If the new solution is better, accept it immediately
        if (newEnergy < currentEnergy) {
            return 1.0;
        }
        // If worse, calculate probability based on temperature
        // Using the Boltzmann Distribution: e^(-deltaE / T)
        return Math.exp((currentEnergy - newEnergy) / temperature);
    }
}