import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SortingTest{

    protected ArrayList<Integer> arry = new ArrayList<Integer>();

    private File arr1 = new File("array1.txt");
    private File arr2 = new File("array2.txt");
    private File arr3 = new File("array3.txt");
    private File arr4 = new File("array4.txt");
    private File arr5 = new File("array5.txt");

    private File[] myFileArry = { arr1, arr2, arr3, arr4, arr5};

    private Scanner scnr;

    public ArrayList<Integer> readFile(Scanner fileReader, File input){ //reads the input files

        try {
            fileReader = new Scanner(input);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(fileReader.hasNextInt()){
            arry.add(fileReader.nextInt());
        }

        fileReader.close();

        return arry;
    }

    public void runTestCases(){

        ShellSort shellObj = new ShellSort();
        ArraySort arrayObj = new ArraySort();

        try {
            for(File newFile : myFileArry){ //for shell sort
                shellObj.arry = readFile(scnr, newFile);
                shellObj.sort(shellObj.arry);
                System.out.println("Sorted Array: " + shellObj.arry + "\n");
                System.out.println("\n\n :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: \n\n");
            }

            for(File newFile : myFileArry){// for ArraySort wich I chose to impliment merge sort
                arrayObj.arry = readFile(scnr, newFile);
                arrayObj.sort(arrayObj.arry);
                System.out.println("Sorted Array: " + arrayObj.arry + "\n");
                System.out.println("\n\n :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: \n\n");
            }
        } 
        catch (Exception  e) {
            e.printStackTrace();
        }
    }
}