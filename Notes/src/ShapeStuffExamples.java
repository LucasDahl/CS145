public class ShapeStuffExamples {

    public static void main(String[] args) {

        Shape[] items = new Shape[4];

        items[0] = new Circle(7);
        items[1] = new Triangle(4, 5, 6);
        items[2] = new Rectangle(10, 20);
        items[3] = new Square(100);

        for(int i = 0; i < items.length; i++) {
            printInfo(items[i]);
        }

    }

    public static void printInfo(Shape x) {

        System.out.println("The are of this shape is " + x.getArea() + " units, and a perimeter of " + x.getPerimeter() + " units.");

    }

}
