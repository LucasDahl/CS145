import java.util.*;

/**
 *
 * @author Lucas D. Dahl
 * @version 10/29/20
 */
public class Evaluator {


    /**
     * This method will accept a string input in, and convert/evaluate it, and return the
     * final number.
     *
     * @param x the string to be evaluated.
     * @return The final (double) value
     */
    public static double evaluate(String x) {

        // Properties
        StringSplitter data = new StringSplitter(x);
        Stack<Double> values = new Stack<>();
        Stack<String> symbols = new Stack<>();
        Boolean error = false;

        while(!error && data.hasNExt()) {
            String token = data.next();

            if(token.equals("(")) {
                symbols.push(token);
            } else if("+-*/^".contains(token) && token.length() == 1) {
                symbols.push(token);
            } else if(token.equals(")")) {

                if(symbols.size() < 2 || symbols.peek().equals("(")) {
                    error = true;
                } else {

                    String operator = symbols.pop();

                    if(!symbols.peek().equals("(")) {
                        error = true;
                    } else {
                        symbols.pop();
                        double op2 = values.pop(); // Stacks are in backwards order
                        double op1 = values.pop();
                        double val = evaluatePair(operator, op1, op2);
                        values.push(val);
                    }
                }

            } else { // It is a number
                double val = Double.parseDouble(token);
                values.push(val);
            }
        }

        while(values.size() > 1 && symbols.size() > 0) {
            String operator = symbols.pop();
            double op2 = values.pop();
            double op1 = values.pop();
            double val = evaluatePair(operator, op1, op2);
            values.push(val);
        }

        if(error || values.size() != 1 || !symbols.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return values.pop();
    }

    private static double evaluatePair(String operator, double lhs, double rhs) {

        if(operator.equals("+")) {
            return lhs + rhs;
        }
        if(operator.equals("-")) {
            return lhs - rhs;
        }
        if(operator.equals("*")) {
            return lhs * rhs;
        }
        if(operator.equals("/")) {
            return lhs / rhs;
        }
        if(operator.equals("^")) {
            return Math.pow(lhs, rhs);
        }

        throw new RuntimeException();

    }

}
