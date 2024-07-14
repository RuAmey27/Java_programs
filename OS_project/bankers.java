package OS_project;

import java.util.Arrays;

class BankersAlgorithm {
    private int processes;
    private int resources;
    private int[][] max;
    private int[][] allocation;
    private int[][] need;
    private int[] available;

    public BankersAlgorithm(int processes, int resources) {
        this.processes = processes;
        this.resources = resources;
        this.max = new int[processes][resources];
        this.allocation = new int[processes][resources];
        this.need = new int[processes][resources];
        this.available = new int[resources];
    }

    public void setMax(int process, int[] max) {
        this.max[process] = Arrays.copyOf(max, max.length);
    }

    public void setAllocation(int process, int[] allocation) {
        this.allocation[process] = Arrays.copyOf(allocation, allocation.length);
    }

    public void setAvailable(int[] available) {
        this.available = Arrays.copyOf(available, available.length);
    }

    public boolean isSafe() {
        int[] work = Arrays.copyOf(available, available.length);
        boolean[] finish = new boolean[processes];

        for (int i = 0; i < processes; i++) {
            for (int j = 0; j < resources; j++) {
                need[i][j] = max[i][j] - allocation[i][j];
            }
        }

        int count = 0;
        while (count < processes) {
            boolean found = false;
            for (int i = 0; i < processes; i++) {
                if (!finish[i] && canFinish(i, work)) {
                    for (int j = 0; j < resources; j++) {
                        work[j] += allocation[i][j];
                    }
                    finish[i] = true;
                    found = true;
                    count++;
                }
            }

            if (!found) {
                break;
            }
        }

        return count == processes;
    }

    private boolean canFinish(int process, int[] work) {
        for (int i = 0; i < resources; i++) {
            if (need[process][i] > work[i]) {
                return false;
            }
        }
        return true;
    }
}

class BankersAlgorithmExample {
    public static void main(String[] args) {
        BankersAlgorithm banker = new BankersAlgorithm(5, 3);

        int[] availableResources = {3, 3, 2};
        banker.setAvailable(availableResources);

        int[][] maxMatrix = {
                {7, 5, 3},
                {3, 2, 2},
                {9, 0, 2},
                {2, 2, 2},
                {4, 3, 3}
        };

        int[][] allocationMatrix = {
                {0, 1, 0},
                {2, 0, 0},
                {3, 0, 2},
                {2, 1, 1},
                {0, 0, 2}
        };

        for (int i = 0; i < 5; i++) {
            banker.setMax(i, maxMatrix[i]);
            banker.setAllocation(i, allocationMatrix[i]);
        }

        if (banker.isSafe()) {
            System.out.println("The system is in a safe state.");
        } else {
            System.out.println("The system is in an unsafe state.");
        }
    }
}
