/**
 * Created by kunqi
 * ON 12/21/18 11:14 PM
 */

public class DivideList {

    // divide list into two part by an value

    private static Node divide(Node head, int val){

        if (head == null || head.next == null) return null;

        Node head1 = null, tail1 = null;  // smaller part
        Node head2 = null, tail2 = null; // larger part

        Node next = head;

        while(head != null){

            next = head.next;
            head.next = null; // 切断

            if( head.val < val){
                if (head1 == null){
                    head1 = new Node(val);
                    tail1 = head1;
                }
                else{
                    tail1.next = new Node(val);
                    tail1 = tail1.next;
                }
            }

            else{
                if (head2 == null){
                    head2 = new Node(val);
                    tail2 = head2;
                }
                else{
                    tail2.next = new Node(val);
                    tail2 = tail2.next;
                }
            }
        }

        if (head1 != null){
            tail1.next = head2;
            return head1;
        }
        else{
            return head2;
        }
    }
}
