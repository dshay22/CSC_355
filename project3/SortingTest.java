import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class SortingTest {

    public ArrayList<Integer> arry = new ArrayList<Integer>();

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
    private FileWriter shellWriter, arrayWriter;

    private File[] myFileArry = { arr1, arr2, arr3, arr4, arr5};
    private File[] myFileGrid = { grid1, grid2, grid3, grid4, grid5};

    private Scanner shellScnr, arrScanner;

    SortingTest(){

        try {
            shellWriter = new FileWriter("shell_sort_output.txt");
            arrayWriter = new FileWriter("array_sort_output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getArray(){
        return this.arry;
    }

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

    public void outToFile(ArrayList<Integer> arr, FileWriter fileName) {
        try {
            for (Integer number : arr) {
                fileName.write(String.valueOf(number) + " ");
            }
            fileName.write("\n"); // Separate integers with line breaks
            fileName.write("\n\n\nNEW TEST CASE\n");
            //fileName.flush(); // Flush the data to the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void runTestCases() {
        for (int i = 0; i < myFileGrid.length; i++) {
                File newGrid = myFileGrid[i];
                try{
                    Scanner scnr = new Scanner(newGrid);
                    int gridSize = scnr.nextInt();
                    SortGrid gridObj = new SortGrid(gridSize, scnr);
                    gridObj.sort(gridObj.get2D());
                    System.out.println("\n\n");
                    scnr.close();
                }
                catch (Exception e) {
                e.printStackTrace();
                }
            }
            

        ShellSort shellObj = new ShellSort();
        ArraySort arrayObj = new ArraySort();

        for (int i = 0; i < myFileArry.length; i++) {
            File file = myFileArry[i];

            shellObj.arry = new ArrayList<>();
            arrayObj.arry = new ArrayList<>();

            shellObj.arry = readFile(shellScnr, file);
            arrayObj.arry = readFile(arrScanner, file);

            shellObj.sort(shellObj.arry);
            arrayObj.sort(arrayObj.arry);

            // Create separate output files for each iteration
            try {
                FileWriter shellIterationWriter = new FileWriter("shell_sort_output_" + i + ".txt");
                FileWriter arrayIterationWriter = new FileWriter("array_sort_output_" + i + ".txt");

                outToFile(shellObj.arry, shellIterationWriter);
                outToFile(arrayObj.arry, arrayIterationWriter);

                shellIterationWriter.close();
                arrayIterationWriter.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}