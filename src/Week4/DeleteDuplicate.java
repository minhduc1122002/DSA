package Week4;

public class DeleteDuplicate {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;
        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
    public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {
        // Write your code here
        SinglyLinkedListNode temp = llist;
        while (temp.next != null && temp != null) {
            if (temp.next.data == temp.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return llist;
    }
}
