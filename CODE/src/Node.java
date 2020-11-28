/**
 *  This class
 *
 * @author Lucas D. Dahl
 * @version 11/24/20
 */
public class Node implements Comparable<Node> {

    // **************************** Fields *****************************
    private Character character;
    private Integer frequency;
    private Node leftNode;
    private Node rightNode;

    // ************************** Constructors *************************

    /**
     * This constructor sets both the character and
     * the frequency.
     *
     * @param letter letter character.
     * @param freq the frequency.
     */
    public Node(char letter, int freq) {
        character = letter;
        frequency = freq;
    }

    /**
     * This is the default constructor.
     */
    public Node() {
        character = null;
        frequency = null;
    }

    // **************************** Methods ****************************

    /**
     * This method will return 1 if the node is greater
     * than the compared node, and -1 if the passed in
     * node is greater.
     *
     * @param node is the node to compare against.
     * @return the int returned determines which letter is better.
     */
    public int compareTo(Node node) {
        if(frequency > node.frequency || frequency == node.frequency) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return "Character: " + character + "Frequency: " + frequency;
    }

    /**
     * This method will determine if
     * the current node is a leaf or
     * not.
     *
     * @return returns true if the node is a leaf.
     */
    public Boolean isLeaf() {
        return leftNode == null && rightNode == null;
    }
}
