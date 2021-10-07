package Week4;

public class InsertNodeAtHead {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;
        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode add = new SinglyLinkedListNode(data);
        add.next = llist;
        llist = add;
        return llist;
    }
}
