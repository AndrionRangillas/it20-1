package topic_4_queue;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();

        while (true) {
            System.out.println("1. Add customer to queue");
            System.out.println("2. Serve customer");
            System.out.println("3. Display queue");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter customer name: ");
                    String name = scanner.nextLine();
                    Customer customer = new Customer(name);
                    queue.enqueue(customer);
                    System.out.println(name + " added to the queue.");
                    break;
                case 2:
                    Customer servedCustomer = queue.dequeue();
                    if (servedCustomer != null) {
                        System.out.println("Served customer: " + servedCustomer.getName());
                    } else {
                        System.out.println("Queue is empty!");
                    }
                    break;
                case 3:
                    queue.displayQueue();
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
