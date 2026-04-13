// Travelling Salesman Problem (TSP) using Exhaustive Search (Brute Force)
// This example finds the minimum cost tour visiting all cities exactly once and returning to the start.
import java.util.*;

public class TravellingSalesman {
    static int n = 4; // Number of cities
    static int[][] dist = {
        {0, 10, 15, 20},
        {10, 0, 35, 25},
        {15, 35, 0, 30},
        {20, 25, 30, 0}
    };
    static int minCost = Integer.MAX_VALUE;
    static List<Integer> bestPath = new ArrayList<>();

    public static void main(String[] args) {
        List<Integer> cities = new ArrayList<>();
        for (int i = 1; i < n; i++) cities.add(i);
        permute(cities, 0, new ArrayList<>());
        System.out.println("Minimum cost: " + minCost);
        System.out.println("Best path: " + bestPath);
    }

    static void permute(List<Integer> cities, int l, List<Integer> path) {
        if (l == cities.size()) {
            int cost = dist[0][cities.get(0)];
            for (int i = 0; i < cities.size() - 1; i++) {
                cost += dist[cities.get(i)][cities.get(i + 1)];
            }
            cost += dist[cities.get(cities.size() - 1)][0];
            if (cost < minCost) {
                minCost = cost;
                bestPath = new ArrayList<>();
                bestPath.add(0);
                bestPath.addAll(cities);
                bestPath.add(0);
            }
            return;
        }
        for (int i = l; i < cities.size(); i++) {
            Collections.swap(cities, l, i);
            permute(cities, l + 1, path);
            Collections.swap(cities, l, i);
        }
    }
}
