/**
 * Created by kunqi
 * ON 11/20/18 9:32 PM
 */
// refer to : https://www.geeksforgeeks.org/minimum-sum-path-triangle/

public class Triangle {
    public static int minSumPath(int[][] A){
        int size = A.length;
        int[] res = new int[size];
        for (int i = 0; i<A[size-1].length; i++){
            res[i] = A[size-1][i];
        }
        for (int i = size-2; i>=0; i--){
            for (int j = 0; j<A[i].length; j++){
                res[j] = Math.min(res[j],res[j+1]) + A[i][j];
            }
        }
        return res[0];
    }

    public static void main(String[] args){
        int[][] tower = {{2},{3,9},{1,6,7}};
        System.out.println(Triangle.minSumPath(tower));
    }
}
