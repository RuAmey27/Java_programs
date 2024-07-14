package OS_project;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

class Buffer {
    private Queue<Integer> items = new LinkedList<>();
    private Semaphore mutex = new Semaphore(1);
    private Semaphore empty = new Semaphore(5);
    private Semaphore full = new Semaphore(0);

    public void produce(int item) throws InterruptedException {
        empty.acquire();
        mutex.acquire();

        items.add(item);
        System.out.println("Produced: " + item);

        mutex.release();
        full.release();
    }

    public void consume() throws InterruptedException {
        full.acquire();
        mutex.acquire();

        int item = items.poll();
        System.out.println("Consumed: " + item);

        mutex.release();
        empty.release();
    }
}

class Producer extends Thread {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int item = (int) (Math.random() * 100);
                buffer.produce(item);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer extends Thread {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                buffer.consume();
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ProducerConsumer {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        producer.start();
        consumer.start();
    }
}
