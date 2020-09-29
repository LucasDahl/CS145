public class Triangle implements Shape {

    private double a;
    private double b;
    private double c;

    public Triangle(double _a, double _b, double _c) {

        a = Math.abs(_a);
        b = Math.abs(_b);
        c = Math.abs(_c);

    }

    @Override
    public double getArea() {

        double s = a + b + c;
        s = s /2;

        s = (s - a) * (s - b) * (s - c) * s;

        return Math.sqrt(s);
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }
}
