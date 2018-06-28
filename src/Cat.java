/**
 * Created by kunqi on 6/27/18.
 */
public class Cat extends Animall {
    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }
    public static void main(String[] args) {
        Cat myCat = new Cat();
        Animall animal = new Animall();
        animal.testInstanceMethod();
        animal.testClassMethod();

        Animall myAnimal = myCat;
        Animall.testClassMethod();


        myAnimal.testInstanceMethod();
        myAnimal.testClassMethod();
        myCat.testClassMethod();
    }
}