/**
 * Created by kunqi
 * ON 7/26/18 6:03 PM
 */

import java.lang.Math;

public class MaxProduct {
    static int maxProduct(int[] arr) {
        int curMin, curMax, lastMin, lastMax, res;
        curMin = curMax = lastMin = lastMax = res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curMin = Math.min(arr[i], Math.min(lastMin * arr[i], lastMax * arr[i]));
            curMax = Math.max(arr[i], Math.max(lastMin * arr[i], lastMax * arr[i]));
            res = Math.max(res, curMax);
            lastMax = curMax;
            lastMin = curMin;
        }
        return res;
    }

    public static void main(String[] args){
        int[] arr = {2,3,-2,4};
        System.out.println(maxProduct(arr));
    }

}
