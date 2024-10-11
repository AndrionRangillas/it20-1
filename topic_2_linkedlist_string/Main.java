package topic_2_linkedlist_string;

import java.util.Scanner;

public class Main {

	  //static variables so it can be accessible within this class.
    public static LinkedList list = new LinkedList();
    public static Scanner sc = new Scanner(System.in);
    //This is a block of methods
    public static void adding() {
        boolean repeat = true;
        while (repeat) {
            System.out.println("What element would you like to add?");
            System.out.print("Element: ");
            String elemt = sc.next();
            list.add(elemt);
            System.out.println("Element ' " + elemt + " ' added successfully");
            System.out.println("Would you like to add more?" + "\nPress 1 for YES \nPress 2 for NO");
            int resp = sc.nextInt();
            if (resp == 1) {
                repeat = true;
            } else if (resp == 2) {
                repeat = false;
            } else {
                System.out.println("Invalid input. Please enter 1 or 2.");
                sc.close();
                break;
            }
        }
    }
    public static void move() {
        System.out.println("Enter the first index you want to swap: ");
        int element1 = sc.nextInt();
        System.out.println("Enter the second index you want to swap: ");
        int element2 = sc.nextInt();
        list.moveNodePointer(element1, element2);
        list.printList();
    }
    public static void display() {
        list.printList();
    }
    public static void delete() {
        System.out.println("What element would you like to delete from this list?");
        list.printList();
        String element = sc.next();
        list.deleteByValue(element);
        System.out.println("Element '" + element + "' successfully deleted!");
        System.out.print("List: ");
        list.printList();
    }
    public static void main(String[] args) {
        //Displaying Menu Choices
        System.out.println("Welcome to Simple LinkedList Program!");
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
                        adding();
                        break;
                    case 2:
                        move();
                        break;
                    case 3:
                        display();
                        break;
                    case 4:
                        delete();
                        break;
                    case 5:
                        exit = true;
                        System.out.println("Thank you for using Simple Linkedlist Program. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                }
            } catch (Exception e) {
                System.out.println("Error 404. Input Invalid");
                break;
            }
        }
    }
}