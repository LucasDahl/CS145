import java.util.*;
/**
 * This class has a method that takes in a list and returns a set of common first letters.
 * @author Lucas D. Dahl
 * @version 12/8/20
 */
public class Question14 {

    /**
     * The main method
     * @param args the parameters passed in.
     */
    public static void main(String[] args) {

        Set<String> commonLetters = new TreeSet<>();
        List<String> testList = new ArrayList<>();
        testList.add("hi");
        testList.add("how");
        testList.add("Marty!");
        testList.add("morning?");
        testList.add("fine.");
        testList.add("?huh?");
        testList.add("HOW");
        testList.add("I");
        testList.add("is");

        commonLetters = commonFirstLetters(testList);
        System.out.println(commonLetters);


    }

    /**
     * Takes in a list and returns a set of letters that appear more than once.
     * @param theList the list passed in
     * @return the set of common first letters
     */
    public static Set<String> commonFirstLetters(List<String> theList) {

        // Properties
        Set<String> commonLetters = new TreeSet<>();
        Map<String, Integer> testMap = new TreeMap<>();

        for(String word: theList) {

            // Get the first letter of the word
            String currentWord = word.toLowerCase().substring(0, 1);

            // Add it to a map to keep track of how many times
            if(!testMap.containsKey(currentWord)) {
                testMap.put(currentWord, 1);
            } else {

                // Increase the number number the letter comes up
                int temp = testMap.get(currentWord);
                temp++;
                testMap.put(word, temp);

                // If it is more than 2 times add it to the set.
                if(temp >= 2) {
                    commonLetters.add(currentWord);
                }
            }
        }
        return commonLetters;
    }

}
