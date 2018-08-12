import java.lang.Math;

/**
 * Created by kunqi
 * ON 8/12/18 12:23 PM
 */

public class PackageProblem {
    private static int maxValue(int[] weights, int[] values, int limit){
        int n_items = values.length;
        int[][] f = new int[n_items][limit+1];
        // 初始化
        for (int i = 0; i < n_items; i++) {
            f[i][0] = 0;
        }
        for (int j = 1; j <= limit; j++){
            f[0][j] = (j<weights[0]) ? 0: values[0];
        }

        // f[i][j] : 可以取前i个物品，限制是j的时候的最大值
        // 关键是理解如何把问题分成子问题
        // 这里完全没有用到累计的重量
        for (int i = 1; i<n_items; i++){
            for (int j = 1; j<=limit; j++){
                if (weights[i] <= j){
                    f[i][j] = Math.max(f[i-1][j-weights[i]]+values[i],f[i-1][j]);
                }else {
                    f[i][j] = f[i - 1][j];
                }
            }
        }
        return f[n_items-1][limit];
    }

    public static void main(String[] args){
        int[] values = {6,3,5,4,6};
        int[] weights = {2,2,6,5,4};
        int limit = 10;
        System.out.println(PackageProblem.maxValue(weights,values,limit));
    }
}
