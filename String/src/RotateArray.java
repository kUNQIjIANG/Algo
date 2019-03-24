/**
 * Created by kunqi
 * ON Mar/24/2019 23:17
 */

// 左旋数组
public class RotateArray {
    static void leftRotateArray(int[] arr, int p){
        int count = 0;
        int len = arr.length;
        int dest;
        int put;
        int hold;
        for (int i = 0; i < len; i++){
            put = arr[i];
            dest = ((i-p)+len)%len;
            while(dest != i){
                hold = arr[dest];
                arr[dest] = put;
                count ++;
                dest = ((dest-p)+len)%len;
                put = hold;
            }
            arr[i] = put;
            count++;
            if (count==len) return;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        leftRotateArray(arr,2);
        for (int i : arr) System.out.println(i);
    }
}
