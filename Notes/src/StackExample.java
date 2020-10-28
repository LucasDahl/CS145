import java.util.*;


public class StackExample {

    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();

        myStack.push(6);
        myStack.push(7);
        myStack.push(8);
        myStack.push(9);

        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack);

        // How to loop through an Stack
        while (!myStack.isEmpty()) {
            int x = myStack.pop();
            System.out.print(x);
        }

        Queue<Integer> myQueue = new LinkedList<Integer>();

        myQueue.add(4);
        myQueue.add(5);
        myQueue.add(5);
        myQueue.add(6);
        myQueue.add(7);
        myQueue.add(8);

        System.out.println(myQueue);
        System.out.println(myQueue.remove());
        System.out.println(myQueue);

        // adds all the elements together
        while(myQueue.size() > 1) {
            myQueue.add(myQueue.remove() + myQueue.remove());
            System.out.println(myQueue);
        }

        System.out.println(myQueue);

        int x;
        x = postFixEvaluate("5 2    4 * + 7 -");
        System.out.println(x);

    }

    public static int postFixEvaluate(String s) {

        Scanner lineScanner = new Scanner(s);
        Stack<Integer> numbers = new Stack<>();

        while (lineScanner.hasNext()) {

            if(lineScanner.hasNextInt()) { // If token is a number
                int temp = lineScanner.nextInt();
                numbers.push(temp);
            } else { // token is + - / *
                String op = lineScanner.next();
                op = op.trim();
                if(op.equals("+")) {
                    numbers.add(numbers.pop() + numbers.pop());
                } else if(op.equals("*")) {
                    numbers.add(numbers.pop() * numbers.pop());
                } else if(op.equals("-")) {
                    int a = numbers.pop(), b = numbers.pop();
                    numbers.add(b - a);
                } else if(op.equals("/")) {
                    int a = numbers.pop(), b = numbers.pop();
                    numbers.add(b / a);
                }
            } // end of else statement.
        } // end of the loop
        if(numbers.size() != 1) {
            throw new IllegalArgumentException();
        }

        return numbers.pop();
    }

}
