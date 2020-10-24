import java.util.*;

/**
 * This program uses a method to extract odd indexes from a list to create a new one.
 * @author Lucas D. Dahl
 * @version 10/23/20
 */
public class QuestionTwo {
    /**
     * This is the main method
     * @param args the parameters to pass in.
     */
    public static void main(String[] args) {

       List<Integer> list1 = new ArrayList<>();
       List<Integer> list2 = new ArrayList<>();

       list1.add(13);
       list1.add(5);
       list1.add(7);
       list1.add(12);
       list1.add(42);
       list1.add(8);
       list1.add(23);
       list1.add(21);

       list2.add(14);
       list2.add(-64);
       list2.add(16);
       list2.add(88);
       list2.add(21);
       list2.add(17);
       list2.add(-93);
       list2.add(81);
       list2.add(17);

       System.out.println(extractOddIndexes(list1));
       System.out.println(list1);
       System.out.println();
       System.out.println(extractOddIndexes(list2));
       System.out.println(list2);

    }

    /**
     * This method removes all odd indexes from a list
     * to make a new one.
     * @param list the list passed in.
     * @return the list tor return.
     */
    public static List<Integer> extractOddIndexes(List<Integer> list) {

        // Properties
        List<Integer> oddList = new ArrayList<>();

        // Remove all odd indexes from the passed in list and add them
        // to a new list. 0 is even, so we start at 1.
        for(int i = 1; i < list.size(); i++) {
            oddList.add(list.get(i));
            list.remove(i);
        }

        // Return the list
        return oddList;
    }

}
