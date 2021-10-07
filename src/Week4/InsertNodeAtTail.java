package Week4;

public class InsertNodeAtTail {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;
        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode add = new SinglyLinkedListNode(data);
        SinglyLinkedListNode p = head;
        if(head == null) {
            head = add;
        } else {
            while(p.next != null) {
                p = p.next;
            }
            p.next = add;
        }
        return head;
    }
}
