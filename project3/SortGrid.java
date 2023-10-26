import java.io.File;
import java.io.FileNotFoundException;
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

    public void printArray(){

        for(int i = 0; i < dimension; ++i){

            for(int j = 0; j < dimension; ++j){
                    System.out.print(arry2D[i][j] + " ");
            }

            System.out.println();
        }
    }

    public void sort(){ //implimented quick sort for part 3 of project 3
        int pivot = dimension / 2;

        int temp = arry2D[pivot - 1][dimension - 1];
        arry2D[pivot - 1][dimension - 1] = arry2D[dimension - 1][dimension - 1];
        arry2D[dimension - 1][dimension - 1] = temp;

        for(int i = 0; i < dimension; ++i){       //populate array
            for(int j = 0; j < dimension; ++j){
                if(arry2D[i][j] < arry2D[dimension - 1][dimension - 1]){
                    
                }
            }
        }
    }


}
