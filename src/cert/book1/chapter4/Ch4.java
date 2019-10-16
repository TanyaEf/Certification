package cert.book1.chapter4;

public class Ch4 {

    static int i;
    int y;

    public void method1(){}
    public final void method2(){}
    final public void method3(){}
    public final static void method4(){}
    public  static final void method5(){}
    static public final  void method6(){}
    synchronized static public final  void method7(){}
    static public synchronized final  void method8(){}
    static public final synchronized void method9(){}


    public void method10(int i, int b, int... nums){}
    public void method12(){}
    public void method13(){}

    public static void start() {
        //if (y > 0) System.out.println(y); => DO NOT COMPILE
    }

    public void nonStatic(int a) {
        if (a < i) System.out.println(i);
    }
}
