/**
 * Created by kunqi
 * ON 7/26/18 6:21 PM
 */

// 参考：https://blog.csdn.net/u013309870/article/details/70145481

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
    // 连续子串最大和并记录位置
    static int[] maxSum_2(int[] arr){
        int max = Integer.MIN_VALUE;
        int rmax = Integer.MIN_VALUE;
        int start = -1;
        int end = -1;
        int temp = -1;
        for (int i = 0; i < arr.length; i++){
            if (max > 0) { max += arr[i];}
            else{
                max = arr[i];
                temp = i;
            }
            if (max > rmax){
                rmax = max;
                start = temp;
                end = i;
            }
        }
        int[] res = new int[3];
        res[0] = rmax;
        res[1] = start;
        res[2] = end;
        return res;
    }

    static int maxSumMatrix(int[][] m){
        if (m.length == 0 || m[0].length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int row = m.length;
        int col = m[0].length;
        int col_start = -1;
        int col_end = -1;
        int row_start = -1;
        int row_end = -1;
        for (int i = 0; i < row; i++){
            int[] tol = new int[col];
            for (int j = i; j < row; j++){
                for (int k = 0; k < col; k++){
                    tol[k] += m[j][k];
                }
                // 列的范围在 子串最大和 函数中搜索
                int[] temp = maxSum_2(tol);
                if (temp[0] > max){
                    max = temp[0];
                    col_start = temp[1];
                    col_end = temp[2];
                    row_start = i;
                    row_end = j;
                }
            }
        }
        System.out.println(row_start);
        System.out.println(row_end);
        System.out.println(col_start);
        System.out.println(col_end);
        return max;
    }

    public static void main(String[] args){
        int[] arr = {6,-3,-2,7,-15,1,2,2};
        System.out.println(maxSum(arr));
        System.out.println(maxSum_2(arr)[1]);
        System.out.println(maxSum_2(arr)[2]);
        int[][] matrix = {{0,-2,-7,0},{9,2,-6,2},{-4,1,-4,1},{-1,8,0,-2}};
        System.out.println(maxSumMatrix(matrix));
    }
}
