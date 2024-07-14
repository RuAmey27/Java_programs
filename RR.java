import java.util.*;
import java.util.Queue;
class Process {
    int pid;
    int at;
    int bt;
    int ct;
    int tat;
    int wt;
    int priority;

    public Process(int pid, int at, int bt,int prio) {
        this.pid = pid;
        this.at = at;
        this.bt = bt;
        this.priority=prio;
        this.ct = 0; // Initialize completion time to 0
        this.tat = 0; // Initialize turnaround time to 0
        this.wt = 0; // Initialize waiting time to 0
    }
}

class Node {
    Process process;
    Node next;

    public Node(Process process) {
        this.process = process;
        this.next = null;
    }
}

class PLinkedList {
    Node head;

    public void insert(Process process) {
        Node newNode = new Node(process);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void printProcesses() {
        Node current = head;
        while (current != null) {
            System.out.println(current.process.pid + " - " + current.process.bt+ " - " + current.process.at + " - " + current.process.ct+ " - " + current.process.priority);
            current = current.next;
        }
    }
    // ... (previously defined code)

    public void roundRobinScheduling(int timeQuantum) {
        if (head == null) {
            return; // Nothing to schedule
        }

        Queue<Node> queue = new LinkedList<>();
        Node current = head;

        // Initialize the queue with processes in the order of arrival time
        while (current != null) {
            queue.add(current);
            current = current.next;
        }

        int currentTime = 0;
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            Process currentProcess = currentNode.process;

            if (currentProcess.bt > timeQuantum) {
                // Execute the process for the time quantum
                currentTime += timeQuantum;
                currentProcess.bt -= timeQuantum;

                // Re-add the process to the queue
                queue.add(currentNode);
            } else {
                // Execute the process and update completion time
                currentTime += currentProcess.bt;
                currentProcess.ct = currentTime;
            }
        }
    }

    public static void main(String[] args) {
        PLinkedList processList = new PLinkedList();

        // Insert processes
        processList.insert(new Process(1, 0, 5,9));
        processList.insert(new Process(2, 0, 9,3));
        processList.insert(new Process(3, 0, 2,7));

        // Perform other operations as needed
        processList.roundRobinScheduling(2);
        processList.printProcesses();
    }
    // ... (other methods)
}
