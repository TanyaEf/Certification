package cert.book1.chapter5;

public class Snake extends Reptile {

    public static int count = 0;
    public int i = 0;

    protected boolean hasLegs() {
        return false;
    }

    protected double getWeight() throws InsufficientDataException{
        return 2;
    }

    public static void test() {
        count++;
    }
}
