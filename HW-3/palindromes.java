import java.util.*;
import java.util.LinkedList;

public class palindromes {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        Stack<Character> myStackString = new Stack<>();
        Queue<Character> myQueue = new LinkedList<>();
        char userInput = 't';

        System.out.println("Enter the characters of a word, enter q to quit");

        while(userInput != 'q'){

            userInput = scnr.next().charAt(0);

            if( userInput != 'q'){
                myQueue.add(userInput);
                myStackString.push(userInput);
            }

            System.out.println("You entered " + userInput);
        }

        if(palindromesChecker(myStackString, myQueue)){
            System.out.println("\nThe word you entered is a palindrome");
        }
        else{
            System.out.println("\nThe word you entered is NOT a palindrome");
        }

    }

    public static boolean palindromesChecker(Stack<Character> myStackString, Queue<Character> myQueue){
        for(int i = 0; i < myStackString.size(); ++i){
            if(myStackString.pop() != myQueue.remove()){
                return false;
            }
        }
        return true;
    }
}