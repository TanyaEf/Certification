package cert.book2.chapter3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Ch3 {

    public static void start() {
        /*backedListDemo();*/
        /*genericsDemo();*/
        /*collectionsDemo();*/
        /*comparatorDemo();*/
        /*multiValuedComparatorDemo();*/
        java8ApiDemo();
    }

    private static void java8ApiDemo() {
        List<String> list = new ArrayList<String>(){{
            add("Magisian");
            add("Assistant");
            add("Cleaner");
        }};
        list.removeIf(s -> s.startsWith("A"));
        System.out.println(list);
        list.replaceAll(s -> s + "*");
        System.out.println(list);
        list.forEach(System.out::println);

        //map.merge()
        BiFunction<String, String, String> mapper = (s, s2) -> s.length() > s2.length() ? s : s2;

        Map<String, String> stringStringMap = new HashMap<String, String>() {{
            put("Jenny","Bus Tour");
            put("Tom","Tram");
            put("Tom","Tram");
            put(null,"Tram");
        }};
        stringStringMap.merge("Jenny", "SkyRide", mapper);
        stringStringMap.merge("Janny", "SkyRide", mapper);
//        stringStringMap.merge("Tom", null, mapper);           NullPointerException
        stringStringMap.merge(null, "Sky", mapper);
        System.out.println(stringStringMap);

        //map.computeIfPresent()
        BiFunction<String, String, String> mapper1 = (k, v) -> k + " " + v + "*";
        String janny = stringStringMap.computeIfPresent("Janny", mapper1);
        System.out.println(janny);

        //map.computeIfPresent()
        Function<String, String> mapper2 = (v) -> v + "*";
        String sam = stringStringMap.computeIfAbsent("Sam", mapper2);
        System.out.println(sam);

    }

    private static void multiValuedComparatorDemo() {
        Squirrel squirrel1 = new Squirrel("Emma", 1);
        Squirrel squirrel2 = new Squirrel("Barni", 1);
        Squirrel squirrel3 = new Squirrel("Emma", 2);

        Comparator<Squirrel> squirrelComparator = new Comparator<Squirrel>() {
            @Override
            public int compare(Squirrel o1, Squirrel o2) {
                Comparator<Squirrel> chainingComparator = Comparator.comparing(s -> s.getName());
                chainingComparator = chainingComparator.thenComparing(s -> s.getWeight());
                return chainingComparator.compare(o1, o2);
             }
        };
        List<Squirrel> list = Arrays.asList(squirrel1, squirrel2, squirrel3);
        System.out.println(list);
        Collections.sort(list, squirrelComparator);
        System.out.println(list);
    }

    private static void comparatorDemo() {
        List<Duck> ducks = new ArrayList<Duck>(){{
            add(new Duck("Peter"));
            add(new Duck("Anna"));
            add(new Duck("Zuma"));
            add(new Duck("Fozzy"));
        }};
        Collections.sort(ducks);
        System.out.println(ducks);
        Comparator<Duck> duckComparator = new Comparator<Duck>() {
            @Override
            public int compare(Duck o1, Duck o2) {
                return o2.getName().compareTo(o1.getName());
            }
        };
        Collections.sort(ducks, duckComparator);
        System.out.println(ducks);
    }

    private static void collectionsDemo() {
        // List
        List<String> linkedList  = new LinkedList<>();
        linkedList.add("one");
        linkedList.add("one");
        linkedList.add("two");
        linkedList.add(null);
        linkedList.add(null);
        linkedList.add("three");
        System.out.println("LinkedList " + linkedList);

        List<String> arrayList = new ArrayList<>();
        arrayList.add("one");
        arrayList.add("one");
        arrayList.add("two");
        arrayList.add(null);
        arrayList.add(null);
        arrayList.add("three");
        System.out.println("ArrayList " + arrayList);

        // Queue
        Queue<String> queue = new ArrayDeque<>();
        queue.add("one");
        queue.add("one");
        queue.add("two");
//        queue.add(null);          NullPointerException
//        queue.add(null);          NullPointerException
        queue.add("three");
        System.out.println("ArrayDeque " + queue);

        //Set
        Set<String> hashSet = new HashSet<>();
        hashSet.add("one");
        hashSet.add("two");
        hashSet.add("two");
        hashSet.add(null);
        hashSet.add(null);
        hashSet.add("three");
        System.out.println("HashSet  " + hashSet);

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("one");
        treeSet.add("two");
        treeSet.add("two");
//        treeSet.add(null);        NullPointerException
//        treeSet.add(null);        NullPointerException
        treeSet.add("three");
        System.out.println("TreeSet  " + treeSet);

        //Map
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("one", "one");
        hashMap.put("one", "two");
        hashMap.put(null, "one");
        hashMap.put(null, "two");
        hashMap.put("two", null);
        hashMap.put("three", "three");
        System.out.println("HashMap " + hashMap);

        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("one", "one");
        treeMap.put("one", "two");
//        treeMap.put(null, "one");        NullPointerException
//        treeMap.put(null, "one");        NullPointerException
        treeMap.put("two", null);
        treeMap.put("three", "three");
        System.out.println("TreeMap " + treeMap);
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
