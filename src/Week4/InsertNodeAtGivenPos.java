package Week4;

public class InsertNodeAtGivenPos {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;
        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {
        // Write your code here
        int count = 0;
        SinglyLinkedListNode temp = llist;
        while (temp.next != null && position > count + 1) {
            count ++;
            temp = temp.next;
        }
        SinglyLinkedListNode add = new SinglyLinkedListNode(data);
        add.next = temp.next;
        temp.next = add;
        return llist;
    }
}
