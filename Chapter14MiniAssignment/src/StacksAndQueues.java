import java.util.*;

/**
 * This program will use a method to determine if a s
 *  string is properly delimited, and return true if it
 *  is and false otherwise.
 *
 * @author Lucas D. Dahl
 * @version 10/30/20
 */
public class StacksAndQueues {

    /**
     * This is the main program to run.
     *
     * @param args the given parameters.
     */
    public static void main(String[] args) {

        // Test data
        String string1 = "[{}]";
        String string2 = "[x{12345}xxx]xxx";
        String string3 = "[1{2(3)4}5]";
        String string4 = "[][](){}";
        String string5 = "[[]}";
        String string6 = "[])";
        String string7 = "[]123{}123()123[{}]";
        String string8 = "[[[[[]]]]]((((())))){{{{{{{{{{[]}}}}}}}}}}";
        String string9 = "[[[[[]]]]]((((())))){{{{{{{{{{[]}}}}}}}}]}";
        String string10 = "[{({({({([[]])})})})}][{}]{}{{}}";
        String string11 = "[{(";
        String math = "2+(3+5*(5+7-4)*[1+2+3+(6/5)])/(2*a)";
        ArrayList<String> array = new ArrayList<>();
        array.add(string1);
        array.add(string2);
        array.add(string3);
        array.add(string4);
        array.add(string5);
        array.add(string6);
        array.add(string7);
        array.add(string8);
        array.add(string9);
        array.add(string10);
        array.add(string11);
        array.add(math);

        // Print the data
        for(String str: array) {

            if(properlyDelimited(str)) {
              System.out.println(str + " : good");
            } else {
                System.out.println(str + " : bad");
            }

        }

    }

    /**
     * This method will accept a string to and return true
     * if the string is properly delimited, false otherwise.
     *
     * @param str the string to use the delimiter on
     * @return Returns true if the string is properly delimited, false otherwise.
     */
    public static Boolean properlyDelimited(String str) {

        // Properties
        Stack<Character> openingSymbols = new Stack<>();

        // Go through the string to check if each "[({" has a closing partner.
        for (int i = 0; i < str.length(); i++) {

            // Check for an opening and closing symbols
            if (str.charAt(i) == '[' || str.charAt(i) == '(' || str.charAt(i) == '{') {

                // Add the opening symbol to the stack.
                openingSymbols.add(str.charAt(i));

            } else if (str.charAt(i) == ']' || str.charAt(i) == ')' || str.charAt(i) == '}') {

                // If the stack is not empty take the opening symbol off the stack.
                if (!openingSymbols.isEmpty()) {

                    // Check each symbol for teh closing symbol.
                    if(openingSymbols.peek() == '[' && str.charAt(i) == ']') {
                        openingSymbols.pop();
                    } else if(openingSymbols.peek() == '(' && str.charAt(i) == ')') {
                        openingSymbols.pop();
                    } else if(openingSymbols.peek() == '{' && str.charAt(i) == '}') {
                        openingSymbols.pop();
                    } else {

                        // The current closing symbol doe not match the top
                        // of the stack, so we can return false.
                        return false;
                    }
                } else {
                    // The stack was empty when the first closing symbol was found
                    // therefore we can return false.
                    return false;
                }
            }
        }

        // If the stack is empty it was properly delimited.
        if(openingSymbols.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
