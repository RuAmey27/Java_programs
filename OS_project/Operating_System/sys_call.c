#include <stdio.h>
#include <windows.h>

int main() {
    WIN32_FIND_DATA findFileData;
    HANDLE hFind = FindFirstFile("*", &findFileData);
    
    if (hFind == INVALID_HANDLE_VALUE) {
        perror("FindFirstFile");
        return 1;
    }

    do {
        if (findFileData.dwFileAttributes & FILE_ATTRIBUTE_DIRECTORY) {
            continue; // Skip directories
        }

        printf("Executing: %s\n", findFileData.cFileName);

        // Execute the file
        STARTUPINFO si;
        PROCESS_INFORMATION pi;

        ZeroMemory(&si, sizeof(si));
        si.cb = sizeof(si);
        ZeroMemory(&pi, sizeof(pi));

        if (CreateProcess(findFileData.cFileName, NULL, NULL, NULL, FALSE, 0, NULL, NULL, &si, &pi)) {
            // Wait for the process to finish
            WaitForSingleObject(pi.hProcess, INFINITE);

            // Get information about the executed file
            BY_HANDLE_FILE_INFORMATION fileInformation;
            if (GetFileInformationByHandle(pi.hProcess, &fileInformation)) {
                printf("File Information:\n");
                printf("Size: %ld bytes\n", fileInformation.nFileSizeLow);
                printf("File Index: %ld\n", fileInformation.nFileIndexLow);
                // Add more information as needed
            } else {
                perror("GetFileInformationByHandle");
            }

            // Close process and thread handles.
            CloseHandle(pi.hProcess);
            CloseHandle(pi.hThread);
        } else {
            perror("CreateProcess");
        }

    } while (FindNextFile(hFind, &findFileData) != 0);

    FindClose(hFind);

    return 0;
}
