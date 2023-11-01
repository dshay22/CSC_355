import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SortGrid extends SortingTest{

    private int[][] arry2D;
    private int dimension = 0;

    SortGrid(int gridSize, Scanner fileReader){
        dimension = gridSize;                     //initialize size var
        arry2D = new int[gridSize][gridSize];     //initialize size array

        for(int i = 0; i < dimension; ++i){       //populate array
            for(int j = 0; j < dimension; ++j){
                if(fileReader.hasNextInt()){
                    arry2D[i][j] = fileReader.nextInt();
                }
            }
        }

    }

    public int high(){
        return arry2D.length - 1;
    }

    public int[][] get2D(){
        return this.arry2D;
    }

    public void sort(int[][] arr2D){

        int[] flatArry = flatten(arr2D);
        quickSort(flatArry);
        arr2D = expand(flatArry, dimension, dimension);
        printArray2D(arr2D);

    }

    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int low, int high) {

        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
        
    }
    
    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public int[] flatten(int[][] arr2D) {
        int totalElements = 0;
    
        for (int[] row : arr2D) {
            totalElements += row.length;
        }
    
        int[] flattenedArray = new int[totalElements];
        int index = 0;
    
        for (int[] row : arr2D) {
            for (int element : row) {
                flattenedArray[index] = element;
                index++;
            }
        }
    
        return flattenedArray;
    }

    public static int[][] expand(int[] arr, int numRows, int numCols) {
    
        int[][] twoDArray = new int[numRows][numCols];
        int index = 0;
    
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                twoDArray[row][col] = arr[index];
                index++;
            }
        }
    
        return twoDArray;
    }

    public void printArray2D(int[][] arr) {
        for (int[] row : arr) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

}
