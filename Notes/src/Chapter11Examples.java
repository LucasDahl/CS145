import java.util.*;

public class Chapter11Examples {

    public static void main(String[] args) {

        Random rand = new Random();
        Set<Integer> grades = new HashSet<>();
        Set<String> words = new TreeSet<>();

        words.add("a");
        words.add("a");
        words.add("a");
        words.add("afafg");
        words.add("arewr");
        words.add("asr");
        words.add("add");
        words.add("adfg");
        words.add("15689");




        for(int i = 0; i < 100; i++) {
            grades.add(rand.nextInt(200));
            removeFailing(grades, 60);

        }
        System.out.println(grades);

        System.out.println();

        Set<String> results = findLengthWords(words);

        System.out.println();

        System.out.println(results);

    }

    /**
     * This method will remove all bad values from a Set.
     *
     * @param theSet this is a Set og integers to evaluate
     * @param min the lowest value that will stay in the set.
     */
    public static void removeFailing(Set<Integer> theSet, int min) {

        Set<Integer> badValuesToRemove = new HashSet<>();

        // Add all the bad values to the new Set
        for(int x: theSet) {
            if(x < min) {
                badValuesToRemove.add(x);
            }
        }

        // Remove them the bad values from the passed in set
        for(int x: badValuesToRemove) {
            theSet.remove(x);
        }

    }

    /**
     *
     * @param theList takes in a set and maps it based on the length of each word.
     */
    public static Set<String> findLengthWords(Set<String> theList) {

        Map<Integer, Set<String>> theMap = new TreeMap<>();

        // Make the map
        for(String x: theList) {
            int size = x.length();

            // The map already contains this key, and a set can go with it
            if(theMap.containsKey(size)) {

                theMap.get(size).add(x); // The map already contains the key, so get the set, and add the new wrod to it.

            } else { // The map has never seen a word of this size before

                theMap.put(size, new TreeSet<String>()); // Add size + empty set to the map.
                theMap.get(size).add(x); // Get empty set from the map, and add the word(x) to it.

            }
        }

        //System.out.println(theMap);

        // Print the map out in pieces.
        for(int x: theMap.keySet()) {

            System.out.printf("There are %d words of size %d.%n", theMap.get(x).size(), x);

        }

        // Return the largest set
        int biggestSizeOfSetSoFar = -9999;
        int biggestSizeOfSetLength = 0;

        for(int x: theMap.keySet()) {

            if(theMap.get(x).size() > biggestSizeOfSetSoFar) {
                // If a bigger number is found set the values
                biggestSizeOfSetSoFar = theMap.get(x).size();
                biggestSizeOfSetLength = x;
            }
        }

        // Make the set
        return theMap.get(biggestSizeOfSetLength);

    }

}
