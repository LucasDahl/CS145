import java.util.*;

/**
 * This program uses a method to make a set of all odd doubles from a
 * range based off a passed in set.
 * @author Lucas D. Dahl
 * @version 10/23/20
 */
public class QuestionOne {

    /**
     * This is the main method
     * @param args the parameters to pass in.
     */
    public static void main(String[] args) {

        Set<Integer> theSet = new TreeSet<>();
        theSet.add(1);
        theSet.add(2);
        theSet.add(5);
        theSet.add(6);
        theSet.add(11);
        theSet.add(12);
        theSet.add(13);
        theSet.add(14);

        System.out.println(createOddSet(theSet));

    }

    /**
     * This method will take in a set of integers and pass back
     * a set of doubles of all the odd values from the min to the max
     * @param set the set of integers
     * @return the set of doubles.
     */
    public static Set<Double> createOddSet(Set<Integer> set) {

        // Properties
        Set<Double> doubleSet = new TreeSet<>();
        int min = 9999, max = -9999;

        // Find the max and the min.
        for(Integer num: set) {

            if(num < min) {
                min = num;
            } else if(num > max) {
                max = num;
            }
        }

        // Add each odd Double to teh set.
        for(int i = min; i < max; i++) {
            if(i % 2 == 1) {
                doubleSet.add(i * 1.0);
            }
        }

        // Return the set.
        return doubleSet;
    }

}
