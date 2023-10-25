import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SortingTest{
    public static void main(String[] args){

        File arr1 = new File("array1.txt");
        File arr2 = new File("array2.txt");
        File arr3 = new File("array3.txt");
        File arr4 = new File("array4.txt");
        File arr5 = new File("array5.txt");
        

        Scanner scnr;
        ArrayList<Integer> fileArray = new ArrayList<Integer>();
        ShellSort mySort = new ShellSort();

        try {

            scnr = new Scanner(arr1);
            runTestCases(scnr, fileArray, mySort);

            scnr = new Scanner(arr2);
            runTestCases(scnr, fileArray, mySort);

            scnr = new Scanner(arr3);
            runTestCases(scnr, fileArray, mySort);

            scnr = new Scanner(arr4);
            runTestCases(scnr, fileArray, mySort);

            scnr = new Scanner(arr5);
            runTestCases(scnr, fileArray, mySort);

        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Integer> readFile(Scanner fileReader){
        ArrayList<Integer> fileArry = new ArrayList<Integer>();

        while(fileReader.hasNextInt()){
            fileArry.add(fileReader.nextInt());
        }

        fileReader.close();

        return fileArry;
    }

    public static void runTestCases(Scanner scnr, ArrayList<Integer> arr, ShellSort obj){
        try {
            arr = readFile(scnr);
            System.out.println("Input Array:" + arr + "\n");
            obj.sort(arr);
            System.out.println("Sorted Array: " + arr + "\n");
            System.out.println("\n\n :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: \n\n");
        } 
        catch (Exception  e) {
            e.printStackTrace();
        }
    }
}