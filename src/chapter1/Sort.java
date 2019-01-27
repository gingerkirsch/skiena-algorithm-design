package chapter1;

public class Sort {
    public static void insertionSort(int s[]){
        printArray(s);
        for (int i = 0; i < s.length; i++){
            int j = i;
            while (j > 0 && s[j] < s[j - 1]){
                int temp = s[j];
                s[j] = s[j - 1];
                s[j - 1] = temp;
                j--;
            }
        }
        printArray(s);
    }

    public static void insertionSort2(int s[]){
        printArray(s);
        for (int i = s.length - 1; i >= 0; i--){
            for (int j = i - 1; j >= 0; j--){
                if (s[j] > s[j + 1]){
                    int temp = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = temp;
                }
            }
        }
        printArray(s);
    }

    public static void selectionSort(int s[]){ //bug?
        printArray(s);
        int min;
        for (int i = 0; i < s.length; i++){
            min = i;
            for (int j = i + 1; j < s.length; j++){
                if (s[j] < s[min]){
                    min = j;
                    int temp = s[i];
                    s[i] = s[min];
                    s[min] = temp;
                }
            }
        }
        printArray(s);
    }

    private static void printArray(int s[]){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++){
            sb.append(s[i]);
            if (i < s.length - 1) sb.append(" ");
        }
        System.out.println(sb.toString());
    }

}
