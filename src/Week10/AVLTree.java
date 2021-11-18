package Week10;

public class AVLTree {
    private class Node {
        int val;
        int ht;
        Node left;
        Node right;
    }

    public Node insert(Node root, int val) {
        if (root == null) {
            root = new Node();
            root.val = val;
            root.ht = setHeight(root);
            return root;
        } else {
            if(val <= root.val) {
                root.left = insert(root.left, val);
            }
            else  {
                root.right = insert(root.right, val);
            }
            int balance = height(root.left) - height(root.right);
            if (balance > 1) {
                if (height(root.left.left) - height(root.left.right) >= 0) {
                    root = rightRotation(root);
                } else {
                    root.left = leftRotation(root.left);
                    root = rightRotation(root);
                }
            } else if (balance < -1) {
                if (height(root.right.left) - height(root.right.right) >= 0) {
                    root.right = rightRotation(root.right);
                    root = leftRotation(root);
                } else {
                    root = leftRotation(root);
                }
            } else {
                root.ht = setHeight(root);
            }
            return root;
        }
    }

    private Node rightRotation(Node root) {
        Node newNode = root.left;
        root.left = newNode.right;
        newNode.right = root;
        root.ht = setHeight(root);
        newNode.ht = setHeight(newNode);
        return newNode;
    }

    private Node leftRotation(Node root) {
        Node newNode = root.right;
        root.right = newNode.left;
        newNode.left = root;
        root.ht = setHeight(root);
        newNode.ht = setHeight(newNode);
        return newNode;
    }

    public int height(Node root) {
        if(root == null)
            return -1;
        else
            return root.ht;
    }

    private int setHeight(Node root) {
        if(root == null) {
            return -1;
        }
        else {
            return 1 + Math.max(height(root.left), height(root.right));
        }
    }

}
