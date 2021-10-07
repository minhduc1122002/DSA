package Week4;

public class GetNodeValue {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;
        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        // Write your code here
        SinglyLinkedListNode temp = llist;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        while (llist != null && count - positionFromTail - 1 > 0) {
            llist = llist.next;
            positionFromTail++;
        }
        return llist.data;
    }
}
