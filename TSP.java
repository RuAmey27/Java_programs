import java.util.*;

public class TSP {
    public static void main(String[] args) {
        int[][] graph = { { 0, 10, 15, 20 },
                          { 10, 0, 35, 25 },
                          { 15, 35, 0, 30 },
                          { 20, 25, 30, 0 } };
        int n = graph.length;
        int[] vertex = new int[n];
        for (int i = 0; i < n; i++) {
            vertex[i] = i;
        }
      
        int[] bestPerm = new int[n];
        int bestDist = Integer.MAX_VALUE;
        do {
            int dist = 0;
            for (int i = 0; i < n - 1; i++) {
                dist += graph[vertex[i]][vertex[i + 1]];
            }
            dist += graph[vertex[n - 1]][vertex[0]];
            if (dist < bestDist) {
                bestDist = dist;
                System.arraycopy(vertex, 0, bestPerm, 0, n);
            }
        } while (nextPermutation(vertex));
        System.out.print("Shortest path: ");
        for (int i = 0; i < n; i++) {
            System.out.print(bestPerm[i] + 1 + " ");
        }
        System.out.println("\nShortest distance: " + bestDist);
    }

    public static boolean nextPermutation(int[] a) {
        int n = a.length;
        int i = n - 2;
        while (i >= 0 && a[i] >= a[i + 1]) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        int j = n - 1;
        while (a[j] <= a[i]) {
            j--;
        }
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        Arrays.sort(a, i + 1, n);
        return true;
    }
}
