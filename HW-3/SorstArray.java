import java.util.Arrays;

public class SorstArray {
    public static void main(String[] args) {
        int[] exArry = {0, 2, 5, 6, 2, 6, 6, 7, 8, 9};
        int splitIndex = 3;

        sortArray(exArry, splitIndex);  //Call my sorting function

        System.out.println("Sorted Array: " + Arrays.toString(exArry));

    }

    public static void sortArray(int[] inputArry, int splitIndex){
        int addAllIndex = 0;
        int[] greatestNums;

        if(inputArry[splitIndex] < inputArry[inputArry.length - 1]){ 

            for(int i = splitIndex + 1; i < inputArry.length - 1; ++i){ //this for loop is to find the index where
                if((inputArry[splitIndex] <= inputArry[i])){            //the second subarray has a value >= the largest value of the 
                    addAllIndex = i;                                    //smaller sub array. we assign that index to addAllIndex
                    break;
                }
            }

            greatestNums = new int[(inputArry.length - addAllIndex)];  // these two lines copy a new array with the largest values in the second sub array
            System.arraycopy(inputArry, addAllIndex, greatestNums, 0, (inputArry.length - addAllIndex));
            
            boolean swapped;

            do {
                swapped = false;
                for(int j = 0; j <= splitIndex + 1; ++j){ //if there are any values in the second sub array that
                    if (inputArry[j] > inputArry[j + 1]) {// are smaller than the largest value in the first sub array
                        int temp = inputArry[j];          //this for loop sorts those values by using temp variables and shifting the elements
                        inputArry[j] = inputArry[j + 1];
                        inputArry[j + 1] = temp;
                        swapped = true;
                    }
                }
            } while(swapped); //continue to swap all the values until the first sub array and 
                              //the left over values in the second sub array are sorted

            for(int j = addAllIndex; j < inputArry.length - 1; ++j){//this for loop adds back the values of the greatest numbers in the second 
                inputArry[j] = greatestNums[j - addAllIndex];       // sorted sub array to the end of the first array
            }
        }
    }
}
