import java.util.*;
/**
 * This class class has a method that only shows different locations.
 * @author Lucas D. Dahl
 * @version 12/8/20
 */
public class Question15 {

    /**
     * The main method
     * @param args the parameters passed in.
     */
    public static void main(String[] args) {

        Map<String, Integer> differentLocations = new TreeMap<>();
        List<String> trips = trips  = new ArrayList<String>();
        trips.add("Erik:Reno");
        trips.add("Porter:Mexico");
        trips.add("Cherie:Vancouver");
        trips.add("Erik:Mexico");
        trips.add("Erik:LasVegas");
        trips.add("Cherie:LosAngeles");
        trips.add("Porter:NewYork");
        trips.add("Cherie:Vancouver");
        trips.add("Anna:LosAngeles");
        trips.add("Erik:Reno");

        differentLocations = numPlacesTraveled(trips);
        System.out.println(differentLocations);

    }

    /**
     * This method returns the number of different locations for each person.
     * @param places the list passed in
     * @return the map of peoples locations
     */
    public static Map<String, Integer> numPlacesTraveled(List<String> places) {

        // Properties
        Map<String, Integer> theMap = new TreeMap<>();
        Map<String, List<String>> differentLocations = new TreeMap<>();

        for(String word: places) {

            // Get the name and place
            int split = word.indexOf(":");
            String name = word.substring(0, split), location = word.substring(split + 1);

            // Check if the key is already in the map
            if(!differentLocations.containsKey(name)) {
                List<String> tempList = differentLocations.get(name);
                tempList.add(location);
                differentLocations.put(name, tempList);

                // Make sure we didn't count that location
                if(!theMap.containsKey(name)) {
                    theMap.put(name, 1);
                }
            }


        }

        for(String person: differentLocations.keySet()) {
            if(!theMap.containsKey(person)) {
                theMap.put(person, 1);
            }
        }

        return theMap;
    }

}
