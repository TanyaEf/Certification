package cert.book1.bonus;

import java.lang.ref.SoftReference;

public class BonusExam1 {
    public static void start() {
        /*switchCase();
*/
        doWhile();
        whileDo();
        arrayInit();
    }

    private static void arrayInit() {
        String grades[];
        grades = new String[]{"vxcv", "cbvcb"};
        String grades1[] = {"vxcv", "cbvcb"};
    }

    private static void doWhile() {
        char value = 'c';
        do System.out.print(value++);
        while (value <= 'f');
        System.out.println();
    }

    private static void whileDo() {
        char value = 'c';

        while (value <= 'f') System.out.print(value++);
        System.out.println(value++);
    }

    private static void switchCase() {
        String s = "Senior";
        switch (s) {
            case "Freshman" : default: case "Simaphore" :
            case "Junior" :
                System.out.println("See you nest year"); break;
            case "Senior" :
                System.out.println("Congratulations");
        }
    }
}
