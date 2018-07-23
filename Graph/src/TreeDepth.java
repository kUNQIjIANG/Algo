/**
 * Created by kunqi
 * ON 7/19/18 6:18 PM
 */

import java.util.Queue;
import java.util.LinkedList;

public class TreeDepth {
    // non-recursion version
    private int treeDepth(TreeNode root){
        if (root == null) return 0;
        else{
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            // number of nodes of current depth
            int depth = 0 , count = 0 , nextCount = 0;
            // number of nodes of next depth

            while(!queue.isEmpty()){
                TreeNode top = queue.remove();
                count ++;
                if (top.left != null) queue.add(top.left);
                if (top.right != null) queue.add(top.right);
                if (count == nextCount){
                    // all nodes of current depth traversed
                    nextCount = queue.size();
                    count = 0;
                    depth ++;
                }
            }
            return depth;
        }
    }
}
