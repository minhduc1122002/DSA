package Week4;

public class DeleteANode {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;
        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        // Write your code here
        if (position == 0) {
            llist = llist.next;
            return llist;
        }
        SinglyLinkedListNode temp = llist;
        int count = 0;
        while (temp.next != null && position > count + 1) {
            count++;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return llist;
    }
}
