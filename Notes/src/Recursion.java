public class Recursion {

    public static void main(String[] args) {
        printStar(10);
        System.out.println(Fib(10));
    }

    // This case would be better with a for loop.

    public static void printStar(int n) {
        if(n < 0) throw new IllegalArgumentException(); // Error
        if (n <= 0) {
            // BASE CASE< tells us when to stop.
            System.out.println();
        } else {
            System.out.println("*");
            printStar(n -1);
        }

    }

    public static int Fib(int x) {
        int answer;

        if(x == 0) {
            return 1;
        }
        if(x == 1) {
            return 1;
        }

        else return Fib(x - 1) + Fib(x - 2);
    }

}
