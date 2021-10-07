package Week4;

public class MergeLinkedList {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;
        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
    static SinglyLinkedListNode insertTail(SinglyLinkedListNode head, SinglyLinkedListNode add) {
        SinglyLinkedListNode temp = head;
        if (head == null) {
            return add;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = add;
        return head;
    }
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode llist = new SinglyLinkedListNode(0);
        if (head1.data < head2.data) {
            llist = head1;
            head1 = head1.next;
        } else {
            llist = head2;
            head2 = head2.next;
        }
        SinglyLinkedListNode temp = llist;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if (head1 == null) {
            temp.next = head2;
        }
        if (head2 == null) {
            temp.next = head1;
        }
        return llist;
    }
}
