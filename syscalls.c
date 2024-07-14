#include <stdio.h>
#include <stdlib.h>
#include <dirent.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>

int main() {
    DIR *dir;
    struct dirent *entry;
    struct stat fileStat;

    // Open the current directory
    dir = opendir(".");
    if (dir == NULL) {
        perror("opendir");
        exit(EXIT_FAILURE);
    }

    // Read the next entry
    entry = readdir(dir);
    if (entry == NULL) {
        perror("readdir");
        closedir(dir);
        exit(EXIT_FAILURE);
    }

    // Check if it's a regular file and executable
    if (entry->d_type == DT_REG && access(entry->d_name, X_OK) == 0) {
        printf("Executing: %s\n", entry->d_name);

        // Execute the file
        if (fork() == 0) {
            // Child process
            execl(entry->d_name, entry->d_name, NULL);
            perror("execl");
            exit(EXIT_FAILURE);
        } else {
            // Parent process
            wait(NULL);
        }

        // Get information about the executed file using stat
        if (stat(entry->d_name, &fileStat) == 0) {
            printf("File Information:\n");
            printf("Size: %ld bytes\n", fileStat.st_size);
            printf("Inode: %ld\n", fileStat.st_ino);
            // Add more information as needed
        } else {
            perror("stat");
            exit(EXIT_FAILURE);
        }
    } else {
        printf("Skipped non-executable file: %s\n", entry->d_name);
    }

    // Close the directory
    closedir(dir);

    return 0;
}
