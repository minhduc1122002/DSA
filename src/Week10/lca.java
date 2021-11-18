package Week10;

public class lca {
    private class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {this.data = data;}
    }

    public Node lca(Node root, int v1, int v2) {
        if ((v1 <= root.data && v2 >= root.data) ||
                (v1 >= root.data && v2 <= root.data)) {
            return root;
        } else if (v1 < root.data && v2 < root.data) {
            return lca(root.left, v1, v2);
        } else if (v1 > root.data && v2 > root.data) {
            return lca(root.right, v1, v2);
        }
        return null;
    }
}
