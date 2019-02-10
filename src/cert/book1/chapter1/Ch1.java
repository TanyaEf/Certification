package cert.book1.chapter1;

public class Ch1 {
    String str;

    {
        System.out.println(str);
        str = "From static block";
        System.out.println(str);
    }

    public Ch1() {
        str = "From constructor";
        System.out.println(str);
    }
}
