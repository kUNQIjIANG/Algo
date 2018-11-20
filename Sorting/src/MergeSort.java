/**
 * Created by kunqi on 6/30/18.
 */

// Bottom-up : sub-array left and right already sorted

public class MergeSort {
    private static void merge(int[] arr, int left, int right){
        int mid = (left+right) / 2;
        int[] leftArr = new int[mid-left+1];
        int[] rightArr = new int[right-mid];

        System.arraycopy(arr,left,leftArr,0,mid-left+1);
        System.arraycopy(arr,mid+1,rightArr,0,right-mid);

        int k = left;
        int i = 0;
        int j = 0;
        while (i < leftArr.length && j < rightArr.length){
            if (leftArr[i] < rightArr[j]){
                arr[k++] = leftArr[i++];
            } else{
                arr[k++] = rightArr[j++];
            }
        }

        if (i < leftArr.length){
            while (i < leftArr.length){
                arr[k++] = leftArr[i++];
            }
        } else {
            while (j < rightArr.length){
                arr[k++] = rightArr[j++];
            }
        }
    }

    private static void mergeSort(int[] arr, int left, int right){

        if (right > left) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, right);
        }
    }

    public static void main(String[] args){
        int[] arr = {2, 3, 5, 1, 6, 2, 2, 4};
        MergeSort.mergeSort(arr,0,arr.length-1);
        for (int i : arr){
            System.out.println(i);
        }
    }
}
