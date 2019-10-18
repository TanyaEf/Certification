package cert.book1.chapter4;

public class Bear {
    static {
        System.out.println("From Bear static initializer block 1");
    }
    {
        System.out.println("From Bear instance initializer block 1");
    }

    public Bear() {
        System.out.println("From Bear constructor");
    }
}
