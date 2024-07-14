package OS_project;

import java.util.Scanner;

class Partition {
    int id;
    int size;
    boolean occupied;

    public Partition(int id, int size) {
        this.id = id;
        this.size = size;
        this.occupied = false;
    }
}

class FixedPartitionAllocator {
    private Partition[] partitions;

    public FixedPartitionAllocator(int[] partitionSizes) {
        partitions = new Partition[partitionSizes.length];
        for (int i = 0; i < partitionSizes.length; i++) {
            partitions[i] = new Partition(i, partitionSizes[i]);
        }
    }

    public void allocate(int processSize) {
        for (Partition partition : partitions) {
            if (!partition.occupied && partition.size >= processSize) {
                System.out.println("Process allocated to Partition " + partition.id);
                partition.occupied = true;
                return;
            }
        }
        System.out.println("Unable to allocate process with size " + processSize);
    }

    public void deallocate(int partitionId) {
        if (partitionId >= 0 && partitionId < partitions.length) {
            partitions[partitionId].occupied = false;
            System.out.println("Partition " + partitionId + " deallocated");
        } else {
            System.out.println("Invalid partition ID");
        }
    }

    public void displayStatus() {
        for (Partition partition : partitions) {
            System.out.println("Partition " + partition.id + ": " +
                    (partition.occupied ? "Occupied" : "Free") +
                    ", Size: " + partition.size);
        }
    }
}

class FixedPartitionAllocation {
    public static void main(String[] args) {
        int[] partitionSizes = {100, 200, 150, 300};
        FixedPartitionAllocator allocator = new FixedPartitionAllocator(partitionSizes);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Allocate Process");
            System.out.println("2. Deallocate Partition");
            System.out.println("3. Display Memory Status");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter process size: ");
                    int processSize = scanner.nextInt();
                    allocator.allocate(processSize);
                    break;
                case 2:
                    System.out.print("Enter partition ID to deallocate: ");
                    int partitionId = scanner.nextInt();
                    allocator.deallocate(partitionId);
                    break;
                case 3:
                    allocator.displayStatus();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
