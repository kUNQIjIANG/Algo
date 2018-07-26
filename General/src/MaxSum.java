/**
 * Created by kunqi
 * ON 7/26/18 6:21 PM
 */


public class MaxSum {
    // 连续子串最大和
    static int maxSum(int[] arr){
        int m, res;
        m = res = arr[0];
        for (int i = 1; i< arr.length; i++){
            m = Math.max(arr[i], m+arr[i]);
            res = Math.max(m,res);
        }
        return res;
    }

    public static void main(String[] args){
        int[] arr = {6,-3,-2,7,-15,1,2,2};
        System.out.println(maxSum(arr));
    }
}
