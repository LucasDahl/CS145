import java.util.Random;

public class TestTree {

    public static void main(String[] args) {

        MyTree theTree = new MyTree();
//        String x = "";

        Random r = new Random();
        for(int i = 0; i < 500; i++) {
            int x = r.nextInt(1000);
            theTree.add(x);
        }

//        for(int i = 0; i < 500; i++) {
//            System.out.println("The number " + i + " was found ");
//        }

        System.out.println(theTree.toString());
        System.out.println(theTree.getMin());

    }

}
