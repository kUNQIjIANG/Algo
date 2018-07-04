/**
 * Created by kunqi on 7/4/18.
 */
public class InsertionSort {
    static void insertionSort(int[] arr){
        int n = arr.length;
        for (int i = 1; i < n; i++){
            int temp = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j --;
            }
            arr[j+1] = temp;
        }
    }

    private static void binaryInsertionSort(int[] arr){
        int n = arr.length;
        int temp;
        int low, mid, high;
        for (int i = 1; i < n; i++){
            temp = arr[i];
            if (arr[i] < arr[i-1]) {
                low = 0;
                high = i - 1;
                while (low <= high) {
                    mid = (low + high) / 2;
                    if (arr[mid] > temp) {
                        high = mid - 1;
                    } else if (arr[mid] < temp) {
                        low = mid + 1;
                    } else {
                        high = mid;
                        break;
                    }
                }
                for (int j = i-1; j > high; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[high + 1] = temp;
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {3,4,1,5,66,1,6,2,2,7,1};
        InsertionSort.binaryInsertionSort(arr);
        for( int i : arr){
            System.out.println(i);
        }
    }
}
