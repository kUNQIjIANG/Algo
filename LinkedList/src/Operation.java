/**
 * Created by kunqi
 * ON 7/13/18 7:19 PM
 */

// remove all val node and return head

public class Operation {

     static Node creatLinkedList(int[] array){

        int length = array.length;
        if (length == 0) return null;
        Node cur = new Node(array[0]);
        Node head = cur;
        for (int i = 1; i < length; i++){
            cur.next = new Node(array[i]);
            cur = cur.next;
        }
        return head;
    }

    static void printLinkedList(Node head){
        while (head != null){
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }

    Node removeAllEle(Node head, int val){
        Node fakeHead = new Node(0);
        fakeHead.next = head;
        Node pivot = fakeHead;

        while(pivot != null){
            if (pivot.next != null && pivot.next.val == val){
                pivot.next = pivot.next.next;
            } else{
                pivot = pivot.next;
            }
        }
        return fakeHead.next;
    }
}
