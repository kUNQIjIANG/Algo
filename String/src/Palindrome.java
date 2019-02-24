/**
 * Created by kunqi
 * ON 8/10/18 11:31 PM
 */

// 最长回文

public class Palindrome {

    // brute-force : O(n^3)
    // 从两端到中心
    static boolean isPalindrome(String s, int left, int right){
        while(left <= right){
            if (s.charAt(left) == s.charAt(right)){
                left ++;
                right --;
            }else{
                return false;
            }
        }
        return true;
    }

    static int maxPalindrome(String s){
        int longest = 0;
        for (int i = 0; i < s.length(); i++){
            for (int j = i+1; j < s.length(); j++){
                if (isPalindrome(s,i,j)){
                    longest = j-i+1 > longest ? j-i+1 : longest;
                }
            }
        }
        return longest;
    }

    // 中心扩展法
    // 从中心到两端
    static int longestCenter(String s, int mid){
        int left = mid - 1;
        int right = mid + 1;
        while(s.charAt(mid) == s.charAt(right)){
            right ++;
        }
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }
        return right - left - 1;
    }

    static int longestPalindrome(String s){
        int longest = 0;
        for (int i = 0; i < s.length(); i++){
            int temp = longestCenter(s,i);
            longest = temp > longest ? temp : longest;
        }
        return longest;
    }

    // Dynamic Programing : O(n^2)
    static int DpPalindrome(String s){
        int[][] dp = new int[100][100];
        return 1;
    }

}
