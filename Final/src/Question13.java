/**
 * This class calls the method sumTo to return the sum of the first n reciprocals
 * @author Lucas D. Dahl
 * @version 12/8/20
 */
public class Question13 {

    /**
     * The main method
     * @param args the parameters passed in.
     */
    public static void main(String[] args) {

        System.out.println(sumTo(2));
        System.out.println(sumTo(0));
        //System.out.println(sumTo(-1));

    }


    /**
     *accepts an integer parameter n and returns the sum of the first n reciprocals
     * @param n the int passed in
     * @return the sum
     */
    public static double sumTo(int n) {

        if(n < 0) {
            throw new IllegalArgumentException("Number must be greater than 0");
        } else if(n == 0) {
            return 0.0;
        } else {

            // Call the method recursively
            return 1.0 / n + sumTo(n - 1);

        }
    }
}
