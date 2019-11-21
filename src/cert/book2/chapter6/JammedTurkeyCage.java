package cert.book2.chapter6;

public class JammedTurkeyCage implements AutoCloseable {
    public static int counter = 0;
    public int instanceNum = 0;

    public JammedTurkeyCage() {
        instanceNum = ++counter;
    }

    @Override
    public void close() throws IllegalStateException{
        throw new IllegalStateException("Cage door does not close " + instanceNum);
    }
}
