public class QuestionFour {
    public static void main(String[] args) {

//        mystery(0, 90);
//        mystery(12, 2);
//        mystery(12, 22);
//        mystery(556, 666);
        mystery(582, 1522);
        System.out.println();
        System.out.println(582 % 10);
        System.out.println(1522 % 10 + " end");

    }

    public static void mystery(int n, int m) {
        if(n > 0 && m > 0) {
            System.out.println(n + " -- " + m + " if 1");
            mystery(n / 10, m / 10);
        }

        System.out.println(n + " -- " + m + " before if");
        if(n % 10 == m % 10) {
            System.out.println(n % 10 + " -- " + m % 10 + " if 2");
            System.out.println();
            System.out.print("=");
            System.out.println();
        } else {
            System.out.println(n + " -- " + m + " else");
            System.out.println();
            System.out.print("!");
            System.out.println();
        }
    }

}
