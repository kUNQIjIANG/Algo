import java.util.ArrayList;

/**
 * Created by kunqi
 * ON Mar/22/2019 21:20
 */

// 剑指offer-25
public class BSTPathSum {

    static void pathSum(TreeNode root, int sum){
        ArrayList<Integer> path = new ArrayList<Integer>();
        preOrderTrack(root,sum,path);
    }

    static void preOrderTrack(TreeNode root, int sum, ArrayList<Integer> path){
        if (root != null){
            path.add(root.val);
            if (root.left == null && root.right == null){
                if (sum(path) == sum) System.out.println(path);
            }else{
                if (root.left != null) preOrderTrack(root.left,sum,path);
                if (root.right != null) preOrderTrack(root.right,sum,path);
            }
            path.remove(path.size()-1);
        }
    }

    static int sum(ArrayList<Integer> list){
        int res = 0;
        for (int i : list) res+= i;
        return res;
    }

    public static void main(String[] args) {
        TreeNode r = new TreeNode(10);
        r.left = new TreeNode(5);
        r.left.left = new TreeNode(4);
        r.left.right = new TreeNode(7);
        r.right = new TreeNode(12);
        pathSum(r,22);
    }
}
