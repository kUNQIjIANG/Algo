/**
 * Created by kunqi
 * ON 7/8/18 12:48 AM
 */

public class SelectionSort {
    private static void selectionSort(int[] arr){
        int n = arr.length;
        int min;
        for (int i = 0; i < n; i++){
            min = i;
            for (int j = i+1; j < n; j++){
                if (arr[j] < arr[min]) min = j;
            }
            if (min != i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {9,4,2,6,1,5,2,2};
        SelectionSort.selectionSort(arr);
        for (int i : arr){
            System.out.println(i);
        }
    }
}
