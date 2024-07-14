import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Process {
    int id;
    int arrivalTime;
    int burstTime;
    int priority;

    public Process(int id, int arrivalTime, int burstTime, int priority) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}

class ProcessComparator implements Comparator<Process> {
    @Override
    public int compare(Process p1, Process p2) {
        // Compare based on arrival time first
        int arrivalTimeComparison = Integer.compare(p1.arrivalTime, p2.arrivalTime);
        if (arrivalTimeComparison != 0) {
            return arrivalTimeComparison;
        }
        // If arrival time is the same, compare based on priority
        return Integer.compare(p1.priority, p2.priority);
    }
}


class prio_trial {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Process> processes = new ArrayList<>();
        int n;
        

        System.out.print("Enter the number of processes: ");
        n = scanner.nextInt();
        int[] id = new int[n];
        int[] arrivalTime = new int[n];
        int [] burstTime = new int[n];
        int [] priority = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Process " + (i + 1) + ":");
            System.out.print("Enter Process ID: ");
            id[i] = scanner.nextInt();
            System.out.print("Enter Arrival Time: ");
            arrivalTime[i] = scanner.nextInt();
            System.out.print("Enter Burst Time: ");
            burstTime[i] = scanner.nextInt();
            System.out.print("Enter Priority: ");
            priority[i] = scanner.nextInt();
            processes.add(new Process(id[i], arrivalTime[i], burstTime[i], priority[i]));
        }

        // Sort processes using the custom comparator
        Collections.sort(processes, new ProcessComparator());

        // Calculate turnaround time, waiting time, and completion time
        int currentTime = 0;
        for (Process process : processes) {
            int waitingTime = currentTime - process.arrivalTime;
            int turnaroundTime = waitingTime + process.burstTime;
            int completionTime = currentTime + process.burstTime;

            // Display process details
            System.out.println("Process " + process.id +
                    ": bt=" + process.burstTime +
                    ", tat=" + turnaroundTime +
                    ", wt=" + waitingTime +
                    ", ct=" + completionTime);

            // Update current time
            currentTime = completionTime;
        }

        scanner.close();
    }
}

