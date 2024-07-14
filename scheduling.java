class LinkedList {
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
//shortest job first 
    public void sortByBurstTimeAndUpdateCT() {
        if (head == null || head.next == null) {
            // No need to sort if the list has 0 or 1 elements
            return;
        }

        boolean swapped;
        Node current;
        Node next = null;

        do {
            swapped = false;
            current = head;

            while (current.next != next) {
                if (current.process.bt > current.next.process.bt) {
                    // Swap the current and next nodes
                    Process temp = current.process;
                    current.process = current.next.process;
                    current.next.process = temp;
                    swapped = true;
                }
                current = current.next;
            }
            next = current;
        } while (swapped);

        // Update completion times (ct) of the nodes
        current = head;
        int currentTime = 0;

        while (current != null) {
            current.process.ct = currentTime + current.process.bt;
            current.process.tat = current.process.ct - current.process.at;
            current.process.wt = current.process.tat - current.process.bt;
            currentTime = current.process.ct;
            current = current.next;
        }
    }
//first come first serve
    public void sortByArrivalTime() {
        if (head == null || head.next == null) {
            // No need to sort if the list has 0 or 1 elements
            return;
        }

        boolean swapped;
        Node current;
        Node next = null;

        do {
            swapped = false;
            current = head;

            while (current.next != next) {
                if (current.process.at > current.next.process.at ||
                        (current.process.at == current.next.process.at
                                && current.process.pid > current.next.process.pid)) {
                    // Swap the current and next nodes
                    Process temp = current.process;
                    current.process = current.next.process;
                    current.next.process = temp;
                    swapped = true;
                }
                current = current.next;
            }
            next = current;
        } while (swapped);

        // Update completion times (ct) of the nodes
        current = head;
        int currentTime = 0;

        while (current != null) {
            current.process.ct = currentTime + current.process.bt;
            current.process.tat = current.process.ct - current.process.at;
            current.process.wt = current.process.tat - current.process.bt;
            currentTime = current.process.ct;
            current = current.next;
        }
    }
// priority scheduling 
    public void sortByPriorityAndUpdateCT() {
        if (head == null || head.next == null) {
            // No need to sort if the list has 0 or 1 elements
            return;
        }

        boolean swapped;
        Node current;
        Node next = null;

        do {
            swapped = false;
            current = head;

            while (current.next != next) {
                if (current.process.priority < current.next.process.priority) {
                    // Swap the current and next nodes
                    Process temp = current.process;
                    current.process = current.next.process;
                    current.next.process = temp;
                    swapped = true;
                }
                current = current.next;
            }
            next = current;
        } while (swapped);

        // Update completion times (ct), tat, and wt of the nodes
        current = head;
        int currentTime = 0;

        while (current != null) {
            current.process.ct = currentTime + current.process.bt;
            current.process.tat = current.process.ct - current.process.at;
            current.process.wt = current.process.tat - current.process.bt;
            currentTime = current.process.ct;
            current = current.next;
        }
    }

    
    public void printProcessesInTableFormat() {
        System.out.println("PID\tAT\tBT\tCT\tTAT\tWT\tPriority");
        Node current = head;

        while (current != null) {
            Process process = current.process;
            System.out.println(
                    process.pid + "\t" +
                            process.at + "\t" +
                            process.bt + "\t" +
                            process.ct + "\t" +
                            process.tat + "\t" +
                            process.wt+ "\t" +
                            process.priority);
            current = current.next;
        }
    }

    


    public static void main(String[] args) {
        LinkedList processList = new LinkedList();

        // Insert processes
        processList.insert(new Process(1, 1, 10, 2));
        processList.insert(new Process(2, 2, 29, 1));
        processList.insert(new Process(3, 3, 3, 4));
        processList.insert(new Process(4, 2, 7, 9));
        processList.insert(new Process(5, 1, 12, 2));
       // processList.insert(new Process(6, 1, 2, 1));
        // Perform other operations as needed
        System.out.println("The given input is :");
        processList.printProcessesInTableFormat();
        processList.sortByBurstTimeAndUpdateCT();
        System.out.println("RESULT OF SJF");
        processList.printProcessesInTableFormat();
        processList.sortByArrivalTime();
        System.out.println("RESULT OF FCFS");
        processList.printProcessesInTableFormat();
        processList.sortByPriorityAndUpdateCT();
        System.out.println("RESULT OF PRIORITY SCHEDULING");
        processList.printProcessesInTableFormat();

    }

    // You can add other methods for operations on the linked list as needed.
}
