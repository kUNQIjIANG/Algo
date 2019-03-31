import java.util.Stack;

/**
 * Created by kunqi
 * ON Mar/31/2019 10:41
 */
public class BSTTraverse {
    private static void preorderNonRecursion(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cursor = root;
        while(!stack.isEmpty() || cursor != null){
            while(cursor != null) {
                System.out.println(cursor.val);
                stack.push(cursor);
                cursor = cursor.left;
            }

            if(!stack.isEmpty()){
                cursor = stack.pop();
                cursor = cursor.right;
            }
        }
    }

    private static void preorder(TreeNode root){
        if(root != null){
            System.out.println(root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }

    private static void inorderNonRecursion(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cursor = root;
        while(!stack.isEmpty() || cursor != null){
            while(cursor != null){
                stack.push(cursor);
                cursor = cursor.left;
            }
            if (!stack.isEmpty()){
                cursor = stack.pop();
                System.out.println(cursor.val);
                cursor = cursor.right;
            }
        }
    }

    private static void inorder(TreeNode root){
        if (root != null){
            inorder(root.left);
            System.out.println(root.val);
            inorder(root.right);
        }
    }

    private static void postorderNonRecursion(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> s = new Stack<>();
        TreeNode cursor = root;
        while(!stack.isEmpty() || cursor != null){
            while(cursor != null){
                stack.push(cursor);
                s.push(0);
                cursor = cursor.left; //先左
            }
            while (!stack.isEmpty() && s.peek() == 1){
                System.out.println(stack.pop().val); //再中间
                s.pop();
            }
            if (!stack.isEmpty()){
                s.pop();
                s.push(1);
                cursor = stack.peek();
                cursor = cursor.right; //后右
            }
        }
    }

    private static void postorder(TreeNode root){
        if (root != null){
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.val);
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        postorderNonRecursion(root);
        postorder(root);
    }
}
