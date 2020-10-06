import java.util.*;
public class Chapter11 {

    public static void main(String[] args) {

        Set<Integer> mySet = new TreeSet<>();
        List<String> myList = new LinkedList<>();

        mySet.add(34);
        mySet.add(22);
        mySet.add(3);
        mySet.add(5);

        myList.add("A");
        myList.add("cc");
        myList.add("xyc");
        myList.add("dd");
        myList.add("b");

        for(Integer x: mySet) {
            System.out.println("This sentence = " + x);
        }


        for(String thing: myList) {
            System.out.println(thing + "!");
        }

    }

}
