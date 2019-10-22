package cert.book1.chapter1;

public class Ch1 {


    String str;
    static int i = 0;

    {
        ++i;
        System.out.println(i + "" + str);
        str = "From instance initializer block";
        System.out.println(i + "" + str);
    }

    public Ch1() {
        str = "From constructor";
        System.out.println(i + "" + str);
    }

    public static void start() {

        Ch1 ch1 = new Ch1();

        long max = 3123456789L;
        long l = 123;
        byte b = 123;
        short sh = 123;
        int in= 123;

        double dl= 3123456789d;
        double d2= 3123456789.0;

        double d3= 0xE;
        float fl= 3123456789f;
        float f2= 3123456789.0f;

        Integer.parseInt("2");
        Integer integer = Integer.valueOf("2");
    }
}
