package topic_2_linkedlist_int;

import java.util.Scanner;

public class Main {
    //Scanner and Linkedlist object
    public static Scanner sc = new Scanner(System.in);
    public static LinkedList list = new LinkedList();

    public static void main(String[] args) {

        Menu m = new Menu();

        System.out.println("Welcome to LinkedList Simple Program!");
        boolean exit = false;
        while (!exit) {
            System.out.println();
            System.out.println("-----------------------");
            System.out.println("1. Add Element");
            System.out.println("2. Move or Swap Element");
            System.out.println("3. Display");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.println("-----------------------");
            System.out.println();

            try {
                System.out.print("Response: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        m.adding();
                        break;
                    case 2:
                        m.move();
                        break;
                    case 3:
                        m.display();
                        break;
                    case 4:
                        m.delete();
                        break;
                    case 5:
                        exit = true;
                        System.out.println("Thank you for using Linkedlist Simple Program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            } catch (Exception e) {
                System.out.println("Error 40. Input Invalid");
                return;
            }

        }
    }

}
