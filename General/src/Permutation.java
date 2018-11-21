import java.util.Arrays;

/**
 * Created by kunqi
 * ON 11/21/18 2:10 PM
 */
// refer to : https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/

public class Permutation {
    public static void permute(int[] arr, int left, int right){
        if (left == right){
            System.out.println(Arrays.toString(arr));
        }
        else{
            for (int i = left; i <= right; i++){
                swap(arr,left, i);
                permute(arr, left+1, right);
                // swap back
                swap(arr,left,i);
            }
        }
    }

    public static void swap(int[] arr, int source, int target){
        int temp = arr[source];
        arr[source] = arr[target];
        arr[target] = temp;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3};
        Permutation.permute(arr,0,arr.length-1);
    }
}
