package OS_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Process implements Comparable<Process> {
    int id;
    int burstTime;

    public Process(int id, int burstTime) {
        this.id = id;
        this.burstTime = burstTime;
    }

    @Override
    public int compareTo(Process other) {
        return Integer.compare(this.burstTime, other.burstTime);
    }
}

class SchedulingAlgorithms {
    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        processes.add(new Process(1, 5));
        processes.add(new Process(2, 3));
        processes.add(new Process(3, 8));

        // FCFS Scheduling
        System.out.println("FCFS Scheduling Order:");
        for (Process process : processes) {
            System.out.println("Process " + process.id);
        }

        // SJF Scheduling
        Collections.sort(processes);
        System.out.println("\nSJF Scheduling Order:");
        for (Process process : processes) {
            System.out.println("Process " + process.id);
        }
    }
}
