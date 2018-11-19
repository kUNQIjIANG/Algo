/**
 * Created by kunqi
 * ON 7/8/18 1:17 AM
 */

// Top-down
public class QuickSort {
    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low; // index of value smaller than pivot
        for (int j = low; j < high; j++){
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;
    }

    private static void quickSort(int[] arr, int low, int high){

        if (low < high){
            int pi = partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    public static void main(String[] args){
        int[] arr = {3,2,1,4,5,2,6,1,7,3};
        QuickSort.quickSort(arr,0,arr.length-1);
        for (int i : arr){
            System.out.println(i);
        }
    }
}
