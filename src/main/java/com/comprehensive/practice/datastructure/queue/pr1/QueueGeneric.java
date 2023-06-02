package com.comprehensive.practice.datastructure.queue.pr1;

public class QueueGeneric <T> {
    T[] queue;
    int capacity;
    int front, rear;

    public QueueGeneric(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return front == 0 && capacity == rear;
    }

    public void enQueue(T data) {
        if (isFull()) return;
        if (front == -1) front = 0;
        rear++;
        queue[rear] = data;
        System.out.println("Insert " + data);
    }

    public T deQueue() {
        if (isEmpty()) return null;
        if (front >= rear) {
            front = rear = -1;
        }
        T element = queue[front];
        front++;
        System.out.println("delete element " + element);
        return element;
    }

    void display() {
        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        } else {
            // display the front of the queue
            System.out.println("\nFront index-> " + front);

            // display element of the queue
            System.out.println("Items -> ");
            for (i = front; i <= rear; i++)
                System.out.print(queue[i] + "  ");

            // display the rear of the queue
            System.out.println("\nRear index-> " + rear);
        }
    }
}
class Testing{
    public static void main(String[] args) {
        QueueGeneric<Integer> queue = new QueueGeneric<>(4);

        // try to delete element from the queue
        // currently queue is empty
        // so deletion is not possible
        queue.deQueue();

        // insert elements to the queue
        for(int i = 1; i < 6; i ++) {
            queue.enQueue(i);
        }

        // 6th element can't be added to queue because queue is full
        queue.enQueue(6);

        queue.display();

        // deQueue removes element entered first i.e. 1
        queue.deQueue();

        // Now we have just 4 elements
        queue.display();

    }
}