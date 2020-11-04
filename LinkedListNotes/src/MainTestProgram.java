public class MainTestProgram {

    public static void main(String[] args) {


        Rectangle a = new Rectangle();
        Rectangle b = new Rectangle(5);
        Rectangle c = new Rectangle(2,7);

        RectLL myList = new RectLL();

//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);

        myList.add(a);
        System.out.println(myList);
        myList.add(b);
        System.out.println(myList);
        myList.add(c);
        System.out.println(myList);



    }

}
