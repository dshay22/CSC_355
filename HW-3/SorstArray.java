import java.util.Arrays;

public class SorstArray {
    public static void main(String[] args) {
        int[] exArry = {0, 2, 5, 6, 7, 8, 10, 2, 8, 9};
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
            while(_a <= splitIndex && _b < inputArry.length){
                if(inputArry[_a] < inputArry[_b]){
                    B[_m++] = inputArry[_a++];

                }
                else{
                    B[_m++] = inputArry[_b++];
                }
            }
            for(int i = _b; i < inputArry.length; ++i){
                B[_m++] = inputArry[_b++];
            }
            for(int i = _a; i <= splitIndex; ++i){
                B[_m++] = inputArry[_a++];
            }

        return B;
    }
}
