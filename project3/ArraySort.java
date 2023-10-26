import java.util.ArrayList;
import java.util.List;

public class ArraySort extends SortingTest{

    public void sort(ArrayList<Integer> arr){
        mergeSort(0, arry.size() - 1);
    }

    public void mergeSort(int lowIndex, int highIndex){
        if(lowIndex >= highIndex){
            return;
        }

        int middleIndex = (lowIndex + highIndex) / 2;
        mergeSort(lowIndex, middleIndex);
        mergeSort(middleIndex + 1, highIndex);
        merge(lowIndex, middleIndex, highIndex);
    }

    public void merge(int lowIndex, int middleIndex, int highindex){
        List<Integer> leftArry = new ArrayList<Integer>(arry.subList(lowIndex, middleIndex + 1));
        List<Integer> rightArry = new ArrayList<Integer>(arry.subList(middleIndex + 1, highindex + 1));

        int leftIndex = 0;
        int rightIndex = 0;
        int sortArryIndex = lowIndex;

        while(leftIndex < leftArry.size() && rightIndex < rightArry.size()){ //move thuogh both arrays

            int val = leftArry.get(leftIndex).compareTo(rightArry.get(rightIndex)) <= 0 ? leftArry.get(leftIndex++) : rightArry.get(rightIndex++);

            arry.set(sortArryIndex++, val);
        }

        while(leftIndex < leftArry.size()){// if there are still values left in the left array
            arry.set(sortArryIndex++, leftArry.get(leftIndex++));
        }

        while(rightIndex < rightArry.size()){// if there are still values left in the left array
            arry.set(sortArryIndex++, rightArry.get(rightIndex++));
        }
    }
}
