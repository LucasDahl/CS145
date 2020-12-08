public class Pet extends Mammal{
    public void method2() {
        System.out.println("Pet 2");
    }
    public void method3() {
        method2();
        System.out.println("Pet 3");
    }
}
