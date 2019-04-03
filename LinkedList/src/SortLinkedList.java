/**
 *
 *
 * 题目描述：
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 *
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class SortLinkedList {

    // merge sort
    static ListNode findMiddle(ListNode head) {
        if ( head == null) return head;
        // NOTE : fast can not be head!!!!!!!!
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    static ListNode mergeLists(ListNode head_1, ListNode head_2){
        if (head_1 == null) return head_2;
        if (head_2 == null) return head_1;

        // Note : use dummy to avoid this
        /**
         if (head_1.val < head_2.val) {
            realHead = new ListNode(head_1.val);
            head_1 = head_1.next;
         }
         else{
            realHead = new ListNode(head_2.val);
            head_2 = head_2.next;
         }
         */
        ListNode dummy = new ListNode(0);
        ListNode cursor = dummy;
        while(head_1 != null && head_2 != null){
            if (head_1.val < head_2.val){
                cursor.next = head_1;
                head_1 = head_1.next;
            }else{
                cursor.next = head_2;
                head_2 = head_2.next;
            }
            cursor = cursor.next;
        }

        if (head_1 == null) cursor.next = head_2;
        else cursor.next = head_1;

        return dummy.next;
    }

    static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middle = findMiddle(head);
        ListNode secondHead = mergeSort(middle.next);
        middle.next = null;
        ListNode firstHead = mergeSort(head);
        ListNode sortedHead = mergeLists(firstHead, secondHead);
        return sortedHead;
    }

    static ListNode partition(ListNode head, ListNode end){
        if (head == null) return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        int pivot = head.val;
        int tmp;
        while(p2 != end){
            if(p2.val < pivot){
                p1 = p1.next;
                //swap
                tmp = p1.val;
                p1.val = p2.val;
                p2.val = tmp;
            }
            p2 = p2.next;
        }
        if(p1 != head){
            tmp = p1.val;
            p1.val = pivot;
            head.val = tmp;
        }
        return p1;
    }

    static void quickSort(ListNode head, ListNode end){
        if(head != end) {
            ListNode p = partition(head, end);
            quickSort(head, p);
            quickSort(p.next, end);
        }
    }

    static void printList(ListNode head){
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(6);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        //quickSort(n1,null);
        printList(mergeSort(n1));
    }


}