package Week10;

import java.util.ArrayList;
import java.util.List;

public class CheckBST {
    private class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {this.data = data;}
    }

    public void inOrder(Node root, List<Integer> nodes) {
        if (root.left != null) {
            inOrder(root.left, nodes);
        }
        nodes.add(root.data);
        if (root.right != null) {
            inOrder(root.right, nodes);
        }
    }

    public boolean checkBST(Node root) {
        List<Integer> nodes = new ArrayList<>();
        inOrder(root, nodes);
        for (int i = 0; i < nodes.size() - 1; i++) {
            if (nodes.get(i) >= nodes.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
