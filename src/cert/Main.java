package cert;

import cert.book2.chapter3.Ch3;
import cert.book2.chapter4.Ch4;
import cert.book2.chapter5.Ch5;
import cert.book2.chapter6.Ch6;
import cert.book2.chapter7.Ch7;
import cert.book2.chapter8.Ch8;

public class Main {
    String str;

    static int i = 0;

    {
        ++i;
        System.out.println(i + "" + str);
        str = "From instance initializer block";
        System.out.println(i + "" + str);
    }

    public Main() {
        str = "From constructor";
        System.out.println(i + "" + str);
    }

    public static void main(String[] args) {
        /*runBook1();*/

        runBook2();

    }

    private static void runBook2() {
        // chapter 1 book 2
        System.out.println("Start of chapter 1 book 2");

        /*Ch1.start();*/

        // chapter 3 book 2
        System.out.println("Start of chapter 3 book 2");

        /*Ch3.start();*/

        // chapter 4 book 2
        System.out.println("Start of chapter 4 book 2");

        /*Ch4.start();*/

        // chapter 5 book 2
        System.out.println("Start of chapter 5 book 2");

       /* Ch5.start();*/

        // chapter 6
        System.out.println("Start of chapter 6 book 1");
        /*Ch6.start();*/

        // chapter 7
        System.out.println("Start of chapter 7 book 2");
        /*Ch7.start();*/

        // chapter 8
        System.out.println("Start of chapter 8 book 2");
        Ch8.start();

    }

    private static void runBook1() {
        // Assessment Test
        System.out.println("Start of assessment test book 1");
        /*Assesment.assesmemt();*/

        // chapter 1
        System.out.println("Start of chapter 1 book 1");
        /*Main main = new Main();*/
        /*Ch1.start();*/

        // chapter 2
        System.out.println("Start of chapter 2 book 1");
        /* Ch2.labels();
        Ch2.start();*/

        // chapter 3
        System.out.println("Start of chapter 3 book 1");
      /*  Ch3.start();*/
        /*Ch3.labels();*/
        /*Ch3.timeApi();*/
        /*Ch3.oldTimeApi();*/
        /*"".substring(0,0);*/

        // chapter 4
        System.out.println("Start of chapter 4 book 1");
        /*Ch4.start();*/

        // chapter 5
        System.out.println("Start of chapter 5 book 1");
        /*Ch5.start();*/

/*        System.out.println(0f / 0f);  //Nan
        System.out.println(1f / 0f); // Infinity
        System.out.println(-1f / 0f); // - Infinity

        System.out.println(0d / 0d);
        System.out.println(1d / 0d);
        System.out.println(-1d / 0d);*/


        // bonus exam
        System.out.println("Start of bonus exam 1");

/*        BonusExam1.start();*/
    }

}
