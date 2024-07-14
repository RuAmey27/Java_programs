#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Process {
public:
    int pid;
    int at;
    int bt;
    int ct;
    int tat;
    int wt;
    int priority;

    Process(int pid, int at, int bt, int prio) {
        this->pid = pid;
        this->at = at;
        this->bt = bt;
        this->priority = prio;
        this->ct = 0; // Initialize completion time to 0
        this->tat = 0; // Initialize turnaround time to 0
        this->wt = 0; // Initialize waiting time to 0
    }
};

bool compareByBurstTime(const Process &a, const Process &b) {
    return a.bt < b.bt;
}

bool compareByArrivalTime(const Process &a, const Process &b) {
    return a.at < b.at || (a.at == b.at && a.pid < b.pid);
}

bool compareByPriority(const Process &a, const Process &b) {
    return a.priority > b.priority;
}

int main() {
    vector<Process> processList;

    // Insert processes
    processList.push_back(Process(1, 0, 10, 3));
    processList.push_back(Process(2, 0, 1, 1));
    processList.push_back(Process(3, 0, 2, 5));
    processList.push_back(Process(4, 0, 1, 4));
    processList.push_back(Process(5, 0, 5, 2));

    cout << "The given input is :" << endl;
    cout << "PID\tAT\tBT\tCT\tTAT\tWT\tPriority" << endl;
    for (const Process &process : processList) {
        cout << process.pid << "\t" << process.at << "\t" << process.bt << "\t"
             << process.ct << "\t" << process.tat << "\t" << process.wt << "\t"
             << process.priority << endl;
    }

    // Sort by burst time (Shortest Job First)
    sort(processList.begin(), processList.end(), compareByBurstTime);
    int currentTime = 0;
    for (Process &process : processList) {
        process.ct = currentTime + process.bt;
        process.tat = process.ct - process.at;
        process.wt = process.tat - process.bt;
        currentTime = process.ct;
    }

    cout << "RESULT OF SJF" << endl;
    cout << "PID\tAT\tBT\tCT\tTAT\tWT\tPriority" << endl;
    for (const Process &process : processList) {
        cout << process.pid << "\t" << process.at << "\t" << process.bt << "\t"
             << process.ct << "\t" << process.tat << "\t" << process.wt << "\t"
             << process.priority << endl;
    }

    // Sort by arrival time (First Come First Serve)
    sort(processList.begin(), processList.end(), compareByArrivalTime);
    currentTime = 0;
    for (Process &process : processList) {
        process.ct = max(currentTime, process.at) + process.bt;
        process.tat = process.ct - process.at;
        process.wt = process.tat - process.bt;
        currentTime = process.ct;
    }

    cout << "RESULT OF FCFS" << endl;
    cout << "PID\tAT\tBT\tCT\tTAT\tWT\tPriority" << endl;
    for (const Process &process : processList) {
        cout << process.pid << "\t" << process.at << "\t" << process.bt << "\t"
             << process.ct << "\t" << process.tat << "\t" << process.wt << "\t"
             << process.priority << endl;
    }

    // Sort by priority (Priority Scheduling)
    sort(processList.begin(), processList.end(), compareByPriority);
    currentTime = 0;
    for (Process &process : processList) {
        process.ct = currentTime + process.bt;
        process.tat = process.ct - process.at;
        process.wt = process.tat - process.bt;
        currentTime = process.ct;
    }

    cout << "RESULT OF PRIORITY SCHEDULING" << endl;
    cout << "PID\tAT\tBT\tCT\tTAT\tWT\tPriority" << endl;
    for (const Process &process : processList) {
        cout << process.pid << "\t" << process.at << "\t" << process.bt << "\t"
             << process.ct << "\t" << process.tat << "\t" << process.wt << "\t"
             << process.priority << endl;
    }

    return 0;
}
