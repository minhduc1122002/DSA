package Week10;

public class HeightBT {
    private class Node {
        int data;
        Node left;
        Node right;
    }

    public int height(Node root) {
        // Write your code here.
        if (root.left == null && root.right == null) {
            return 0;
        } else if (root.left != null && root.right == null) {
            return 1 + height(root.left);
        } else if (root.left == null && root.right != null) {
            return 1 + height(root.right);
        } else {
            return 1 + Math.max(height(root.left), height(root.right));
        }
    }
}
