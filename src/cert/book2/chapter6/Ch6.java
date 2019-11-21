package cert.book2.chapter6;

public class Ch6 {
    public static void start() {
        suppressedExceptionsDemo();
    }

    private static void suppressedExceptionsDemo() {
        try (JammedTurkeyCage cage = new JammedTurkeyCage();
             JammedTurkeyCage cage2 = new JammedTurkeyCage()){
            System.out.println("put turkeys in");
            throw new IllegalStateException("try to close the door");
        } catch (IllegalStateException e) {
            System.out.println("caught: " + e.getMessage());
            for (Throwable throwable : e.getSuppressed()) {
                System.out.println(throwable.getMessage());
            }
        }
    }
}
