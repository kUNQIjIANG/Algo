import java.util.Stack;

/**
 * Created by kunqi
 * ON 12/23/18 4:51 PM
 */

// refer to https://blog.csdn.net/freeelinux/article/details/53613348

public class KInverse {

    private static Node kInverse(Node head, int k){

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

    private static void reverse(Node left, Node start, Node end, Node right){
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
    private static Node stackKInverse(Node head, int k){
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

    // leetcode25 :
    private ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = dummy, next = dummy;
        int count = 0;
        while(cur.next != null){
            cur = cur.next;
            count++;
        }
        while(count >= k){
            cur = pre.next;
            next = cur.next;
            for(int i = 1; i < k; i++){
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
                next = cur.next;
            }
            pre = cur;
            count -= k;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        Node head = Operation.creatLinkedList(array);
        Operation.printLinkedList(head);
        System.out.println("K Inverse");
        Node reverHead = kInverse(head,3);
        Operation.printLinkedList(reverHead);
        Operation.printLinkedList(head);
        Node stackReverHead = stackKInverse(head,3);
        Operation.printLinkedList(stackReverHead);
    }
}
