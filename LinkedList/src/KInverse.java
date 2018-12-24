import java.util.Stack;

/**
 * Created by kunqi
 * ON 12/23/18 4:51 PM
 */

// refer to https://blog.csdn.net/freeelinux/article/details/53613348

public class KInverse {

    private Node kInverse(Node head, int k){

        if( head != null && head.next != null && k > 1){

            Node pre = null;
            Node cur = head;
            Node start = null;
            Node next = null;
            int count = 1;

            while(cur != null){

                next = cur.next;

                if (count == k){
                    start = pre == null ? head : pre.next;
                    head = pre == null ? cur : head;
                    reverse(pre,start,cur,next);
                    pre = start;
                    count = 0;
                }
                count ++;
                cur = next;
            }
        }
        return head;

    }

    private void reverse(Node left, Node start, Node end, Node right){
        Node pre = start;
        Node cur = start.next;
        Node next = cur.next;

        while(cur != right){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        if (left != null){
            left.next = end;
        }
        start.next = right;
    }

    // 直接赋值就好
    private Node stackKInverse(Node head, int k){
        if ( head != null && head.next != null && k > 1){
            Node act = head;
            Node wait = head;
            int count = 1;
            Stack<Integer> stack = new Stack<>();
            while( act != null ){
                stack.push(act.val);
                if( count == k ){
                    while ( !stack.isEmpty() ){
                        wait.val = stack.pop();
                        wait = wait.next;
                    }
                    count = 0;
                }
                count ++;
                act = act.next;
            }

        }
        return head;
    }
}
