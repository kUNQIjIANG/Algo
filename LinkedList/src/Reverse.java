/**
 * Created by kunqi
 * ON 8/16/18 12:04 PM
 */

//refer to https://blog.csdn.net/wodewutai17quiet/article/details/80092798

public class Reverse {

    private Node reverse(Node root){

        Node pre = null;
        Node cur = root;
        Node next = null;
        while(cur.next != null){
            next= cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur.next = pre;
        return cur;
    }

    // recursion version
    private Node recursionReverse(Node root){
        if ( root == null) return root;
        if ( root.next == null) return root;

        Node newHead = recursionReverse(root.next);

        root.next.next = root;
        root.next = root;

        return newHead;
    }

    // reverse bidirection linked list
    private Node reverseBidirection(Node root){
        if ( root == null) return root;

        Node next = null;
        Node newHead = null;

        while(root != null){
            next = root.next;
            root.next = root.prev;
            root.prev = next;

            if (next == null){
                newHead = root;
            }
            root = root.next;
        }

        return newHead;
    }
}
