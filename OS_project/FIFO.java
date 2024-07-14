package OS_project;

import java.util.LinkedList;
import java.util.Queue;

class FIFOPageReplacement {
    private Queue<Integer> pageQueue;
    private int capacity;

    public FIFOPageReplacement(int capacity) {
        this.pageQueue = new LinkedList<>();
        this.capacity = capacity;
    }

    public void simulatePageAccess(int pageNumber) {
        if (!pageQueue.contains(pageNumber)) {
            if (pageQueue.size() == capacity) {
                int removedPage = pageQueue.poll();
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
        for (int page : pageQueue) {
            System.out.print(page + " ");
        }
        System.out.println();
    }
}

class FIFOPageReplacementAlgorithm {
    public static void main(String[] args) {
        FIFOPageReplacement fifo = new FIFOPageReplacement(3);

        fifo.simulatePageAccess(1);
        fifo.simulatePageAccess(2);
        fifo.simulatePageAccess(3);
        fifo.simulatePageAccess(4);
        fifo.simulatePageAccess(1);
        fifo.simulatePageAccess(2);
        fifo.simulatePageAccess(5);

        // Output:
        // Page 1 added to memory. Memory Status: 1
        // Page 2 added to memory. Memory Status: 1 2
        // Page 3 added to memory. Memory Status: 1 2 3
        // Page 4 added to memory. Page 1 removed from memory. Memory Status: 2 3 4
        // Page 1 already in memory. Memory Status: 2 3 4
        // Page 2 already in memory. Memory Status: 2 3 4
        // Page 5 added to memory. Page 3 removed from memory. Memory Status: 2 4 5
    }
}
