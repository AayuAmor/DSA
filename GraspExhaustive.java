// GRASP (Greedy Randomized Adaptive Search Procedure) using Exhaustive Search for Max Sum Subset
// This is a simplified example for illustration. GRASP is usually metaheuristic, but here we use exhaustive search for all subsets.
import java.util.*;

public class GraspExhaustive {
    public static void main(String[] args) {
        int[] arr = {5, 10, 12, 13, 15, 18};
        int maxSum = 30;
        List<Integer> bestSubset = new ArrayList<>();
        int bestSum = 0;
        int n = arr.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            List<Integer> subset = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += arr[i];
                    subset.add(arr[i]);
                }
            }
            if (sum <= maxSum && sum > bestSum) {
                bestSum = sum;
                bestSubset = new ArrayList<>(subset);
            }
        }
        System.out.println("Best subset with sum <= " + maxSum + ": " + bestSubset);
        System.out.println("Best sum: " + bestSum);
    }
}
