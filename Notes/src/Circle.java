public class Circle implements Shape {

    private double radius;
    private static final double PI = 3.14159;

    public Circle(double r) {
        radius = Math.abs(r);
    }

    public double getArea() {
        return PI * radius * radius;
    }

    public double getPerimeter() {
        return PI * 2 * radius;
    }

}
