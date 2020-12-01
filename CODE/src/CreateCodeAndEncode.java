import java.io.*;
import java.util.*;

/**
 *  This class will take an input file and
 *  convert it to huffman code. It will produce
 *  a .code and a .huff file.
 *
 * @author Lucas D. Dahl
 * @version 11/24/20
 */
public class CreateCodeAndEncode {

    /**
     * THis is the main method.
     * @param args the arguments to pass in.
     */
    public static void main(String[] args) {

        // Properties
        List<Character> tempList;
        String file;
        Map<Character, Integer> tempMap;
        Map<Character, String> huffmanCode;
        PriorityQueue<Node> pq;

        // Call the methods to create the code.
        file = getFile(".txt"); // Get the file name.
        tempList = openFile(file); // Get the list from the file
        tempMap = makeMap(tempList); // Add each element in the list to a map.
        pq = makePQ(tempMap); // Create the priority queue
        pq = makePQToTree(pq); // Make the priority queue hold a tree.
        huffmanCode = generateHuffman(pq.peek()); // Get the code
        writeCodeFile(huffmanCode); // Write the code file.
        writeHuffFile(tempList, huffmanCode); // Write the huff file.

    }

    // This is the inner Node class
    private static class Node implements Comparable<Node> {

        // **************************** Fields *****************************
        /**
         * This is the letter of the node.
         */
        public Character character;

        /**
         * This is the frequency of the node
         */
        public Integer frequency;
        /**
         * this is the left node of teh current node
         */
        public Node leftNode;
        /**
         * This is the right node of the current node.
         */
        public Node rightNode;

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
            if(frequency > node.frequency || frequency.equals(node.frequency)) {
                return 1;
            } else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return "Character: " + character + " Frequency: " + frequency;
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
    } // End inner class

    public static Map<Character, Integer> makeMap(List<Character> theList) {

        Map<Character, Integer> theMap = new TreeMap<>();

        for(int i = 0; i < theList.size(); i++) {

            char c = theList.get(i);

            if(!theMap.containsKey(c)) {
                // the key doesn't exist
                theMap.put(c, 1);
            } else {

                // The key exists
                int temp = theMap.get(c);
                temp++;
                theMap.put(c, temp);
            }
        }
        return theMap;
    }

    // This method takes a Map and turns it into a priority queue
    private static PriorityQueue<Node> makePQ(Map<Character, Integer> theMap) {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(char c: theMap.keySet()) {

            Node e = new Node(c, theMap.get(c));
            pq.add(e);

        }
        return pq;
    }

    // This will turn the Priority queue into one that only holds a single Node.
    private static PriorityQueue<Node> makePQToTree(PriorityQueue<Node> pq) {

        while(pq.size() > 1) {

            // Temp nodes
            Node tempNodeOne = pq.remove(), tempNodeTwo = pq.remove(), newNode = new Node();

            // Set the frequency and left and right nodes
            // then and add it back
            newNode.frequency = (tempNodeOne.frequency + tempNodeTwo.frequency);
            newNode.leftNode = tempNodeOne;
            newNode.rightNode = tempNodeTwo;

            pq.add(newNode);

        }
        return pq;
    }

    // This method gets the file name
    private static String getFile(String fileFormat) {

        // Properties
        String file = "", format = "";
        Scanner keyboard = new Scanner(System.in);

        do {

            // Ask the user for the filename
            System.out.println("please enter a " + fileFormat + " file.");
            System.out.print("--> ");
            file = keyboard.nextLine();

            // Find the format of the file.
            if(!file.contains(".")) {
                format = "Must contain a file type.";
                System.out.println(format);
            } else {
                int dotIndex = file.indexOf(".");
                format = file.substring(dotIndex);
            }

            // Make sure the file is a ".txt".
            if(!format.equals(fileFormat)) {
                System.out.println("File must be a \".txt\"");
            }

        } while(!format.equals(fileFormat));

        return file;
    }

    // Get the file.
    private static List<Character> openFile(String file) {

        List<Character> tempList = new ArrayList<Character>();

        try(FileInputStream x = new FileInputStream(file)) {
            // Read the file.
            while(x.available() > 0) {

                char c = (char) x.read();
                tempList.add(c);
            }
        } catch (Exception e){
            // Let the user know there was an error making the file.
            System.out.println("There was an error, " + e);
            System.out.println("Closing the program.");
            System.exit(-1);
        }

        return tempList;
    }

    // Generate the huffman code
    private static Map<Character, String> generateHuffman(Node currentRoot) {

        // Properties
        Map<Character, String> charToString = new TreeMap<>();
        if(currentRoot == null) {
            return null;
        }
        getCode(currentRoot,charToString, "");

        return charToString;
    }

    // Create the actual code
    private static void getCode(Node currentRoot, Map<Character, String> theMap, String huffCode) {

        // Properties

        if(!currentRoot.isLeaf()) {

            getCode(currentRoot.leftNode,theMap, huffCode + "0");
            getCode(currentRoot.rightNode, theMap, huffCode + "1");

        } else {
            theMap.put(currentRoot.character, huffCode);
        }

    }

    // Write to a file.
    private static void writeCodeFile(Map<Character, String> theMap) {

        // Properties
        PrintStream outStream = null;
        String fileName = "";

        // Get the filename.
        fileName = getFile(".code");

        // Create a new file
        try {

            outStream = new PrintStream(fileName);

        } catch (Exception e) {

            // Let the user know there was an error making the file.
            System.out.println("There was an error, " + e);
            System.out.println("Closing the program.");
            System.exit(-1);

        }

        // Write to the file
        for(char c: theMap.keySet()) {

            // Get the ASCII of the character
            int ascii = (int) c;
            outStream.println(ascii);
            outStream.println(theMap.get(c));

        }

        // Close the file
        outStream.close();

    }

    private static void writeHuffFile(List<Character> theList, Map<Character, String> theMap) {

        // Properties
        PrintStream outStream = null;
        String fileName = "";

        fileName = getFile(".huff");

        // Create a new file
        try {

            outStream = new PrintStream(fileName);

        } catch (Exception e) {

            // Let the user know there was an error making the file.
            System.out.println("There was an error, " + e);
            System.out.println("Closing the program.");
            System.exit(-1);

        }

        // Write to the file
        for(char c: theList) {

            outStream.print(theMap.get(c));

        }

        // Close the file
        outStream.close();

    }
}
