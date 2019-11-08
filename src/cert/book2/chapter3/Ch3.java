package cert.book2.chapter3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Ch3 {

    public static void start() {
        /*backedListDemo();*/
        genericsDemo();
        collectionsDemo();
    }

    private static void collectionsDemo() {

    }

    private static void backedListDemo() {
        String[] arr = {"gerbil", "mouse"};
        List<String> list = Arrays.asList(arr);

        arr[1] = "test";
        list.set(0, "new");

        System.out.println("list " + list);
        for (String s : arr) {
            System.out.print("array ");
            System.out.print(s + " ");
        }
/*        list.add("new elem"); // java.lang.UnsupportedOperationException
        list.remove(1);
        System.out.println("list " + list);*/

    }

    private static void autoboxingDemo() {
        List numbers = new ArrayList();
        numbers.add(5);
        int res = (int) numbers.get(0);
    }

    private static void genericsDemo() {
        Object[] arr = new String[2];
//        List<Object> list = new ArrayList<String>();
        List<String> list = new ArrayList<String>(){{
            add("one");
            add("two");
            add("threee");
        }};
        modifyGeneric(list);
        System.out.println(list);

        List<? extends Bird> birds = new ArrayList<Bird>();
//        birds.add(new Bird());
//        birds.add(new Sparrow());

        List<? super IOException> exceptions = new ArrayList<IOException>();
//        exceptions.add(new Exception()); COMPILE ERROR
        exceptions.add(new IOException());
        exceptions.add(new FileNotFoundException());



    }

    public static void modifyGeneric(List list) {
        list.add("");
        list.remove(0);
    }
}
