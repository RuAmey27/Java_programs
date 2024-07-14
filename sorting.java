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
//fcfs
    public void fcfsScheduling() {
        if (head == null) {
            return; // Nothing to schedule
        }
    
        Node current = head;
        int currentTime = 0;
    
        while (current != null) {
            Process process = current.process;
            if (currentTime < process.at) {
                currentTime = process.at; // Skip idle time if the process hasn't arrived yet
            }
    
            process.ct = currentTime + process.bt;
            process.tat = process.ct - process.at;
            process.wt = process.tat - process.bt;
    
            currentTime = process.ct;
            current = current.next;
        }
    }
//sjf
    public void SJFScheduling() {
        if (head == null) {
            return; // Nothing to schedule
        }
    
        Node current = head;
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(p -> p.process.bt));
        int currentTime = 0;
    
        while (current != null || !queue.isEmpty()) {
            while (current != null && current.process.at <= currentTime) {
                queue.add(current);
                current = current.next;
            }
    
            if (!queue.isEmpty()) {
                Node node = queue.poll();
                Process process = node.process;
                currentTime += process.bt;
                process.ct = currentTime;
                process.tat = process.ct - process.at;
                process.wt = process.tat - process.bt;
            } else if (current != null) {
                currentTime = current.process.at;
            }
        }
    }
//preemptive sjf
    public void preemptiveSJFScheduling() {
        if (head == null) {
            return; // Nothing to schedule
        }
    
        PriorityQueue<Node> readyQueue = new PriorityQueue<>(Comparator.comparing(p -> p.process.remainingTime));
        Node current = head;
        int currentTime = 0;
        Node executingProcess = null;
    
        while (current != null || !readyQueue.isEmpty() || executingProcess != null) {
            while (current != null && current.process.at <= currentTime) {
                readyQueue.add(current);
                current = current.next;
            }
    
            if (executingProcess != null && (current == null || executingProcess.process.remainingTime < current.process.remainingTime)) {
                Process process = executingProcess.process;
                process.remainingTime--;
    
                currentTime++;
    
                if (process.remainingTime == 0) {
                    process.ct = currentTime;
                    process.tat = process.ct - process.at;
                    process.wt = process.tat - process.bt;
                    executingProcess = null;
                }
            } else if (!readyQueue.isEmpty()) {
                Node nextProcess = readyQueue.poll();
                if (executingProcess != null && executingProcess.process != nextProcess.process) {
                    // Preempt the current process
                    Process process = executingProcess.process;
                    process.remainingTime++;
                    readyQueue.add(executingProcess);
                }
                executingProcess = nextProcess;
            } else {
                currentTime++;
            }
        }
    }
//priority
    public void priorityScheduling() {
        if (head == null) {
            return; // Nothing to schedule
        }
    
        Node current = head;
        ArrayList<Node> processes = new ArrayList<>();
    
        while (current != null) {
            processes.add(current);
            current = current.next;
        }
    
        processes.sort(Comparator.comparing(p -> p.process.priority));
    
        int currentTime = 0;
    
        for (Node node : processes) {
            Process process = node.process;
            if (process.at > currentTime) {
                currentTime = process.at;
            }
            process.ct = currentTime + process.bt;
            process.tat = process.ct - process.at;
            process.wt = process.tat - process.bt;
            currentTime = process.ct;
        }
    }
//preemptive priority
    public void preemptivePriorityScheduling() {
        if (head == null) {
            return; // Nothing to schedule
        }
    
        PriorityQueue<Node> readyQueue = new PriorityQueue<>(Comparator.comparing(p -> p.process.priority));
        Node current = head;
        int currentTime = 0;
        Node executingProcess = null;
    
        while (current != null || !readyQueue.isEmpty() || executingProcess != null) {
            while (current != null && current.process.at <= currentTime) {
                readyQueue.add(current);
                current = current.next;
            }
    
            if (executingProcess != null && (current == null || executingProcess.process.priority > current.process.priority)) {
                Process process = executingProcess.process;
                process.remainingTime--;
    
                currentTime++;
    
                if (process.remainingTime == 0) {
                    process.ct = currentTime;
                    process.tat = process.ct - process.at;
                    process.wt = process.tat - process.bt;
                    executingProcess = null;
                }
            } else if (!readyQueue.isEmpty()) {
                Node nextProcess = readyQueue.poll();
                if (executingProcess != null && executingProcess.process != nextProcess.process) {
                    // Preempt the current process
                    Process process = executingProcess.process;
                    process.remainingTime++;
                    readyQueue.add(executingProcess);
                }
                executingProcess = nextProcess;
            } else {
                currentTime++;
            }
        }
    }
//roundrobin    
    public void roundRobinScheduling(int timeSlice) {
        if (head == null) {
            return; // Nothing to schedule
        }
    
        Queue<Node> readyQueue = new LinkedList<>();
        Node current = head;
        int currentTime = 0;
    
        while (current != null || !readyQueue.isEmpty()) {
            while (current != null && current.process.at <= currentTime) {
                readyQueue.add(current);
                current = current.next;
            }
    
            if (!readyQueue.isEmpty()) {
                Node executingProcess = readyQueue.poll();
                Process process = executingProcess.process;
                int timeRemaining = Math.min(timeSlice, process.remainingTime);
    
                currentTime += timeRemaining;
                process.remainingTime -= timeRemaining;
    
                if (process.remainingTime == 0) {
                    process.ct = currentTime;
                    process.tat = process.ct - process.at;
                    process.wt = process.tat - process.bt;
                } else {
                    readyQueue.add(executingProcess); // Re-add the process to the queue if it's not completed
                }
            } else if (current != null) {
                currentTime = current.process.at; // Skip idle time if no process is ready
            }
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
        processList.fcfsScheduling();
        System.out.println("RESULT OF FCFS");
        processList.printProcessesInTableFormat();
        processList.SJFScheduling();
        System.out.println("SJFScheduling");
        processList.preemptiveSJFScheduling();
       // processList.sortByPriorityAndUpdateCT();
        System.out.println("preemptiveSJFScheduling");
        //processList.printProcessesInTableFormat();

    }


}