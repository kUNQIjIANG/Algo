/**
 * Created by kunqi
 * ON Apr/02/2019 18:26
 */
public class RotateArraySearch {
    static int minValueInRotateArray(int[] arr){
        int left = 0;
        int right = arr.length-1;
        int mid;
        while(left<right){
            // 数组已顺序
            if (arr[left] < arr[right]) return arr[0];
            if (right - left == 1) return arr[right];
            mid = (left+right)/2;
            // mid在前半
            if(arr[mid] > arr[left]){
                left = mid;
            // mid在后半
            }else if(arr[mid] < arr[right]){
                right = mid;
            }
        }
        return -1;
    }

    static int findValueInRotateArray(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        int mid;
        while(left<right){
            mid = (left + right)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target){
                if (target < arr[right]) left = mid;
                else right = mid;
            }else{
                if (target < arr[left]) left = mid;
                else  right = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = {6,7,8,9,1,2,3,4,5};
        int min = minValueInRotateArray(arr);
        System.out.println(min);
        System.out.println(findValueInRotateArray(arr,1));
    }
}
