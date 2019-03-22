/**
 * Created by kunqi
 * ON 3/22/19 5:44 PM
 */

// 剑指offer-24
// https://blog.csdn.net/Quantum_Dog/article/details/87980894

public class VerifyPostorderOfBST {

    public static boolean verifyPostorder(int[] seq, int start, int end){
        if (seq == null) return false;
        if (start > end) return false;
        int left = start;
        int root = seq[end];

        while(seq[left] < root) left++;

        int right = left;
        for (;right < end; right++){
            if (seq[right] < root) return false;
        }

        boolean leftTree = true;
        if (left > start) leftTree = verifyPostorder(seq,start,left-1);
        boolean rightTree = true;
        if (left < end) rightTree = verifyPostorder(seq,left,end-1);

        return leftTree && rightTree;
    }

    public static void main(String[] args) {
        int[] seq = {7,4,6,5};
        //int[] seq = {5,7,6,9,11,10,8};
        //int[] seq = {11,10,8};
        //int[] seq = {6,8,10};
        System.out.println(verifyPostorder(seq,0,seq.length-1));
    }
}
