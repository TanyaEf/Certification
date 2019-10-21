package cert.book1.chapter5;

import java.io.IOException;

public class Snake extends Reptilie {
    protected boolean hasLegs() {
        return false;
    }

    protected double getWeight() throws InsufficientDataException{
        return 2;
    }
}
