import java.util.ArrayList;

/**
 * Created by kunqi
 * ON 7/13/18 9:01 PM
 */

public class OrderListIntersect {

    // O(m+n)
    private static ArrayList intersect(int[] t, int[] m){
        int i = 0, j = 0;
        ArrayList<Integer> intersect = new ArrayList<Integer>();
        while(i<t.length && j < m.length){
            if (t[i] < m[j]) i++;
            else if (t[i] > m[j]) j++;
            else{
                intersect.add(t[i]);
                j++;
                i++;
            }
        }
        return intersect;
    }

    public static void main(String[] args){
        int[] a = { 2, 3, 4, 4, 4, 4, 7, 8, 8, 8, 8, 9, 100, 130, 150, 160 };
        int[] b = { 4, 6, 7, 7, 7, 7, 8, 8, 9, 10, 100, 130, 130, 140, 150 };
        ArrayList res = intersect(a,b);
        System.out.println(res);
    }
}
