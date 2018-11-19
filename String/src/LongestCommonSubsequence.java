import java.util.ArrayList;

/**
 * Created by kunqi
 * ON 11/14/18 8:12 PM
 */

// 参考：https://www.cnblogs.com/hapjin/p/5572483.html

public class LongestCommonSubsequence {
    static int lcs(String s_1, String s_2){
        int len_1 = s_1.length();
        int len_2 = s_2.length();

        // 从长度为0开始，所以len+1
        int[][] dp = new int[len_1+1][len_2+1];
        for (int i = 0; i <= len_1; i++){
            dp[i][0] = 0;
        }
        for (int j = 0; j <= len_2; j++){
            dp[0][j] = 0;
        }
        for (int i = 1; i <= len_1; i++){
            for (int j = 1; j <= len_2; j++){
                // i-1 !
                if (s_1.charAt(i-1) == s_2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;

                }
                else if(dp[i-1][j] > dp[i][j-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[len_1][len_2];
    }

    public static void main(String[] args){
        String s_1 = "sbalsgsge";
        String s_2 = "sfdfbgas";
        System.out.println(lcs(s_1,s_2));
    }
}
