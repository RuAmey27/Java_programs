package OS_project;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class FIFOPageReplacement {
    private Queue<String> pageQueue;
    private int capacity;

    public FIFOPageReplacement(int capacity) {
        this.pageQueue = new LinkedList<>();
        this.capacity = capacity;
    }

    public void simulatePageAccess(String pageNumber) {
        if (!pageQueue.contains(pageNumber)) {
            if (pageQueue.size() == capacity) {
                String removedPage = pageQueue.poll();
                System.out.println("Page " + removedPage + " removed from memory.");
            }
            pageQueue.offer(pageNumber);
            System.out.println("Page " + pageNumber + " added to memory.");
        } else {
            System.out.println("Page " + pageNumber + " already in memory.");
        }
        displayMemoryStatus();
    }

    private void displayMemoryStatus() {
        System.out.print("Memory Status: ");
        for (String page : pageQueue) {
            System.out.print(page + " ");
        }
        System.out.println();
    }
}

class FIFOPageReplacementAlgorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the capacity of memory: ");
        int capacity = scanner.nextInt();
        FIFOPageReplacement fifo = new FIFOPageReplacement(capacity);

        System.out.println("Enter page numbers (enter 'exit' to end):");
        String input;
        while (true) {
            System.out.print("Page number: ");
            input = scanner.next();

            if (input.equals("exit")) {
                break;
            }

            fifo.simulatePageAccess(input);
        }

        scanner.close();
    }
}
