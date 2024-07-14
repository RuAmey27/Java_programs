#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

int sharedVariable = 0;

void *additionThread(void *arg) {
    int *increment = (int *)arg;
    sharedVariable += *increment;
    printf("Addition Thread: Incremented by %d. Result: %d\n", *increment, sharedVariable);
    pthread_exit(NULL);
}

void *subtractionThread(void *arg) {
    int *decrement = (int *)arg;
    sharedVariable -= *decrement;
    printf("Subtraction Thread: Decremented by %d. Result: %d\n", *decrement, sharedVariable);
    pthread_exit(NULL);
}

int main() {
    pthread_t addThread, subThread;
    int addValue = 5;  // Value to be added
    int subValue = 3;  // Value to be subtracted

    pthread_create(&addThread, NULL, additionThread, &addValue);
    pthread_create(&subThread, NULL, subtractionThread, &subValue);

    pthread_join(addThread, NULL);
    pthread_join(subThread, NULL);

    printf("Main Thread: Final Result: %d\n", sharedVariable);

    return 0;
}
