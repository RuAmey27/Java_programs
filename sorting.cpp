#include <iostream>
#include <vector>
#include <queue>

class Process {
public:
    int pid;
    int at;
    int bt;
    int ct;
    int tat;
    int wt;
    int priority;
    int remainingTime;

    Process(int p, int a, int b, int pr) : pid(p), at(a), bt(b), ct(0), tat(0), wt(0), priority(pr), remainingTime(b) {}
};

class Node {
public:
    Process process;
    Node* next;

    Node(Process p) : process(p), next(nullptr) {}
};

class LinkedList {
public:
    Node* head;

    void insert(Process process) {
        Node* newNode = new Node(process);
        if (head == nullptr) {
            head = newNode;
        } else {
            Node* current = head;
            while (current->next != nullptr) {
                current = current->next;
            }
            current->next = newNode;
        }
    }

void fcfsScheduling() {
    if (head == nullptr) {
        return; // Nothing to schedule
    }

    Node* current = head;
    int currentTime = 0;

    while (current != nullptr) {
        Process& process = current->process;

        if (currentTime < process.at) {
            currentTime = process.at; // Wait for the process to arrive
        }

        process.ct = currentTime + process.bt;
        process.tat = process.ct - process.at;
        process.wt = process.tat - process.bt;

        currentTime = process.ct;
        current = current->next;
    }
}

void SJFScheduling() {
    if (head == nullptr) {
        return; // Nothing to schedule
    }

    Node* current = head;
    std::priority_queue<Node*, std::vector<Node*>, ComparatorSJF> queue;
    int currentTime = 0;

    while (current != nullptr || !queue.empty()) {
        while (current != nullptr && current->process.at <= currentTime) {
            queue.push(current);
            current = current->next;
        }

        if (!queue.empty()) {
            Node* node = queue.top();
            queue.pop();
            Process& process = node->process;
            int processBurstTime = process.bt;

            if (processBurstTime > 0) {
                process.ct = currentTime + processBurstTime;
                process.tat = process.ct - process.at;
                process.wt = process.tat - process.bt;
                currentTime = process.ct;
                process.bt = 0; // Mark the process as completed
            }
        } else if (current != nullptr) {
            currentTime = current->process.at;
        }
    }
}



    struct ComparatorSJF {
        bool operator()(Node* a, Node* b) {
            return a->process.bt > b->process.bt;
        }
    };

    void preemptiveSJFScheduling() {
        if (head == nullptr) {
            return; // Nothing to schedule
        }

        std::priority_queue<Node*, std::vector<Node*>, ComparatorPreemptiveSJF> readyQueue;
        Node* current = head;
        int currentTime = 0;
        Node* executingProcess = nullptr;

        while (current != nullptr || !readyQueue.empty() || executingProcess != nullptr) {
            while (current != nullptr && current->process.at <= currentTime) {
                readyQueue.push(current);
                current = current->next;
            }

            if (executingProcess != nullptr && (current == nullptr || executingProcess->process.remainingTime < current->process.remainingTime)) {
                Process& process = executingProcess->process;
                process.remainingTime--;

                currentTime++;

                if (process.remainingTime == 0) {
                    process.ct = currentTime;
                    process.tat = process.ct - process.at;
                    process.wt = process.tat - process.bt;
                    executingProcess = nullptr;
                }
            } else if (!readyQueue.empty()) {
                Node* nextProcess = readyQueue.top();
                readyQueue.pop();
                if (executingProcess != nullptr && executingProcess->process.pid != nextProcess->process.pid) {
                    // Preempt the current process
                    Process& process = executingProcess->process;
                    process.remainingTime++;
                    readyQueue.push(executingProcess);
                }
                executingProcess = nextProcess;
            } else {
                currentTime++;
            }
        }
    }

    struct ComparatorPreemptiveSJF {
        bool operator()(Node* a, Node* b) {
            return a->process.remainingTime > b->process.remainingTime;
        }
    }

    void priorityScheduling() {
        if (head == nullptr) {
            return; // Nothing to schedule
        }

        Node* current = head;
        std::vector<Node*> processes;

        while (current != nullptr) {
            processes.push_back(current);
            current = current->next;
        }

        std::sort(processes.begin(), processes.end(), ComparatorPriority);

        int currentTime = 0;

        for (Node* node : processes) {
            Process& process = node->process;
            if (process.at > currentTime) {
                currentTime = process.at;
            }
            process.ct = currentTime + process.bt;
            process.tat = process.ct - process.at;
            process.wt = process.tat - process.bt;
            currentTime = process.ct;
        }
    }

    struct ComparatorPriority {
        bool operator()(Node* a, Node* b) {
            return a->process.priority < b->process.priority;
        }
    }

    void preemptivePriorityScheduling() {
        if (head == nullptr) {
            return; // Nothing to schedule
        }

        std::priority_queue<Node*, std::vector<Node*>, ComparatorPreemptivePriority> readyQueue;
        Node* current = head;
        int currentTime = 0;
        Node* executingProcess = nullptr;

        while (current != nullptr || !readyQueue.empty() || executingProcess != nullptr) {
            while (current != nullptr && current->process.at <= currentTime) {
                readyQueue.push(current);
                current = current->next;
            }

            if (executingProcess != nullptr && (current == nullptr || executingProcess->process.priority > current->process.priority)) {
                Process& process = executingProcess->process;
                process.remainingTime--;

                currentTime++;

                if (process.remainingTime == 0) {
                    process.ct = currentTime;
                    process.tat = process.ct - process.at;
                    process.wt = process.tat - process.bt;
                    executingProcess = nullptr;
                }
            } else if (!readyQueue.empty()) {
                Node* nextProcess = readyQueue.top();
                readyQueue.pop();
                if (executingProcess != nullptr && executingProcess->process.pid != nextProcess->process.pid) {
                    // Preempt the current process
                    Process& process = executingProcess->process;
                    process.remainingTime++;
                    readyQueue.push(executingProcess);
                }
                executingProcess = nextProcess;
            } else {
                currentTime++;
            }
        }
    }

    struct ComparatorPreemptivePriority {
        bool operator()(Node* a, Node* b) {
            return a->process.priority > b->process.priority;
        }
    }

    // void roundRobinScheduling(int timeSlice) {
        if (head == nullptr) {
            return; // Nothing to schedule
        }

        std::queue<Node*> readyQueue;
        Node* current = head;
        int currentTime = 0;

        while (current != nullptr || !readyQueue.empty()) {
            while (current != nullptr && current->process.at <= currentTime) {
                readyQueue.push(current);
                current = current->next;
            }

            if (!readyQueue.empty()) {
                Node* executingProcess = readyQueue.front();
                readyQueue.pop();
                Process& process = executingProcess->process;
                int timeRemaining = std::min(timeSlice, process.remainingTime);

                currentTime += timeRemaining;
                process.remainingTime -= timeRemaining;

                if (process.remainingTime == 0) {
                    process.ct = currentTime;
                    process.tat = process.ct - process.at;
                    process.wt = process.tat - process.bt;
                } else {
                    readyQueue.push(executingProcess); // Re-add the process to the queue if it's not completed
                }
            } else if (current != nullptr) {
                currentTime = current->process.at; // Skip idle time if no process is ready
            }
        }
    }

    void printProcessesInTableFormat() {
        std::cout << "PID\tAT\tBT\tCT\tTAT\tWT\tPriority" << std::endl;
        Node* current = head;

        while (current != nullptr) {
            Process& process = current->process;
            std::cout << process.pid << "\t" << process.at << "\t" << process.bt << "\t" << process.ct << "\t" << process.tat << "\t" << process.wt << "\t" << process.priority << std::endl;
            current = current->next;
        }
    };

};

int main() {
    LinkedList processList;

    // Insert processes
    processList.insert(Process(1, 1, 10, 2));
    processList.insert(Process(2, 2, 29, 1));
    processList.insert(Process(3, 3, 3, 4));
    processList.insert(Process(4, 2, 7, 9));
    processList.insert(Process(5, 1, 12, 2));

    // Perform other operations as needed
    std::cout << "The given input is :" << std::endl;
    processList.printProcessesInTableFormat();
    processList.fcfsScheduling();
    std::cout << "RESULT OF FCFS" << std::endl;
    processList.printProcessesInTableFormat();
    processList.SJFScheduling();
    std::cout << "SJFScheduling" << std::endl;
    // processList.preemptiveSJFScheduling();
    // // processList.sortByPriorityAndUpdateCT();
    // std::cout << "preemptiveSJFScheduling" << std::endl;
    // processList.printProcessesInTableFormat();

    return 0;
}
