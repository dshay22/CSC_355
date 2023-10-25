import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class SortingTest{
    public static void main(String[] args){
        File inputFile = new File("");
        Scanner scnr = new Scanner(inputFile);
        ArrayList<Integer> fileArray = new ArrayList<Integer>();

        fileArray = readFile(scnr);
        System.out.println("Array 1:" + fileArray);

    }

    public static ArrayList<Integer> readFile(Scanner fileReader){
        ArrayList<Integer> fileArry = new ArrayList<Integer>();

        while(fileReader.hasNextInt()){
            fileArry.add(fileReader.nextInt());
        }

        return fileArry;
    }
}