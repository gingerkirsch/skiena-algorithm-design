package chapter4;

public class Sort {
    public static void heapSort(int arr[]){
        int n = arr.length;

        /**Building heap*/
        for (int i = (n/2 - 1); i >= 0; i--)
            heapify(arr, n, i);

        /**Select the minimum*/
        for (int i = n-1; i >= 0; i--){
            /**Moving the root*/
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            /**Reconstruct the heap*/
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int arr[], int n, int i){
        /**Initialize the root, the left and the right*/
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        /**If left child is larger than root*/
        if (left < n && arr[left] > arr[largest]) largest = left;
        /**If right child is larger than root*/
        if (right < n && arr[right] > arr[largest]) largest = right;
        /**If largest is not root*/
        if (largest != i){
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            /**Recursively reconstruct the heap from affected sub-tree*/
            heapify(arr, n, largest);
        }
    }

    public static void printArray(int s[]){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++){
            sb.append(s[i]);
            if (i < s.length - 1) sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void mergeSort(int arr[], int left, int right){
        int middle;

        if (left < right){
            middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }

    private static void merge(int arr[], int left, int middle, int right){
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int leftBuffer[] = new int [n1];
        int rightBuffer[] = new int [n2];

        /**Copy the data into temporary buffers*/
        for (int i = 0; i < n1; i++){
            leftBuffer[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++){
            rightBuffer[j] = arr[middle + 1 + j];
        }

        /**Merge temporary buffers*/
        int i,j;
        i = j = 0;

        int k = left;
        while (i < n1 && j < n2){
            if (leftBuffer[i] <= rightBuffer[j]){
                arr[k] = leftBuffer[i];
                i++;
            } else {
                arr[k] = rightBuffer[j];
                j++;
            }
            k++;
        }

        /**Copy remaining*/
        while (i < n1){
            arr[k] = leftBuffer[i];
            i++;
            k++;
        }

        /**Copy remaining*/
        while (j < n2){
            arr[k] = rightBuffer[j];
            j++;
            k++;
        }

    }


    public static void quickSort(int arr[], int low, int high){
        int pivot;
        if ((high - low) > 0){
            pivot = partitions(arr, low, high);
            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);
        }
    }

    private static int partitions(int arr[], int low, int high){
        // debug!!


        int i;  //counter
        int pivot;  //pivot element index
        int firstHigh;  // divider position for pivot element

        pivot = high;
        firstHigh = low;
        for (i = 1; i < high; i++){
            if (arr[i] < arr[pivot]){
                int temp = arr[i];
                arr[i] = pivot;
                pivot = temp;
                firstHigh++;
            }
        }
        int temp = arr[pivot];
        arr[pivot] = arr[firstHigh];
        arr[firstHigh] = temp;
        return firstHigh;
    }


    // implement binary search
    public static int binarySearch(int arr[], int key, int low, int high){
        int middle;
        if (low > high) return(-1);
        middle = (low + high)/2;
        if (arr[middle] == key) return(middle);
        if (arr[middle] > key) return binarySearch(arr, key, low, middle);
        else return binarySearch(arr, key, middle + 1, high);
    }
}
