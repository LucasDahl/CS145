public class RectNode {

    public Rectangle data; // DON'T NORMALLY DO
    public RectNode next;

    public RectNode(Rectangle x) {
        data = x;
        next = null; // Not actually needed, all new references are set to nul by default
    }

}
