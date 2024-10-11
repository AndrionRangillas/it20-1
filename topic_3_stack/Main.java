package topic_3_stack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack();
        int choice;

        do {
            System.out.println("\nStack Operations:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Check if Empty");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a number to push: ");
                    int data = scanner.nextInt();
                    stack.push(data);
                    System.out.println(data + " pushed to stack.");
                    break;
                case 2:
                    Integer poppedValue = stack.pop();
                    if (poppedValue != null) {
                        System.out.println(poppedValue + " popped from stack.");
                    }
                    break;
                case 3:
                    Integer topValue = stack.peek();
                    if (topValue != null) {
                        System.out.println("Top value: " + topValue);
                    }
                    break;
                case 4:
                    System.out.println("Stack is empty: " + stack.isEmpty());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
