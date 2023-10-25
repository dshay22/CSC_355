import java.util.Arrays;

public class ShellSort{

    public void printArr(int[] arr){
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int [] arr){
        int n = arr.length;

        for(int gap = n/2; gap >= 1; gap /= 2){     //creat the gap and keep dividing the gap by 2 until the gap is 1

            for(int i = gap; i < arr.length; ++i){ //start itterating at the gap and move to the right though the array

                int j = i;                          //make j equal to the itterator i

                while( (j >= gap) && (Integer.compare(arr[j], arr[j - gap]) > 0) ){ // compare element [j] with element [j - gap]
                    
                    //swap the values if the j element is smaller than the j - gap element
                    int temp = arr[j];
                    arr[j] = arr[j - gap];
                    arr[j - gap] = temp;

                    j -= gap;  //decriment the j value so we dont get an infinite while loop
                }
            }
        }
    }
}