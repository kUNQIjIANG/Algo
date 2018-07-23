/**
 * Created by kunqi
 * ON 7/23/18 12:31 PM
 */

import java.lang.Math;

public class SameNode {

    private int lenght(Node head){
        int len = 0;
        while(head != null){
            head = head.next;
            len ++;
        }
        return len;
    }

    // no ring, return first public node, else null;
    private Node publicNode(Node head1, Node head2){
        int len1 = lenght(head1);
        int len2 = lenght(head2);
        if (len1 < len2){
            Node temp = head1;
            head1 = head2;
            head2 = temp;
        }

        for (int i = 0; i < Math.abs(len1-len2); i++){
            head1 = head1.next;
        }

        while(head1 != null && head1 != head2){
            head1 = head1.next;
            head2 = head2.next;
        }

        return head1;
    }

    private boolean isRing(Node head){
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        return fast != null && fast.next != null; // (why fast.next != null required)
    }

    private Node ringEntrance(Node head){
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        // a : from head to ring entrance
        // x : from ring entrance to first meet
        // r : ring length
        // a = (r-x) + n*r
        slow = head;
        while(fast != null && fast != slow){
            fast = fast.next;
        }
        return fast;
    }

}
