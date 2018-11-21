import java.util.ArrayList;

/**
 * Created by kunqi
 * ON 11/21/18 4:06 PM
 */

// find least k value in an array
// complexity : O(nlogk) better than O(nlonN) if sort first

public class TopK {
    public static ArrayList<Integer> topK(int[] arr, int k){
        int len = arr.length;
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (arr == null || arr.length < k) return res;

        // build max heap
        for (int pos = len/2-1; pos >= 0; pos--){
            adjustMaxHeap(arr,pos,k);
        }

        for (int i = k; i < len; i++){
            // 小于前k小中最大的，可以进入前k小
            if (arr[i] < arr[0]){
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                adjustMaxHeap(arr,0,k);
            }
        }

        for (int j = k-1; j >= 0; j--){
            res.add(arr[j]);
        }
        return res;
    }

    public static void adjustMaxHeap(int[] arr, int pos, int len){
        int temp = arr[pos];
        for (int child = 2*pos+1; child < len; child = pos*2+1){
            if (arr[child] < arr[child+1]) child += 1;
            if (temp < arr[child]){
                arr[pos] = arr[child];
                pos = child;
            }else{
                break;
            }
        }
        arr[pos] = temp;
    }

    public static void main(String[] args){
        int[] arr = {9,8,7,6,5};
        System.out.println(TopK.topK(arr,3));
    }
}
