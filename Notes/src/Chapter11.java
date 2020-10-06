import java.util.*;
public class Chapter11 {

    public static void main(String[] args) {

        Set<Integer> mySet = new TreeSet<>();
        List<String> myList = new LinkedList<>();
        Map<String, Integer> myMap = new TreeMap<>();
        String sent = "fkhdfjkhdfhaghdakjdgahfdkjahsdfiawehrlihflkhalsfhuaeriwfhuadfgadsgfjggfgfassgfdassfgsgfwegaewoufgijkhvbkajsdfhnc";

        myMap.put("Bob", 1234);
        myMap.put("Sue", 5646);
        myMap.put("CeCe", 3);

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


        System.out.println();

        for(String thing: myList) {
            System.out.println(thing + "!");
        }

        System.out.println();

        System.out.println(myMap);

        System.out.println();

        System.out.println(myMap.get("bob"));

        System.out.println();

        // How to iterate through a map.
        for(String x: myMap.keySet()) {

            System.out.println(x);
            System.out.println(myMap.get(x));
            System.out.println("------------------");

        }

        System.out.println();

        showStringCount(sent);

    }

    public static void showStringCount(String x) {

        Map<Character, Integer> letterCount = new TreeMap<>();

        for(int i = 0; i < x.length(); i ++) {

            char c = x.charAt(i);

            if(!letterCount.containsKey(c)) {

                // Add one to for that character in the map, since it
                // does not already contain that character
                letterCount.put(c, 1);

            } else if (letterCount.containsKey(c)) {

                // The letter is already in the map, so
                // get the number by using the key, add one to
                // it and put it back into that key.
                int temp = letterCount.get(c);
                temp++;
                letterCount.put(c, temp);

            }

        }

        //System.out.println(letterCount);

        for(Character c: letterCount.keySet()) {
            System.out.println("The letter " + c + " shows up " + letterCount.get(c) + " times.");
        }

    }

}
