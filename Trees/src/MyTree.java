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

        // Base case
//        if(root == null) { // if there is no tree
//            root = new Node();
//            root.data = x;
//            root.left = null;
//            root.right = null; // Not really needed since they are already null
//            return;
//        } else {
//
//            add(x, root); // This is where we start the recursion
//
//
//       }
        root = add(x, root);
    }

    // Recursive call, that goes down the tree, until a blank spot is found.
    public Node add(int x, Node currentRoot) {

//        if(currentRoot.left == null) { // If the left side is clear, add here.
//            currentRoot.left = new Node();
//            currentRoot.left.data = x;
//            currentRoot.left.left = null;
//            currentRoot.left.right = null;
//            return;
//        } else if(currentRoot.right == null) {
//            currentRoot.right = new Node();
//            currentRoot.right.data = x;
//            currentRoot.right.left = null;
//            currentRoot.right.right = null;
//            return;
//        } else {
//
//            // If both left and right are empty
//            // pick randomly... and go recursive
//            // go left or right
//            Random rand = new Random();
//            int coin = rand.nextInt(2);
//            if(coin == 0) {
//                add(x, currentRoot.left);
//            } else {
//                add(x, currentRoot.right);
//            }
//
//        }

        if(currentRoot == null) {
            Node temp = new Node();
            temp.data = x;
            return temp;
        } else {
            if(currentRoot.data < x) {
                currentRoot.left = add(x, currentRoot.left);
                return currentRoot;
            } else if(currentRoot.data > x) {
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
            x = x +printTree(currentRoot.left);
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

}
