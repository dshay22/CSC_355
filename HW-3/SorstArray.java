import java.util.Arrays;

public class SorstArray {
    public static void main(String[] args) {
        int[] exArry = {0, 2, 5, 6, 7, 8, 8, 2, 4, 9};
        int splitIndex = 6;

        int[] newArry = sortArray(exArry, splitIndex);  //Call my sorting function

        System.out.println("Sorted Array: " + Arrays.toString(newArry));

    }

    public static int[] sortArray(int[] inputArry, int splitIndex){

        int[] B = new int[inputArry.length];
        int _a = 0; //Index for the first subarray
        int _b = splitIndex + 1; //Index for the second subarray
        int _m = 0; //Index for the merged array

            //Merge the subarrays
            while(_a <= splitIndex && _b < inputArry.length){ //moves through each of the sub-arrays and compares there values
                if(inputArry[_a] < inputArry[_b]){           //if the first subarray is smaller then add to new array
                    B[_m++] = inputArry[_a++];

                }
                else{                                     //if second sub-array is smaller add this value to new array
                    B[_m++] = inputArry[_b++];
                }
            }
            for(int i = _b; i < inputArry.length; ++i){  //if there are remaining values in the sub arrays add them
                B[_m++] = inputArry[_b++];
            }
            for(int i = _a; i <= splitIndex; ++i){      //if there are remaining values in the sub arrays add them
                B[_m++] = inputArry[_a++]; 
            }

        return B;
    }
}
