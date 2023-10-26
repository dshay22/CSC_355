import java.util.ArrayList;
import java.util.Arrays;

public class ShellSort extends SortingTest{

    public static void sort(ArrayList<Integer> arr){
        int n = arr.size();

        for(int gap = n/2; gap >= 1; gap /= 2){     //creat the gap and keep dividing the gap by 2 until the gap is 1

            for(int i = gap; i < arr.size(); ++i){ //start itterating at the gap and move to the right though the array

                int j = i;                          //make j equal to the itterator i

                while( (j >= gap) && (Integer.compare(arr.get(j), arr.get(j - gap)) < 0) ){ // compare element [j] with element [j - gap]
                    
                    //swap the values if the j element is smaller than the j - gap element
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j - gap));
                    arr.set((j - gap), temp);

                    j -= gap;  //decriment the j value so we dont get an infinite while loop
                }
            }
        }
    }
}