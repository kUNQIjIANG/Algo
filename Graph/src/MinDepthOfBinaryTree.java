
/**
题目描述
        Given a binary tree, find its minimum depth.
        The minimum depth is the number of nodes along
        the shortest path from the root node down to
        the nearest leaf node.

 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.Queue;
import java.util.LinkedList;
public class MinDepthOfBinaryTree {

    public int run1(TreeNode root) {
        if ( root == null) {
            return 0;
        }
        else if ( root.left == null) {
            return run1(root.right) + 1;
        }
        else if ( root.right == null) {
            return run1(root.left) + 1;
        }
        else {
            int leftDepth = run1(root.left) + 1;
            int rightDepth = run1(root.right) + 1;
            return leftDepth < rightDepth ? leftDepth : rightDepth;
        }
    }

    public int run2(TreeNode root){
        if ( root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int depth = 1;
        // num of nodes in current level
        int count = 1;
        // num of nodes in next level
        int nextCount = 0;
        int c = 0;
        TreeNode cur;
        while(!queue.isEmpty()){
            cur = queue.remove();
            c ++;

            if (cur.left == null && cur.right == null){
                return depth;
            } else{
                if (cur.left != null){
                    queue.add(cur.left);
                    nextCount ++;
                }
                if (cur.right != null){
                    queue.add(cur.right);
                    nextCount ++;
                }
            }

            if ( c == count){
                depth ++;
                count = nextCount;
                nextCount = 0;
                c = 0;
            }
        }
        return depth;
    }


    public int run3(TreeNode root){
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()){
            // 拿到此level的个数
            int curSize = queue.size();
            depth ++;
            // 避免了每个levle node 计数
            for (int i = 0; i < curSize; i++){
                TreeNode cur = queue.remove();
                // 先检查，再放入
                if (cur.left == null && cur.right == null) return depth;
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }
        }
        return depth;
    }

    // a wrong way
    public int wrong(TreeNode root){
        if ( root != null) return 0;
        else{
            int leftDepth = wrong(root.left) + 1;
            int rightDepth = wrong(root.right) + 1;
            return leftDepth < rightDepth ? leftDepth : rightDepth;
        }
    }
}