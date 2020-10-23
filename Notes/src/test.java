import java.util.*;

public class test {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(6);
        list.add(1);
        list.add(8);
        mystery2(list);
        System.out.println(foo(5, 7));
        String yo = "hello";
        char ch = 'e';
        String a = yo.substring(1);
        System.out.println(a);
        String b = yo.charAt(0) + yo.substring(1);
        System.out.println(b);
        String c = yo.substring(1) + ch;
        System.out.println(c);
        System.out.println(5 / 10);
        List<String> listString = new ArrayList<>();
        listString.add("example");
        listString.add("::=");
        listString.add("5 |");
        listString.add("6 |");
        listString.add("7 |");
        listString.add("87 |");
        listString.add("1 0");
        String s1 = "";

        for(String word: listString) {
            s1 += word;
        }


        Scanner lineScanner = new Scanner(listString.toString());
        lineScanner.useDelimiter("::=");
        String front = lineScanner.next();
        String back = lineScanner.next();
        System.out.println(front);
        System.out.println(back);

    }

    public static void mystery2(ArrayList<Integer> list) {

        for(int i = list.size() - 1; i > 0; i--) {
            if(list.get(i) < list.get(i - 1)) {
                int el = (int) list.get(i);
                list.remove(i);
                list.add(0, el);
            }
        }
        System.out.println(list);
    }

    public static int foo(int x, int y) {
        if (x <0 || y < 0) return -1;
        if (y == 0) return 0;
        return x + foo(y-1, x);
    }

}


