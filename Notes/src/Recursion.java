public class Recursion {

    public static void main(String[] args) {
        printStar(10);
        System.out.println(Fib(10));
        System.out.println("The mystery number 648 is " + mystery(648));
        System.out.println("The mystery2 number 648 is " + mystery2(348));
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

    // Recursive tracing
    public static int mystery(int n) {
        if(n < 10) {
            return n;
        } else {
            int a = n / 10;
            int b = n % 10;
            return mystery(a + b);
        }
    }

    public static int mystery2(int n) {
        if(n < 10) {
            return (10 * n) + n;
        } else {
            int a = mystery2(n / 10);
            int b = mystery2(n % 10);
            return (100 * a) + b;
        }
    }



}
