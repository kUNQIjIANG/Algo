/**
 * Created by kunqi
 * ON 12/21/18 10:32 PM
 */

public class HollandFlag {
    private static void swap(int[] arr, int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    static int[] hollandSort(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while(index <= right){
            if (nums[index] < 1){
                // 前面不会换过来大的
                swap(nums,left++,index++);
            }else if(nums[index] > 1){
                swap(nums,index,right--);
            }else index++;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] test = {0,1,2,1,1,0,2,1,0};
        int[] sorted = hollandSort(test);
        for (int i : sorted){
            System.out.print(i);
        }

    }
}
