
public class StringMatch {
    private static int naiveMatch(String txt, String patt){
        int n = txt.length();
        int m = patt.length();
        int i = 0;
        int j = 0;
        while (i < n && j < m){
            if (txt.charAt(i) == patt.charAt(j)){
                i ++;
                j ++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (m == j){
            return i - j;
        } else {
            return -1;
        }
    }

    private static int naiveMatch2(String txt, String patt){
        int n = txt.length();
        int m = patt.length();
        for (int i = 0; i < n; i++){
            int j = 0;
            while ( j < m && txt.charAt(i+j) == patt.charAt(j)){
                j++;
            }
            if (j == m) return i;
        }
        return -1;
    }

    private static int naiveMatch3(String txt, String patt){
        int n = txt.length();
        int m = patt.length();
        int j;
        for (int i = 0; i < n; i++){
            for (j = 0; j < m; j++){
                if (txt.charAt(i+j) != patt.charAt(j)){
                    break;
                }
            }
            if (j == m) return i;
        }
        return -1;
    }

    public static void main(String[] args){
        String txt = "abcdefavg";
        String patt = "efa";
        int res = StringMatch.naiveMatch(txt,patt);
        System.out.println(res);
    }

}
