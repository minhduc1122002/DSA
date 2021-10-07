package Week4;

public class PrintInReverse {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;
        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }
    static void reversePrint(SinglyLinkedListNode llist) {
        // Write your code here
        if (llist == null) {
            return;
        }
        else {
            reversePrint(llist.next);
            System.out.println(llist.data);
        }
    }
}
