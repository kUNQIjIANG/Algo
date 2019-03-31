/**
 * Created by kunqi
 * ON Mar/31/2019 15:37
 */
public class EditDistance {
    private static int leastEditDistance(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 0; i <=len1; i++){
            dp[i][0] = i;
        }
        for (int j = 0; j <=len2; j++){
            dp[0][j] = j;
        }
        for (int i = 1; i <=len1; i++){
            for(int j = 1; j <= len2; j++){
                int last = s1.charAt(i-1) == s2.charAt(j-1) ? 0:1;
                dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j])+1,dp[i-1][j-1]+last);
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2= "adbe";
        System.out.println(leastEditDistance(s1,s2));
    }
}
