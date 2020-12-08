import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

public class MyTree {

    private class Node {
        public int data;
        public Node left = null;
        public Node right = null;

    }

    private Node root; // the root of the whole tree

    // This is a recursive helper method, that also adds the first node if neccesary
    // otherwise it just starts the recursion
    public void add(int x) {
        root = add(x, root);
    }

    // Recursive call, that goes down the tree, until a blank spot is found.
    private Node add(int x, Node currentRoot) {

        if(currentRoot == null) {
            Node temp = new Node();
            temp.data = x;
            return temp;
        } else {
            if(currentRoot.data > x) {
                currentRoot.left = add(x, currentRoot.left);
                return currentRoot;
            } else if(currentRoot.data < x) {
                currentRoot.right = add(x, currentRoot.right);
                return currentRoot;
            } else {
                return currentRoot;
            }
        }



    }

    public String toString() {
        return printTree(root);
    }

    private String printTree(Node currentRoot) {

        if(currentRoot == null) {
            return "";
        } else {

            // This is preorder because print then left then right
            String x = "";
            x = x + currentRoot.data + " ";
            x = x + printTree(currentRoot.left);
            x = x + printTree(currentRoot.right);

            // In order
//            printTree(currentRoot.left);
//            System.out.print(currentRoot.data + " ");
//            printTree(currentRoot.right);

            // Post data
//            printTree(currentRoot.left);
//            printTree(currentRoot.right);
//            System.out.print(currentRoot.data + " ");

            return x;
        }

    }

    private boolean contains(Node currentRoot, int x) {
        if(currentRoot == null) return false;
        if(currentRoot.data == x) return true;
        else if( currentRoot.data < x) return contains(currentRoot.right, x);
        else if(currentRoot.data > x) return contains(currentRoot.left, x);

        return false;
    }

    public int getMin() {
        if(root == null) throw new IllegalArgumentException();
        return (getMin(root));
    }

    private int getMin(Node currentRoot) {
        if(currentRoot.left == null) return currentRoot.data;
        else
            return getMin(currentRoot.left);
    }

    public void remove(int value) {
        root = remove(value, root);
    }

    private Node remove(int value, Node currentRoot) {
        if(currentRoot == null) {
            // We went through the whole tree and never found it
            return null;
        } else if(root.data > value) {
            currentRoot.left = remove(value, currentRoot.left);
        } else if(root.data < value) {
            currentRoot.right = remove(value, currentRoot.right);
        } else {
            // found it
            // remove current root/value from tree
            if(currentRoot.right == null) {
                return currentRoot.left;
            } else if(currentRoot.left == null) {
                return currentRoot.right;
            } else {
                currentRoot.data = getMin(currentRoot.right);
                currentRoot.right = remove(value, currentRoot.right);
            }
        }
        return currentRoot;
    }

}


