package cert.book1.chapter2;

public class Ch2 {
    public static void labels() {
        FIRST_CHAR_LOOP:
        for (int i = 1; i <= 4; i++) {
            for (char x = 'a'; x <= 'c'; x++) {
                if (i == 2 || x == 'b')
                    continue FIRST_CHAR_LOOP;
                System.out.println(" " + i + x);
            }
        }

    }

    public static void start() {

 /*       int y = 0;
        System.out.println(y = 2);

        boolean b = true;
         if (b = false) {
             System.out.println(b);
         }*/


/*        int x = 1;
        long l = x * 2 - x++ - x++;
        System.out.println(x + " "+ l);*/

/*        for (int j = 0; j <10;) {
            j += j++;
            System.out.println("Hello world! " + j);
        }*/

/*        System.out.println(1 % 2);
        float f = 1 % 2;
        System.out.println(f);
        System.out.println(2 % 2);
        System.out.println(-2 % 2);
        System.out.println(3 % 2);
        System.out.println(-3 % 2);
        System.out.println(10 % 3);
        System.out.println(-10 % 3);
        System.out.println(-20 % 9);*/
    }
}
