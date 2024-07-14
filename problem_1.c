#include <stdio.h>

// Function prototype
void myFunction(int x);

// Another function with the same signature
void myFunction(long x);

int main() {
    int value = 42;

    // Call the first function
    myFunction(value);

    // Call the second function
    myFunction(value);

    return 0;
}

// Definition of the first function
void myFunction(int x) {
    printf("Calling myFunction with value: %d\n", x);
}

// Definition of the second function
void myFunction(long x) {
    printf("Calling anotherFunction with value: %d\n", x);
}
