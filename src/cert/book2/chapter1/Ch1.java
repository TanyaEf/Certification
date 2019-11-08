package cert.book2.chapter1;

import cert.book1.chapter5.Mammal;
import cert.book1.chapter5.Parent;

public class Ch1 {
    public static void start() {

        /*virtualMethodInvocationDemo();*/
        innerClassesDemo();
    }

    private static void innerClassesDemo() {
        A a = new A();
        A.B b = a.new B();
        A.B.C c = b.new C();
        c.allTheX();
}

    private static void virtualMethodInvocationDemo() {
        Animal animal = new Lion();
        System.out.println(animal.name);
        animal.printName();
        System.out.println(((Lion)animal).name);
        ((Lion)animal).printName();
    }

    private static void testIsAssignable() {
        Parent parent = new Parent();
        Class<Mammal> mammalClass = Mammal.class;
        System.out.println(Mammal.class.isAssignableFrom(parent.getClass()));
    }
}
