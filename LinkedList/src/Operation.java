/**
 * Created by kunqi
 * ON 7/13/18 7:19 PM
 */

// remove all val node and return head
public class Operation {
    private Node removeAllEle(Node head, int val){
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
