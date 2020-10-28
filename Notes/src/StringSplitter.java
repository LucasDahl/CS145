import java.util.*;

/**
 *  This class will accept a string of numbers and operators and ( ) and break
 *  it up into pieces/tokens that can be accessed later, one by one.
 *  It should be able to differentiate between (2.8 and ( 2.8 with or
 *  without the space. The operators we are looking for are +. -. /, * and ^.
 *
 * @author Lucas D. Dahl
 * @version 10/27/20
 */
public class StringSplitter {

    private String copyOfString;
    private Queue<Character> characters = null;
    private String nextToken = null;

    // This is static and final because the characters will never change
    // and it should be shared by all objects of this class.
    private static final String SPECIAL_CHARACTERS = "()+/-*^";

    /**
     *  THis is the base constructor that will read in an store
     *  the string to be parsed.
     *
     * @param theString The string data of number/ops to be broken apart.
     */
    public StringSplitter(String theString) {
        copyOfString = theString;
        //TODO: error checking on string, make sure it isn,t null, or size > 0.
        characters = new LinkedList<Character>();

        // Add each char to the queue
        for(int i = 0; i < copyOfString.length(); i++) {
            characters.add(copyOfString.charAt(i));
        }

        findNextToken();
    }

    private void findNextToken() {

        // Go through the queue and remove all the white space in the front.
        // Gets ride of all the white space in the front.
        while(!characters.isEmpty() && Character.isWhitespace(characters.peek())) {
            characters.remove();
        }

        // If we emptied the queue there will be no token/
        if(characters.isEmpty()) {
            nextToken = null;
        } else {
            nextToken = "" + characters.remove();

            // Make sure we didn't grab any of the special characters.
            // If it doesn't, grab more numbers
            if(!SPECIAL_CHARACTERS.contains(nextToken)) {
                boolean done = false;

                while(!characters.isEmpty()) {

                    // Look at the next char
                    char ch = characters.peek();

                    if(Character.isWhitespace(ch) || SPECIAL_CHARACTERS.indexOf(ch) >= 0) {

                        // There is a space after the token we found, or an op.
                        done = true;

                    } else {
                        nextToken = nextToken + characters.remove();
                    }
                }
            }
        }
    } // End of FindNextToken


    /**
     * Returns true/false depending on if there is another token available.
     *
     * @return Is there a token to deliver.
     */
    public Boolean hasNExt() {
        return nextToken != null;
    }

    /**
     * This method returns the next token from the string provided.
     *
     * @return
     * @throws NoSuchElementException if the next Token does not exist.
     */
    public String next() {

        if(nextToken == null) throw  new NoSuchElementException();

        String temp = nextToken;
        findNextToken();

        return temp;
    }

}
