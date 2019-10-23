package cert.book1.chapter5;

public abstract class Bird {
    private void fly() {
        System.out.println("Bird is flying");
    }

    public static void test () {
        Bird b = new Pelican();
        b.fly();
    }

}
