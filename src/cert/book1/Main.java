package cert.book1;
import cert.book1.chapter4.Bear;
import cert.book1.chapter4.Ch4;
import cert.book1.chapter4.Panda;
import cert.book1.chapter5.Ch5;

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
        // Assessment Test
        System.out.println("Start of assessment test");

        /*Assesment.assesmemt();*/


        // chapter 1
        System.out.println("Start of chapter 1");

        /*Main main = new Main();*/

        /*Ch1.start();*/


        // chapter 2
        System.out.println("Start of chapter 2");


        /* Ch2.labels();
        Ch2.start();*/


        // chapter 3
        System.out.println("Start of chapter 3");

        /*Ch3.start();
        Ch3.labels();*/
        /*Ch3.timeApi();*/
        /*Ch3.oldTimeApi();*/

        /*"".substring(0,0);*/


        // chapter 4
        System.out.println("Start of chapter 4");

        /*Ch4.start();*/


        // chapter 5
        System.out.println("Start of chapter 5");

        Ch5.start();


    }

}
