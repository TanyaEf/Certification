package cert.book1.chapter3;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

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

/*
        char a = 'a';
        String b = "";
        for (int j = 0; j < 3; j++) {
            b += b + a;
            System.out.println(b);
        }
*/


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

        /*Collections.sort(new LinkedList<>());*/

/*        Period.ofYears(1).ofWeeks(3);
        LocalDate.of(0,0,0);
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.MAX, LocalTime.MAX);*/

        /*test();*/

        arrayToList();
    }

    public static void timeApi() {

        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());

        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);
        LocalDate date2 = LocalDate.of(2015, 1, 20);

        LocalTime time1 = LocalTime.of(6, 15);
        LocalTime time2 = LocalTime.of(6, 15, 15);
        LocalTime time3 = LocalTime.of(6, 15, 15, 200);

        LocalDateTime dateTime1 = LocalDateTime.of(date1, time1);
        LocalDateTime dateTime2 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15,15, 200);

        System.out.println(date1);
        date1 = date1.plusDays(1);
        date1 = date1.plusWeeks(1);
        date1 = date1.plusYears(1);
        date1 = date1.plusMonths(1);
        System.out.println(date1);

        date1 = date1.minusDays(1);
        date1 = date1.minusWeeks(1);
        date1 = date1.minusYears(1);
        date1 = date1.minusMonths(1);
        System.out.println(date1);

        dateTime1 = LocalDateTime.of(date2, time2).minusDays(1).plusHours(3).plusNanos(300);
        System.out.println(dateTime1);

        Period period = Period.ofMonths(1);

        date1 = date2.plus(period);
        date2 = date2.minus(period);

        // formatting

        System.out.println(date1.getYear());
        System.out.println(date1.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(date1.format(DateTimeFormatter.ISO_DATE));
        System.out.println(date1.format(DateTimeFormatter.BASIC_ISO_DATE));
        System.out.println(time1.format(DateTimeFormatter.ISO_LOCAL_TIME));
        // pattern
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("MMM dd, yyyy, hh^mm");
        System.out.println(dateTime1.format(pattern));
        System.out.println(dateTime1.format(DateTimeFormatter.ofPattern("hh:mm")));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        DateTimeFormatter dateTimeFormatterShort = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);

        System.out.println(dateTimeFormatter.format(dateTime2));
        System.out.println(dateTimeFormatterShort.format(dateTime1));
        //parsing
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("MM dd yyyy");
        LocalDate date = LocalDate.parse("01 02 2015" ,dateTimeFormatter1);
        System.out.println(date);
        LocalTime time = LocalTime.parse("11:30");
        System.out.println(time);



    }

    public static void oldTimeApi(){
        // LocalDate.now()
        Date date = new Date();

        // LocalDateTime.now()
        Date dateTime = new Date();

        // LocalDate.of(2015, Month.JANUARY, 20);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, Calendar.JANUARY, 20);
        calendar.set(2015, 0, 20);
        Date date1 = calendar.getTime();
        // or
        Calendar calendar1 = new GregorianCalendar(2015, Calendar.JANUARY, 20);
        Date date2 = calendar1.getTime();


        // date1.plusDays(1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date1);
        calendar2.add(Calendar.DATE, 1);

        // date1.minusDays(1);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(date1);
        calendar3.add(Calendar.DATE, -1);

        // format pattern
        SimpleDateFormat  dateFormat = new SimpleDateFormat("hh:mm");
        System.out.println(dateFormat.format(date1));
    }

    public static void test() {
        LocalDateTime dateTime = LocalDateTime.of(2015, 5, 10, 11, 22, 33);
        Period p  = Period.of(1, 2, 3);
        dateTime = dateTime.minus(p);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        System.out.println(dateTime.format(dateTimeFormatter));
    }

    private static void arrayToList() {
        Integer[] arr = new Integer[]{5, 9, 4, 3, 1};
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        List<Integer> list = Arrays.asList(arr);
        list.set(0, 20);

        System.out.println(list);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        arr[1] = 30;

        System.out.println(list);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void listToArray() {
        List<Integer> list = Arrays.asList(5, 9, 4, 3, 1);
        System.out.println(list);

        Integer[] array = list.toArray(new Integer[list.size()]);
        for (Integer integer : array) {
            System.out.print(integer);
        }

        array[1] = 20;
        for (Integer integer : array) {
            System.out.print(integer);
        }
        System.out.println(list);
    }
}
