package cert.book1.chapter4;

import cert.book1.chapter4.rope.Rope;

import static cert.book1.chapter4.rope.Rope.*;

import cert.book1.chapter4.school.ClassRoom;

import java.util.ArrayList;
import java.util.List;

public class Ch4 {

    static int i;
    int y;

    public void method1() {
    }

    public final void method2() {
    }

    final public void method3() {
    }

    public final static void method4() {
    }

    public static final void method5() {
    }

    static public final void method6() {
    }

    synchronized static public final void method7() {
    }

    static public synchronized final void method8() {
    }

    static public final synchronized void method9() {
    }


    public void method10(int i, int b, int... nums) {
    }

    public void method12() {
    }

    public void method13() {
    }

    public static void start() {
        //if (y > 0) System.out.println(y); => DO NOT COMPILE

        /*Koala koala = new Koala();
        System.out.println(koala.count);
        koala = null;
        System.out.println(koala.count);*/

        /*fly((short)123456789);*/

        /*play(4);*/

        /*new Panda();*/
        /*chimp();*/

/*        Rope rope = new Rope();
        rope.swing();
        Rope rope2 = null;
        rope2.swing();*/

        Test test = new Test();
/*        short s = 123;
        test.print(s);
        test.print(true);
        test.print(6.789);*/

        int x = 9;
        long square = square(x);
        System.out.println(x);

    }

    public static void chimp() {
        Rope.swing();
        new Rope().swing();
        System.out.println(LENGTH);
        System.out.println(Rope.LENGTH);
    }

    public void nonStatic(int a) {
        if (a < i) System.out.println(i);
    }

/*    private static void fly(int i) {
        System.out.println("int");
    }
    private static void fly(short i) {
        System.out.println("short " + i);
    }*/

/*    private static void play(int i) {
        System.out.println("int");
    }*/
/*    private static void play(long i) {
        System.out.println("long");
    }*/

    private static void play(Long i) {
        System.out.println("Long");
    }

    /*  private static void play(Integer i) {
          System.out.println("Integer");
      }*/
    private static void play(Object i) {
        System.out.println("Object");
    }

    private static long square(int x) {
        long y = x * /*(long)*/x;
        x = -1;
        return y;
    }

    private static void lamblsDemo() {
        List<String> list = new ArrayList<>();
        list.removeIf((String s)-> s.isEmpty());
        list.removeIf(String::isEmpty);
    }
}
