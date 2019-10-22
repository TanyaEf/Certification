package cert.book1.chapter5;

import cert.book1.chapter5.interfaces.CanBurrow;
import cert.book1.chapter5.interfaces.CanSwim;

public class Animal implements CanSwim, CanBurrow {
    private static final Object MIN_DEPTH = null;
    public  int length = 2;

    public void print() {
        System.out.println("from animal");
        System.out.println(MIN_DEPTH);
    }
}
