/**
 * Created by kunqi
 * ON 11/20/18 7:54 PM
 */

// 用 inorder 和 preorder 还原树
// 将 inorder 一分为二
public class BuildTree {
    private static int index = -1;
    public static TreeNode recoverTree(int[] preorder, int[] inorder, int left, int right){
        index ++;
        if (left > right || right > inorder.length) return null;
        TreeNode root = new TreeNode(preorder[index]);
        int j = left;
        for (int i = left; i <= right; i++){
            if (inorder[i] == preorder[index]) break;
            j ++;
        }
        if (j <= right){
            root.left = recoverTree(preorder, inorder, left, j-1);
            index --;
            root.right = recoverTree(preorder, inorder, j+1, right);
        }
        return root;
    }

    public static void main(String[] args){
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        int len = preorder.length;
        TreeNode root = BuildTree.recoverTree(preorder,inorder,0,len-1);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }
}
