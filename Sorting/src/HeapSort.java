/**
 * Created by kunqi
 * ON 7/11/18 12:45 AM
 */

// maxHeap : a[i] >= a[2*i] and a[i] >= a[2*i+1]
public class HeapSort {

    private static void topDown(int[] arr, int index){
        int temp = arr[index];
        for (int j = index*2; j < arr.length; j *= 2){
            if (j+1<arr.length && arr[j] < arr[j+1]) j++;
            if (temp > arr[j]) break;
            else{
                arr[index] = arr[j];
                index = j;
            }
        }
        arr[index] = temp;
    }

    private static void buildHeap(int[] arr){
        for (int i = arr.length/2; i >= 0; i--){
            topDown(arr,i);
        }
    }

    public static void main(String[] args){
        int[] arr = {4,3,6,1,5,7,7,3};
        HeapSort.buildHeap(arr);
        for (int i : arr){
            System.out.println(i);
        }
    }
}
