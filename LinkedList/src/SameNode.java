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

    // assume no ring, return first public node, else null;
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
        return fast != null && fast.next != null;
        // in case head is last node, can not use
        // slow == fast
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

    // find first public node in two possible ring linkedList
    private Node ringPublicNode(Node head1, Node head2){
        Node entran1 = ringEntrance(head1);
        Node entran2 = ringEntrance(head2);
        if (entran1 == null && entran2 == null){
            return publicNode(head1, head2);
        }else if(entran1 == null || entran2 == null){
            return null; // no public node
        }else{
            if (entran1 == entran2) {
                // first common node is in the branch
                Node temp1 = entran1.next;
                Node temp2 = entran2.next;
                entran1.next = null;
                entran2.next = null;
                Node firstPublicNode = publicNode(head1,head2);
                entran1.next = temp1;
                entran2.next = temp2;
                return firstPublicNode;
            }else{
                // maybe different ring, check if a ring
                // contain other entrance node
                Node pivot = entran1.next;
                while(pivot != entran1 && pivot != entran2){
                    pivot = pivot.next;
                }
                return pivot == entran2 ? pivot : null;
            }
        }
    }

}
