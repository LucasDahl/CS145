public class Rectangle implements Comparable<Rectangle> {

    private int length;
    private int width;

    public Rectangle() {
        length = 30;
        width = 30;
    }

    public Rectangle(int x) {
        length = Math.abs(x);
        width = length;
    }

    public Rectangle(int l, int w) {
        length = Math.abs(l);
        width = Math.abs(w);
    }

    public String toString() {
        return "[" + length + "x" + width + "]";
    }

    public int getArea() {
        return length * width;
    }

    public int compareTo(Rectangle o) {
        return getArea() - o.getArea(); // Define compare by the area of teh two rectangles.
    }


}
