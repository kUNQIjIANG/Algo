/**
 * Created by kunqi
 * ON 7/26/18 12:01 AM
 */

public class BinarySearch {

    static int recursiveBinarySearch(int[] arr, int s, int low, int high){
        if (low <= high){
            int mid = (low+high)/2;
            if (arr[mid] == s) return mid;
            if (arr[mid] > s) return recursiveBinarySearch(arr,s,low,mid-1);
            else return recursiveBinarySearch(arr,s,mid+1,high);
        }
        return -1;
    }

    static int binarySearch(int[] arr, int s, int low, int high){
        while ( low <= high){
            int mid = (low + high) / 2;
            if (arr[mid] == s) return mid;
            if (arr[mid] > s) high = mid-1;
            else low = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7};
        int s = 3;
        System.out.println(binarySearch(arr,s,0,arr.length-1));
    }
}
