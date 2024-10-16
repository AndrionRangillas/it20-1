package topic_4_queue;

import java.util.LinkedList;

public class Queue {
    private LinkedList<Customer> queue;

    public Queue() {
        queue = new LinkedList<>();
    }

    public void enqueue(Customer customer) {
        queue.addLast(customer);
    }

    public Customer dequeue() {
        return queue.isEmpty() ? null : queue.removeFirst();
    }

    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
        } else {
            System.out.println("Current Queue:");
            for (Customer customer : queue) {
                System.out.println(customer.getName());
            }
        }
    }
}
