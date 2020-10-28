import java.util.Stack;

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

    }

}
