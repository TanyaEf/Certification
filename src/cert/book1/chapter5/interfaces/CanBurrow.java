package cert.book1.chapter5.interfaces;

public interface CanBurrow {
    public static final int MIN_DEPTH = 1;

    default public void print() {
        System.out.println("");
    }
}
