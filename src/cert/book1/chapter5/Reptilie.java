package cert.book1.chapter5;

public class Reptilie {
    protected boolean hasLegs() throws InsufficientDataException{
        throw  new InsufficientDataException();
    }

    protected double getWeight() throws Exception{
        return 2;
    }
}
