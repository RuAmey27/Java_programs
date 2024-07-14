#include <stdio.h>
#include <Windows.h>

#define BUFFER_SIZE 5

HANDLE mutex;        // Controls access to the shared buffer
HANDLE empty;        // Counts empty slots in the buffer
HANDLE full;         // Counts filled slots in the buffer
int buffer[BUFFER_SIZE];
int in = 0, out = 0, count = 0;

DWORD WINAPI produce(LPVOID lpParam) {
    for (int i = 1; i <= 10; i++) {
        WaitForSingleObject(empty, INFINITE); // Wait if the buffer is full

        WaitForSingleObject(mutex, INFINITE); // Enter critical section
        buffer[in] = i;
        in = (in + 1) % BUFFER_SIZE;
        count++;
        printf("Produced: %d, Count: %d\n", i, count);
        ReleaseMutex(mutex); // Exit critical section

        ReleaseSemaphore(full, 1, NULL); // Signal that the buffer is no longer empty

        Sleep(1000); // Simulate some work
    }

    printf("Producer thread finished.\n");

    return 0;
}

DWORD WINAPI consume(LPVOID lpParam) {
    for (int i = 1; i <= 10; i++) {
        WaitForSingleObject(full, INFINITE); // Wait if the buffer is empty

        WaitForSingleObject(mutex, INFINITE); // Enter critical section
        int item = buffer[out];
        out = (out + 1) % BUFFER_SIZE;
        count--;
        printf("Consumed: %d, Count: %d\n", item, count);
        ReleaseMutex(mutex); // Exit critical section

        ReleaseSemaphore(empty, 1, NULL); // Signal that the buffer is no longer full

        Sleep(1500); // Simulate some work
    }

    printf("Consumer thread finished.\n");

    return 0;
}

int main() {
    printf("Main thread starting.\n");

    mutex = CreateMutex(NULL, FALSE, NULL);
    empty = CreateSemaphore(NULL, BUFFER_SIZE, BUFFER_SIZE, NULL);
    full = CreateSemaphore(NULL, 0, BUFFER_SIZE, NULL);

    if (mutex == NULL || empty == NULL || full == NULL) {
        fprintf(stderr, "Error creating synchronization objects\n");
        return 1;
    }

    HANDLE producer = CreateThread(NULL, 0, produce, NULL, 0, NULL);
    HANDLE consumer = CreateThread(NULL, 0, consume, NULL, 0, NULL);

    if (producer == NULL || consumer == NULL) {
        fprintf(stderr, "Error creating threads\n");
        return 1;
    }

    WaitForSingleObject(producer, INFINITE);
    WaitForSingleObject(consumer, INFINITE);

    CloseHandle(mutex);
    CloseHandle(empty);
    CloseHandle(full);

    printf("Main thread finished.\n");

    return 0;
}
