/**
 * This program will take a method for numbers, and String to show
 * the squares and if its a palindrome or not using recursion.
 *
 * @author Lucas D. Dahl
 * @version 10/18/20
 */
public class Recursion {

    /**
     * This is the main method used to run the program.
     * @param args this is parameter that is used to run the program.
     */
    public static void main(String[] args) {

        // Print squares
        writeSquares(8);
        System.out.println();
        writeSquares(11);
        System.out.println();
        writeSquares(1);
        System.out.println();
        writeSquares(0);

        System.out.println();

        // isPlaindrome
        System.out.println(isPalindrome("madam"));
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("step on no pets"));
        System.out.println(isPalindrome("able was I ere I saw elba"));
        System.out.println(isPalindrome("Java"));
        System.out.println(isPalindrome("rotater"));
        System.out.println(isPalindrome("byebye"));
        System.out.println(isPalindrome("notion"));

    }

    /**
     * This method will take in an int and square
     * every number until zero, printing negatives on the
     * left and positives on the right.
     *
     * @param n the int value to square
     */
    public static void writeSquares(int n) {

        if(n < 1) { // Base case
            return;
        } else if(n % 2 == 1) { // Odd numbers
            System.out.print(n * n + " ");
        }

        // Recursion step
        writeSquares(n - 1);

        if(n % 2 == 0) { // Even numbers
            System.out.print(n * n + " ");
        }

    }

    /**
     *This method will return true and
     *
     * @param word this is the word to check if its a palindrome or not.
     * @return returns ture is the word is a palindrome, false if it is not.
     */
    public static Boolean isPalindrome(String word) {

        // Properties
        int startLetter = 0, endLetter = word.length() - 1;

        if(word.charAt(startLetter) == word.charAt(endLetter)) {

            // Make a substring from the stating string.
            String newWord = word.substring(startLetter + 1, endLetter);

            return isPalindrome(newWord); // Recursion step

        } else if (startLetter == endLetter) {
            // If a word is one letter, like I it is a palindrome.
            return true;
        } else {
            return false; // base case
        }
    }
}
