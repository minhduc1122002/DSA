package Week10;

public class InsertBT {
    private class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {this.data = data;}
    }

    public Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node temp;
            if (root.data > data) {
                temp = insert(root.left, data);
                root.left = temp;
            } else {
                temp = insert(root.right, data);
                root.right = temp;
            }
            return root;
        }
    }
}
