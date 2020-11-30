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

        List<Character> tempList = new ArrayList<Character>();
        String file;
        Map<Character, Integer> tempMap = new TreeMap<>();
        Map<Character, String> huffmanCode;
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // Get the file name.
        file = getFile(".txt");

        // Get teh list from the file
        tempList = openFile(file);


        // Add each element in the list to a map.
        for(int i = 0; i < tempList.size(); i++) {

            char c = tempList.get(i);

            if(!tempMap.containsKey(c)) {
                // the key doesn't exist
                tempMap.put(c, 1);
            } else {

                // The key exists
                int temp = tempMap.get(c);
                temp++;
                tempMap.put(c, temp);

            }

        }

        // Create the priority queue
        for(char c: tempMap.keySet()) {

            Node e = new Node(c, tempMap.get(c));
            pq.add(e);

        }


        // Make the priority queue hold a tree.
        while(pq.size() > 1) {

            // Properties
            Node tempNodeOne = pq.remove(), tempNodeTwo = pq.remove(), newNode = new Node();

            // Set the frequency and left and right nodes
            // then and add it back
            newNode.frequency = (tempNodeOne.frequency + tempNodeTwo.frequency);
            newNode.leftNode = tempNodeOne;
            newNode.rightNode = tempNodeTwo;

            pq.add(newNode);

        }

        // Get the code
        huffmanCode = generateHuffman(pq.peek());

        // Write the code file.
        writeCodeFile(huffmanCode);

        // Write the huff file.
        writeHuffFile(tempList, huffmanCode);

    } //=================================== End main

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
