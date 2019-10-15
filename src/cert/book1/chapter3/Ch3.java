package cert.book1.chapter3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class  Ch3 {
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

/*        String str1 = "hello world";
        System.out.println(str1.substring(3,2));*/

        char a = 'a';
        String b = "";
        for (int j = 0; j < 3; j++) {
            b += b + a;
            System.out.println(b);
        }


/*        String s = new String();
        s.substring(2,3);
        s.equals("");*/

/*        StringBuilder builder = new StringBuilder();
        builder.charAt(2);
        builder.insert(1,"");*/

        /*        Arrays.sort(new Object[2]);*/

/*        List<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("four");

        System.out.println(strings);*/

        Period.ofYears(1).ofWeeks(3);
        LocalDate.of(0,0,0);

        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.MAX, LocalTime.MAX);


    }
}
