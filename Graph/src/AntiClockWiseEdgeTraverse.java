import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by kunqi
 * ON Apr/05/2019 18:56
 */

//refer to : https://www.jianshu.com/p/09e986ebedc7

public class AntiClockWiseEdgeTraverse {

    static List<TreeNode> edgePath = new ArrayList<>();

    private static void addLeftEdge(TreeNode root){
        while(root != null){
            edgePath.add(root);
            root = root.left;
        }
    }

    private static void addLeafNode(TreeNode root){
        if (root == null) return;
        else{
            if(root.left == null && root.right == null){
                if (root != edgePath.get(edgePath.size()-1)){
                    edgePath.add(root);
                }
            }
            addLeafNode(root.left);
            addLeafNode(root.right);
        }
    }

    private static void addRightEdge(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while(root != null){
            stack.push(root);
            root = root.right;
        }
        while(!stack.isEmpty()){
            if(stack.peek() != edgePath.get(edgePath.size()-1)){
                edgePath.add(stack.pop());
            }else stack.pop();
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(5);
        TreeNode rightRight = new TreeNode(6);
        root.left = left;
        root.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        right.right = rightRight;
        addLeftEdge(root);
        addLeafNode(root);
        addRightEdge(root.right);
        for(TreeNode node : edgePath){
            System.out.println(node.val);
        }
    }
}
