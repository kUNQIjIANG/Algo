/**
 * Created by kunqi on 7/4/18.
 */
public class BubbleSort {
    private static void bubbleSort(int[] arr){
        int n = arr.length;
        boolean flag;
        int temp;
        for (int i = 0; i < n; i++){
            flag = true;
            // upper bound: one smallest placed each run
            for (int j = n-1; j>i; j--){
                if (arr[j] < arr[j-1]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    flag = false;
                }
            }
            if (flag) break;
        }
    }

    private static void bubbleSort2(int[] arr){
        int n = arr.length;
        boolean flag = false;
        int temp;
        while (!flag){
            flag = true;
            for (int i = n-1; i > 0; i--){
                if (arr[i] < arr[i-1]){
                    temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                    flag = false;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {10,9,9,8,7,6,5,4,3};
        BubbleSort.bubbleSort2(arr);
        for (int i : arr){
            System.out.println(i);
        }
    }
}
