public class Rectangle implements Shape {

    private double l;
    private double w;

    public Rectangle(double length, double width) {

        l = length;
        w = width;

    }

    @Override
    public double getArea() {
        return l * w;
    }

    @Override
    public double getPerimeter() {
        return l + l + w + w;
    }
}

