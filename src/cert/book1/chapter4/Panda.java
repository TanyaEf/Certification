package cert.book1.chapter4;

public class Panda extends Bear{
    static {
        System.out.println("From Panda static initializer block 1");
    }
    {
        System.out.println("From Panda instance initializer block 1");
    }

    public Panda() {
        super();
        System.out.println("From Panda no-arg constructor");
    }
    {
        System.out.println("From Panda instance initializer block 2");
    }

     Panda(Bear bear) {
//        super();
        this();
        System.out.println("From Panda  constructor bear");
    }
}
