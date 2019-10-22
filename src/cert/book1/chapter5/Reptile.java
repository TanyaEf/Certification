package cert.book1.chapter5;

public class Reptile {
    public static int count = 0;
    public int i = 0;

    protected boolean hasLegs() throws InsufficientDataException{
        throw  new InsufficientDataException();
    }

    protected double getWeight() throws Exception{
        return 2;
    }

    public static void test() {
        count++;
    }
}
