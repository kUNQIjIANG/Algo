/**
 * Created by kunqi
 * ON Mar/29/2019 21:46
 */
public class LowestCommonAncestor {
    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) return null;
        else if (root == p || root == q) return root;
        else{
            TreeNode left = lowestCommonAncestor(root.left,p,q);
            TreeNode right = lowestCommonAncestor(root.right,p,q);
            // p,q分别在左右两边
            if (left != null && right != null) return root;
            else if (left != null) return left; // p,q同在左边
            else if (right != null) return right; // p,q同在右边
            else return null; // p,q两边都不存在
        }
    }
}
