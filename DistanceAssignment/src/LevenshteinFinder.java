import java.util.*;
/**
 * This class
 *
 * @author Lucas D. Dahl
 * @version 10/06/20
 *
 */
public class LevenshteinFinder {

    // **************************** Fields ****************************
    private String startingPath, endingPath;
    private Map<String, Set<String>> neighborWords = new TreeMap<>();
    private int distance = -1;
    private List<String> wordPath = new ArrayList<>();

    // ************************** Constructors ************************

    /**
     *This constructor will setup the LevenshsteinFinder object. It will
     * check both word lengths and trims the set to only contain words of
     * that length.
     *
     * @param sPath This will be the staring path String.
     * @param ePath This will be the ending path String.
     * @param words This is the set of words.
     * @throws IllegalArgumentException if the parameters sPath and ePAth are not the same length.
     */
    public LevenshteinFinder(String sPath, String ePath, Set<String> words) {

        if(sPath.length() != ePath.length()) {
            throw new IllegalArgumentException("Both words must be the same length!");
        } else {

            startingPath = sPath;
            endingPath = ePath;

        }

        // Trim the set to be only the words with the same length.
        trimWords(words, startingPath.length());

        // Set the first word in the wordPath.
        wordPath.add(sPath);

        // Get the distance.
        getDistance();

    }


    // **************************** Methods ***************************

    // Trim the set to only keep the words with the same length as the path words.
    private void trimWords(Set<String> theSet, int wordLength) {

        // Properties
        Iterator<String> words = theSet.iterator();

        while(words.hasNext()) {
            String word = words.next();
            if(word.length() != wordLength) {
                words.remove();
            }
        }

        //return theSet;
    }

    private int differentLetters(String a, String b) {

        // Properties
        char[] wordOne = a.toCharArray(), wordTwo = b.toCharArray();
        int differentLetters = 0;

        for(int i = 0; i < a.length(); i++) {

            if(wordOne[i] != wordTwo[i]) {
                differentLetters++;
            }

        }

        return differentLetters;
    }

    private int findDistance(String a, String b) {
        return  distance = wordPath.size();
    }

    private void findPath(String a, String b) {

        // Set the path distance
        distance = wordPath.size();

    }

    /**
     * This method will return the distance between the two words.
     * @return will return the distance between the two words.
     */
    public int getDistance() {
        return distance;
    }

    /**
     *  This method will return the path between the two words
     * @return will return the string path.
     */
    public String getPath() {

        String stringPath = "";

        for(int i = 0; i < wordPath.size(); i++) {

            if(i == wordPath.size()) {
                // This is the last word in the path
                stringPath += (wordPath.get(i));
            } else {
                stringPath += (wordPath.get(i) + "->");
            }

        }

        return stringPath;
    }

}