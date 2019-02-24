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

    public ListNode findMiddle(ListNode head) {
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

    public ListNode mergeLists(ListNode head_1, ListNode head_2){
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

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode middle = findMiddle(head);
        ListNode secondHead = sortList(middle.next);
        middle.next = null;
        ListNode firstHead = sortList(head);
        ListNode sortedHead = mergeLists(firstHead, secondHead);
        return sortedHead;
    }
}