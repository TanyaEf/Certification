package cert.book1.Chapter6;

public class Ch6 {
    public static void start() throws Exception {
        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            throw new RuntimeException();
        } finally {
            throw new Exception();
        }
    }
}
