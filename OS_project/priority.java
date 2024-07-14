package OS_project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Process implements Comparable<Process> {
    int id;
    int priority;

    public Process(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }

    @Override
    public int compareTo(Process other) {
        return Integer.compare(this.priority, other.priority);
    }
}
class PriorityScheduling {
    public static void main(String[] args) {
        List<Process> processes = new ArrayList<>();
        processes.add(new Process(1, 3));
        processes.add(new Process(2, 1));
        processes.add(new Process(3, 2));

        Collections.sort(processes);

        System.out.println("Priority Scheduling Order:");
        for (Process process : processes) {
            System.out.println("Process " + process.id);
        }
    }
}
