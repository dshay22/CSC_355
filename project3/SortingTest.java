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

    private File grid1 = new File("testGrid1.txt");
    private File grid2 = new File("testGrid2.txt");
    private File grid3 = new File("testGrid3.txt");
    private File grid4 = new File("testGrid4.txt");
    private File grid5 = new File("testGrid5.txt");

    private File[] myFileArry = { arr1, arr2, arr3, arr4, arr5};
    private File[] myFileGrid = { grid1};//, grid2, grid3, grid4, grid5};

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
        int gridSize;

        try {
            // for(File newFile : myFileArry){ //for shell sort
            //     shellObj.arry = readFile(scnr, newFile);
            //     shellObj.sort(shellObj.arry);
            //     System.out.println("Sorted Array: " + shellObj.arry + "\n");
            //     System.out.println("\n\n :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: \n\n");
            // }

            // for(File newFile : myFileArry){// for ArraySort wich I chose to impliment merge sort
            //     arrayObj.arry = readFile(scnr, newFile);
            //     arrayObj.sort(arrayObj.arry);
            //     System.out.println("Sorted Array: " + arrayObj.arry + "\n");
            //     System.out.println("\n\n :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: \n\n");
            // }
            
            
            for(File newGrid : myFileGrid){
                scnr = new Scanner(newGrid);
                gridSize = scnr.nextInt();
                SortGrid gridObj = new SortGrid(gridSize, scnr);
                gridObj.printArray();
                gridObj.sort();
                System.out.println();
                gridObj.printArray();

            }

        } 
        catch (Exception  e) {
            e.printStackTrace();
        }
    }
}