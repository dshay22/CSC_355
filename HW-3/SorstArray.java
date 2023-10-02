import java.util.Arrays;

public class SorstArray {
    public static void main(String[] args) {
        int[] exArry = {0, 2, 5, 6, 2, 6, 6, 7, 8, 9};
        int splitIndex = 3;

        sortArray(exArry, splitIndex);

        System.out.println("Sorted Array: " + Arrays.toString(exArry));

    }

    public static void sortArray(int[] inputArry, int splitIndex){
        int addAllIndex = 0;
        int[] greatestNums;
        int[] middleNums;

        if(inputArry[splitIndex] < inputArry[inputArry.length - 1]){

            for(int i = splitIndex + 1; i < inputArry.length - 1; ++i){
                if((inputArry[splitIndex] <= inputArry[i])){
                    addAllIndex = i;
                    break;
                }
            }

            greatestNums = new int[(inputArry.length - addAllIndex)];
            System.arraycopy(inputArry, addAllIndex, greatestNums, 0, (inputArry.length - addAllIndex));
            
            boolean swapped;
            do {
                swapped = false;
                for(int j = 0; j <= splitIndex + 1; ++j){
                    if (inputArry[j] > inputArry[j + 1]) {
                        int temp = inputArry[j];
                        inputArry[j] = inputArry[j + 1];
                        inputArry[j + 1] = temp;
                        swapped = true;
                    }
                }
            } while(swapped);

            for(int j = addAllIndex; j < inputArry.length - 1; ++j){
                inputArry[j] = greatestNums[j - addAllIndex];
            }
        }
    }
}
