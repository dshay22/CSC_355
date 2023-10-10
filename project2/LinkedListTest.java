import java.util.Scanner;
public class LinkedListTest {

    // Class variables for Simple and Double linked lists
    private SimplyLinkedList simpleLinkedList;
    //private DoublyLinkedList doublyLinkedList;

    public LinkedListTest() {
        simpleLinkedList = new SimplyLinkedList();
        //doublyLinkedList = new DoublyLinkedList();
    }

    public void insertElements(int[] n) {
        for (int value : n) {
            simpleLinkedList.insert(value);
        }
    }

    public void deleteElement(int option, int data) {
        switch(option){
            case 1:
                simpleLinkedList.deleteHead();
                break;
            case 2:
                simpleLinkedList.deleteTail();
                break;
            case 3:
                simpleLinkedList.delete(data);
                break;
        }
    }

    public void searchElement(int data) {
        int outCome = simpleLinkedList.search(data);
        if(outCome == -1){
            System.out.println(data + " Does not exsist in the linked list");
        }
        else{
            System.out.println(data + " was found at index " + outCome + " in the linked list");
        }
    }

    public void traverseAndPrint() {
        simpleLinkedList.traverse();
    }

    public static void printMainChoices(){
        System.out.println("Make a selection");
        System.out.println("#####################");
        System.out.println("1) Insert");
        System.out.println("2) Delete");
        System.out.println("3) Search");
        System.out.println("4) Traversal & Print");
        System.out.println("0) Exit");
        System.out.println("#####################");
    }

    public static int[] getNums(String str){
        String[] numbers = str.trim().split("\\s+");
        int[] intNumbers = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            intNumbers[i] = Integer.parseInt(numbers[i]);
        }

        return intNumbers;
    }

    public boolean checkHead(){
        return simpleLinkedList.checkHead();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedListTest tester = new LinkedListTest();
        printMainChoices();

        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        System.out.println("Please enter integers separated by spaces:");
                        String inputString = scanner.nextLine();
                        tester.insertElements(getNums(inputString));
                        break;

                    case 2:
                        if(tester.checkHead()) {
                            System.out.println("List is empty please insert values into the list.");
                            break;
                        }
                        System.out.println("Please select which node to delete: 1) Head 2) Tail 3) By Element");
                        int deleteChoice = Integer.parseInt(scanner.nextLine());
                        if (deleteChoice == 1 || deleteChoice == 2) {
                            tester.deleteElement(deleteChoice, -1);
                        } else if (deleteChoice == 3) {
                            System.out.println("Enter the integer data option you would like to delete:");
                            int deleteData = Integer.parseInt(scanner.nextLine());
                            tester.deleteElement(3, deleteData);
                        } else {
                            System.out.println("Invalid input. Please select 1, 2, or 3.");
                        }
                        break;

                    case 3:
                        if(tester.checkHead()) {
                            System.out.println("List is empty please insert values into the list.");
                            break;
                        }
                        System.out.println("Please enter the integer element you are looking for:");
                        int searchData = Integer.parseInt(scanner.nextLine());
                        tester.searchElement(searchData);
                        break;

                    case 4:
                        if(tester.checkHead()) {
                            System.out.println("List is empty please insert values into the list.");
                            break;
                        }
                        tester.traverseAndPrint();
                        break;

                    case 0:
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please select a valid option.");
                        break;
                }

                printMainChoices();
            } 
            catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}


    // TODO: Implement the command line interface for the user based on the given options
    // When the program starts, print the interface below and wait for the user's input.
    // Make sure the input is in the correct format, otherwise print appropriate message.
    // 
    // #####################
    // 1) Insert
    // 2) Delete
    // 3) Search
    // 4) Traversal & Print
    // 0) Exit
    // #####################
    // 
    // Call appropriate method(s) on both lists and print the execution time
    // for each.
    // 
    // 1) If the user types 1, ask for integers separated by whitespace. (e.g. 1 2 3 4)
    //    Then, insert each integer to both lists.
    // 
    // 2) If the user types 2, show additional options 
    //    1) Head
    //    2) Tail
    //    3) By Element
    //
    // 3) If the user types 3, ask for the element they are looking for.
    //    If it doesn't exist, print appropriate message. 
    //    Otherwise, print the index of the node with appropriate message.
    //
    // 4) If the user types 4, print the both of the lists in the format below
    //    For SimplyLinkedList: Forward:  1 -> 2 -> 3 -> 4
    //    For DoublyLinkedList: Forward:  1 -> 2 -> 3 -> 4
    //                          Backward: 4 -> 3 -> 2 -> 1
    //
    // For each of the options above, print the execution time in nanoseconds for the 
    // operation on each list at the end.
    // 
    // Repeat above until the user types 0.
    //
    // Final note: Searching on the doubly linked list can be noticeably faster using 
    // its tail. Try to utilize this property to efficiently traverse through the list.

