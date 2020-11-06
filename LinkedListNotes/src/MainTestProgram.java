public class MainTestProgram {

    public static void main(String[] args) {


        Rectangle a = new Rectangle();
        Rectangle b = new Rectangle(5);
        Rectangle c = new Rectangle(2,7);

        RectLL<Rectangle> myList = new RectLL();

//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);

        System.out.println(myList.size());
        myList.add(a);
        System.out.println(myList.size());
        myList.add(b);
        System.out.println(myList.size());
        myList.add(c);
        System.out.println(myList.size());

    }

}
