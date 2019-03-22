/**
 * Created by kunqi
 * ON Mar/22/2019 23:46
 */

// 剑指offer-27
// left point to small value, right to big
// be careful java is pass by value !!!
// pointer refer to the same after involved in call

public class BSTtoLinkedList {
    static TreeNode convert(TreeNode root){
        TreeNode last = null;
        last = convert(root,last);
        while(last != null && last.left != null) last = last.left;
        return last;
    }

    static TreeNode convert(TreeNode root, TreeNode last){
        if (root == null) return null;
        if (root.left != null) last = convert(root.left,last);
        root.left = last;
        if (last != null) last.right = root;
        last = root;
        if (root.right != null) last = convert(root.right,last);
        return last;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        TreeNode head = convert(root);
        while(head != null){
            System.out.println(head.val);
            head = head.right;
        }
    }

}
