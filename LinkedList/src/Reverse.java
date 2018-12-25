/**
 * Created by kunqi
 * ON 8/16/18 12:04 PM
 */

//refer to https://blog.csdn.net/wodewutai17quiet/article/details/80092798

public class Reverse {

    private static Node reverse(Node root){

        Node pre = null;
        Node cur = root;
        Node next = null;

        while(cur != null){
            next= cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

//   解析：
//    1)将 A->B->C->D 反转的操作可以分为：
//          1>将 C->D 反转 ==> A->B->C  D->C->null
//          2>将 B->C 反转 ==> A->B     D->C->B->null
//          3>将 A->B 反转 ==>          D->C->B->A->null
//
//    2)将 A->B 反转的操作：
//          1>将B的后继节点指向A，      即 B.next = A    即 A.next.next = A
//          2>将A的后继节点设为null，   即 A.next = null


    private static Node recursionReverse(Node root){
        if ( root == null) return root;
        if ( root.next == null) return root;

        Node newHead = recursionReverse(root.next);

        root.next.next = root;
        root.next = null;

        return newHead;
    }

    // reverse bidirection linked list
    private static Node reverseBidirection(Node root){
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

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        Node head = Operation.creatLinkedList(array);
        //Node reverHead = reverse(head);
        Node reverHead = recursionReverse(head);
        Operation.printLinkedList(reverHead);
        Operation.printLinkedList(head);
    }
}
