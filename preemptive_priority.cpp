#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

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
    int remainingTime;

    Process(int pid, int at, int bt, int prio) {
        this->pid = pid;
        this->at = at;
        this->bt = bt;
        this->priority = prio;
        this->ct = 0; // Initialize completion time to 0
        this->tat = 0; // Initialize turnaround time to 0
        this->wt = 0; // Initialize waiting time to 0
        this->remainingTime = bt;
    }
};

bool compareByArrivalTime(const Process &a, const Process &b) {
    return a.at < b.at || (a.at == b.at && a.priority > b.priority);
}

bool compareByRemainingTime(const Process &a, const Process &b) {
    return a.remainingTime < b.remainingTime;
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
    cout << "PID\tAT\tBT\tPriority" << endl;
    for (const Process &process : processList) {
        cout << process.pid << "\t" << process.at << "\t" << process.bt << "\t" << process.priority << endl;
    }

    sort(processList.begin(), processList.end(), compareByArrivalTime);

    int currentTime = 0;
    vector<Process> completedProcesses;
    priority_queue<Process, vector<Process>, function<bool(Process, Process)>> readyQueue(compareByRemainingTime);

    while (!processList.empty() || !readyQueue.empty()) {
        while (!processList.empty() && processList[0].at <= currentTime) {
            readyQueue.push(processList[0]);
            processList.erase(processList.begin());
        }

        if (!readyQueue.empty()) {
            Process currentProcess = readyQueue.top();
            readyQueue.pop();

            currentProcess.remainingTime--;

            currentTime++;

            if (currentProcess.remainingTime == 0) {
                currentProcess.ct = currentTime;
                currentProcess.tat = currentProcess.ct - currentProcess.at;
                currentProcess.wt = currentProcess.tat - currentProcess.bt;

                completedProcesses.push_back(currentProcess);
            } else {
                readyQueue.push(currentProcess);
            }
        } else {
            currentTime++;
        }
    }

    cout << "RESULT OF PREEMPTIVE SJF SCHEDULING" << endl;
    cout << "PID\tAT\tBT\tCT\tTAT\tWT\tPriority" << endl;
    for (const Process &process : completedProcesses) {
        cout << process.pid << "\t" << process.at << "\t" << process.bt << "\t" << process.ct << "\t"
             << process.tat << "\t" << process.wt << "\t" << process.priority << endl;
    }

    return 0;
}
