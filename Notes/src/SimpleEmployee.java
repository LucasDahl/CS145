// Comparable is to make the object searchable
public class SimpleEmployee implements Comparable<SimpleEmployee>{

    String name;
    int ID;

    @Override
    public int compareTo(SimpleEmployee other) {

        // Need to check to make sure the names arent the same
        // Sets cant have duplicates.

        // Check the ID's first
//        if(ID > other.ID) return 1;
//        if(ID < other.ID) return -1;
//        // IF they match, check the names
//        if(name.compareTo(other.name) > 0) return 1;
//        if(name.compareTo(other.name) < 0) return -1;
//        //ID and name match
//        return 0;

        // Tricks

        // Subtraction approach(with integer values) wont work for doubles.
        //return ID - other.ID;

        // Delegation trick, using methods that already exist
        //return name.compareTo(other.name);

        // Good way to do this compareTo
        if(ID != other.ID) {
            return ID - other.ID;
        } else {
            return name.compareTo(other.name);
        }

    }


    @Override
    public String toString() {
        return "[" + name + ":" + ID + "]";
    }

}
