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
        int pivot = arry2D[dimension - 1][dimension - 1]; //chosen pivot is the last element in my array
        
    }

    public void swap(int row1, int col1, int row2, int col2){
        int temp = arry2D[row1][col1];
        arry2D[row1][col1] = arry2D[row2][col2];
        arry2D[row2][col2] = temp;
    }

    public int compareTo(int var1, int var2, int pivot){
        if(var1 > pivot && var2 < pivot){
            return 1;
        }
        else if(var1 > pivot && !(var2 < pivot)){
            return 2;
        }
        else if(!(var1 > pivot) && var2 < pivot){
            return 3;
        }
        else {
            return 0;
        }
    }

    public void traverse(){
        int pivot = arry2D[dimension - 1][dimension - 1];
        int count = 0;
        int i = 0, j = 0;
        int k = dimension - 2, h = dimension - 2;

        while(count < (dimension * dimension)){
            if(compareTo(arry2D[i][j], arry2D[k][h], pivot) == 1){
                swap(i,j,k,h);
                h--;
                j++;
                count++;
            }
            else if (compareTo(arry2D[i][j], arry2D[k][h], pivot) == 2){
                h--;
                count++;
            }
            else if(compareTo(arry2D[i][j], arry2D[k][h], pivot) == 3){
                j++;
                count++;
            }
            
        }
    }


}
