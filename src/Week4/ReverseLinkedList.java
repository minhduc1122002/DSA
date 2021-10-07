package Week4;

public class ReverseLinkedList {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;
        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
    public static SinglyLinkedListNode insertTail(SinglyLinkedListNode head, SinglyLinkedListNode add) {
        SinglyLinkedListNode current = head;
        if (head == null) {
            return add;
        }
        while (current.next != null) {
            current = current.next;
        }
        current.next = add;
        return head;
    }
    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        // Write your code here
        if (llist.next == null) {
            return llist;
        }
        else {
            SinglyLinkedListNode temp = reverse(llist.next);
            llist.next = null;
            temp = insertTail(temp, llist);
            return temp;
        }
    }
}
