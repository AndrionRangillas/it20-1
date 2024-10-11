package topic_2_linkedlist_int;

import static topic_2_linkedlist_int.Main.list;
import static topic_2_linkedlist_int.Main.sc;

public class Menu {

    //Method for adding option
    public void adding() {
        boolean repeat = true;

        while (repeat) {
            System.out.println("What element would you like to add?");
            System.out.print("Element: ");
            int elemt = sc.nextInt();
            list.add(elemt);
            System.out.println("Element ' " + elemt + " ' added successfully");
            System.out.println("Would you like to add more?" + "\nPress 1 for YES \nPress 2 for NO");
            int resp = sc.nextInt();

            if (resp == 1) {
                System.out.println();
            } else if (resp == 2) {
                repeat = false;
            }
        }
    }

    //Method for move option
    public void move() {
        System.out.println("Enter the first index you want to swap: ");
        int element1 = sc.nextInt();
        System.out.println("Enter the second index you want to swap: ");
        int element2 = sc.nextInt();

        list.moveNodePointer(element1, element2);
        list.printList();
    }

    //Method for display option
    public void display() {
        list.printList();
    }

    //Method for delete option
    public void delete() {
        System.out.println("What element would you like to delete from this list?");
        list.printList();
        int element = sc.nextInt();
        list.deleteByValue(element);
        System.out.println("Element '" + element + "' successfuly deleted!");
        System.out.print("\nHistory List: ");
        list.printList();
    }
}