/**
 * Created by kunqi
 * ON 7/11/18 12:45 AM
 */

// maxHeap : a[i] >= a[2*i] and a[i] >= a[2*i+1]
// time complexity : nlog(n)
// space complexity : O(1)

public class HeapSort {

    private static void topDown(int[] arr, int index, int len){

        arr[0] = arr[index];
        for (int j = index*2; j <= len; j *= 2){
            if (j<len && arr[j] < arr[j+1]) j++;
            if (arr[0] > arr[j]) break;
            else{
                arr[index] = arr[j];
                index = j;
            }
        }
        arr[index] = arr[0];
    }
    // 最大堆
    private static void buildHeap(int[] arr){
        for (int i = (arr.length-1)/2; i > 0; i--){
            topDown(arr,i,arr.length-1);
        }
    }

    private static void heapSort(int[] arr){
        buildHeap(arr);
        for (int i = arr.length-1; i>0; i--){
            System.out.println(arr[1]);
            arr[1] = arr[i];
            topDown(arr,1,i-1);
        }
    }

    private static void adjustUp(int[] arr, int k){
        // k is position
        arr[0] = arr[k];
        int i = k/2; //parent node
        while(i>0 && arr[i] < arr[0]){
            arr[k] = arr[i];
            k = i;
            i = k/2;
        }
        arr[k] = arr[0];
    }

    public static void main(String[] args){
        int[] arr = {0,9,53,65,17,32,78,45,87};
        heapSort(arr);
        //adjustUp(arr,8);
        for (int i = 1; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
