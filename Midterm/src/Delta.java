public class Delta extends Beta {
    public void a() {
        System.out.println("Delta a");
    }
    public void c() {
        b();
        System.out.println("Delta c");
    }
}
