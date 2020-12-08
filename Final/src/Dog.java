public class Dog extends Pet{
    public void method1() {
        System.out.println("Dog 1");
    }
    public void method2() {
        System.out.println("Dog 2");
        super.method2();
    }
}
