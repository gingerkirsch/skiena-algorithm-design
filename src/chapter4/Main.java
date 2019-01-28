package chapter4;

import static chapter4.Sort.*;

public class Main {
    public static void main(String[] args){
        int[] array = {5,3,0,1,9};
        printArray(array);
        heapSort(array);
        printArray(array);

        int[] anotherArray = {5,3,0,1,9};
        printArray(anotherArray);
        mergeSort(anotherArray, 0, anotherArray.length - 1);
        printArray(anotherArray);

        int[] oneMoreArray = {5,3,0,1,9};
        printArray(oneMoreArray);
        quickSort(oneMoreArray, 0, oneMoreArray.length - 1);
        printArray(oneMoreArray);

    }
}
