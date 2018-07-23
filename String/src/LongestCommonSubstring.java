/**
 * Created by kunqi
 * ON 7/23/18 5:12 PM
 */

public class LongestCommonSubstring {
    // brutal O(n^3)
    private static int longestCommonSubstring(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1 == 0 || len2 == 0) return 0;
        else {
            int start1 = -1;
            int start2 = -1;
            int longest = 0;
            int comparison = 0;
            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    int length = 0;
                    int m = i;
                    int n = j;
                    while (m < len1 && n < len2) {
                        comparison ++;
                        if (s1.charAt(m) != s2.charAt(n)) break;
                        m++;
                        n++;
                        length++;
                    }
                    if (length > longest) {
                        longest = length;
                        start1 = i;
                        start2 = j;
                    }
                }
            }
            return longest;
        }
    }

    private static int DPLCS(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == 0 || len2 == 0) return 0;
        // table records longest ends at i and j
        int[][] table = new int[len1][len2];
        int start1 = -1;
        int start2 = -1;
        int longest = 0;
        int comparison = 0;
        for (int j = 0; j < len2; j++){
            comparison ++;
            table[0][j] = s1.charAt(0) == s2.charAt(j) ? 1 : 0;
        }

        for (int i = 1; i < len1; i++){
            comparison ++;
            table[i][0] = s1.charAt(i) == s2.charAt(0) ? 1 : 0;
            for (int j = 1; j < len2; j++){
                comparison ++;
                if (s1.charAt(i) == s2.charAt(j)){
                    table[i][j] = table[i-1][j-1] + 1;
                }
                // if not equal, table[i][j] just leave as default value 0
            }
        }

        for (int i = 0; i< len1; i++){
            for (int j = 0; j < len2; j++){
                if (table[i][j] > longest){
                    longest = table[i][j];
                    start1 = i - longest + 1;
                    start2 = j - longest + 1;
                }
            }
        }
        return longest;
    }

    public static void main(String[] args){
        String s1 = "defghfakslfjask ";
        String s2 = "abcdefghfaskldfjajgds";
        System.out.println(DPLCS(s1,s2));
    }
}
