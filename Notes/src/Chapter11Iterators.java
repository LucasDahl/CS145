import java.util.*;
public class Chapter11Iterators {

    public static void main(String[] args) {

        List<Integer> myList = new ArrayList<>();
        Iterator<Integer> i; // Creates an iterator that goes through any collection with INT.
        Map<Character, Integer> code = new TreeMap<>();
        Iterator<Map.Entry<Character, Integer>> mapIt;


        myList.add(123);
        myList.add(677);
        myList.add(4345);
        myList.add(233);
        myList.add(23);
        myList.add(23142);
        myList.add(2);

        i = myList.iterator(); // Set the iterator, same way with sets.

        while(i.hasNext()) {
            int t = i.next();

            if(t < 10) {
                i.remove();
            }

        }

        // Reset the iterator
        i = myList.iterator();

        while(i.hasNext()) {

            int t = i.next();
            System.out.println(t + " is one of the values.");

        }

        System.out.println();

        code.put('a', 12);
        code.put('b', 1);
        code.put('c', 1);
        code.put('d', 115);

        mapIt = code.entrySet().iterator();

        // With out iterator
        for(char combo: code.keySet()) {
            System.out.println(combo + " = " + code.get(combo));
        }

        System.out.println();

        while(mapIt.hasNext()) {

            Map.Entry<Character, Integer> temp = mapIt.next();
            System.out.println(temp.getKey() + " = " + temp.getValue());

        }

    }

}
