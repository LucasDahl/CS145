import java.util.*;
import java.io.File;

/**
 * THis program will count the number of occurrences from each word in a text file to determine
 * how many of each there are.
 *
 * @author Lucas D. Dahl
 * @version 10/9/20
 */
public class Occurrences {

    /**
     * THis is the main method that runs the program.
     * @param args this is the arguments.
     */
    public static void main(String[] args) {

        //Properties
        Map<String, Integer> theMap = new TreeMap<>();
        Scanner fileScanner = null;

        // Set the data file.
        File dataFile = new File("DataFileWords.txt");

        // Try to open the file
        try {

            fileScanner = new Scanner(dataFile);

        } catch (Exception e) {

            // Couldn't open the file.
            System.out.print("Could not open the file correctly, closing the program.");
            System.exit(-1);

        }

        // Loop through the file and update the map.
        while(fileScanner.hasNext()) {

            String currentWord = fileScanner.next();

            if(!theMap.containsKey(currentWord)) {

                // The word is found for the first time.
                theMap.put(currentWord, 1);

            } else {

                // The word was already in the map
                int tempNum = theMap.get(currentWord);
                tempNum++;
                theMap.put(currentWord, tempNum);

            }

        }

        // Print off the most common to the least common of the words.
        System.out.println("The words from the file from most common to least common are..");
        while(!theMap.isEmpty()) {

            // Properties
            int maxOccurrence = -20;
            String topString = "";

            for(String word: theMap.keySet()) {

                // The current word has more occurrences than the
                // Previous max and they need to be swapped
                if(theMap.get(word) > maxOccurrence) {
                    maxOccurrence = theMap.get(word);
                    topString = word;
                }
            }

            // Print out the key and value, then delete it.
            System.out.println(topString + " which shows up " + theMap.get(topString) + " times.");
            theMap.remove(topString);

        }



    }

}
