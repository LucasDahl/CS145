import java.io.FileInputStream;
import java.util.*;

/**
 *  This class
 *
 * @author Lucas D. Dahl
 * @version 11/24/20
 */
public class CreateCodeAndEncode {

    public static void main(String[] args) {

        // Properties
        Scanner keyboard = new Scanner(System.in);
        List<Character> tempList = new ArrayList<Character>();
        String format = "", file;
        Map<Character, Integer> tempMap = new TreeMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();

        do {

            // Ask the user for the filename
            System.out.println("please enter a file to encode");
            System.out.print("--> ");
            file = keyboard.nextLine();

            // Find the format of the file.
            int dotIndex = file.indexOf(".");
            format = file.substring(dotIndex);

            // Make sure the file is a ".txt".
            if(!format.equals(".txt")) {
                System.out.println("File must be a \".txt\"");
            }

        } while(!format.equals(".txt"));


        //TODO ASK
        // Create the file scanner
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

        


    }


}
