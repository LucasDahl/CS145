import java.util.*;
/**
 * This program uses a method to remove the min
 * value from a set.
 * @author Lucas D. Dahl
 * @version 10/23/20
 */
public class QuestionThree {

    /**
     * This is the main method
     * @param args the parameters to pass in.
     */
    public static void main(String[] args) {

        Set<Integer> s = new HashSet<>();
        int z;

        s.add(3);
        s.add(4);
        s.add(5);
        s.add(8);
        s.add(9);
        s.add(12);
        s.add(14);
        s.add(13);
        s.add(1);
        s.add(2);
        s.add(0);
        s.add(20);

        z = removeMin(s);
        System.out.println(z);
        System.out.println(s);

    }

    /**
     * This method will take in a set and remove
     * the min to return.
     * @param set the set to pass in.
     * @return the min value returned.
     */
    public static int removeMin(Set<Integer> set) {

        // Properties
        int min = 100000;
        Iterator itr = set.iterator();

        // Find the min and remove it.
        while(itr.hasNext()) {
            Integer x = (int) itr.next();
            if(x < min) {
                min = x;
                itr.remove();
            }
        }

        // Return the min
        return min;

    }
}
