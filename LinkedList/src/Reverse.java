/**
 * Created by kunqi
 * ON 8/16/18 12:04 PM
 */

public class Reverse {
    static Node reverse(Node root){
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
}
