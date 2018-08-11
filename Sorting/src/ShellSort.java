/**
 * Created by kunqi
 * ON 8/11/18 3:52 PM
 */

public class ShellSort {
    // improved insertion sort : O(n^2)
    static void shellSort(int[] arr){
        for (int gap = arr.length/2; gap >= 1; gap/=2){
            for (int i = gap; i < arr.length; i++){
                int temp = arr[i];
                int j = i - gap;
                while(j >= 0 && arr[j] > temp){
                    arr[j+gap] = arr[j];
                    j -= gap;
                }
                j += gap;
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {7,6,4,3,3,2,1};
        ShellSort.shellSort(arr);
        for (int i : arr){
            System.out.println(i);
        }

    }
}
