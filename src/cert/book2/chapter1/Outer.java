package cert.book2.chapter1;

public class Outer {
    private String greeting = "Hi";

    protected class Inner {
        public int repeat = 3;
        public void go() {
            for (int i = 0; i < repeat; i++) System.out.println(greeting);

        }
    }

    public void go() {
        Outer outer = new Outer();
        Inner inner = outer.new Inner();
        Inner inner1 = new Inner();
    }
}
