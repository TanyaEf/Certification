package cert.book2.chapter4;

import java.lang.ref.SoftReference;
import java.util.Optional;
import java.util.stream.Stream;

public class Ch4 {
    public static void start() {
        /*optionalDemo();*/

        streamsDemo();
    }

    private static void streamsDemo() {
        // source
        Stream<Object> empty = Stream.empty();
        Stream<Integer> integerStream = Stream.of(1);
        Stream<Integer> arrayStream1 = Stream.of(1, 10, 20);
        Stream<Double> generate = Stream.generate(Math::random).limit(10);
        Stream<Integer> iterate = Stream.iterate(1, i -> i + 1).limit(10);

        //terminalOperations

        Stream<String> stringStream = getStringStream();

        System.out.println("count " + getStringStream().count());
        System.out.println("max " + getStringStream().max(String::compareTo));
        System.out.println("min " + getStringStream().min(String::compareTo));

        getStringStream().findAny().ifPresent(System.out::println);
        getStringStream().findAny().ifPresent(s -> System.out.println("findAny " + s));
        getStringStream().findFirst().ifPresent(System.out::println);
        getStringStream().findFirst().ifPresent(s -> System.out.println("findFirst " + s));

        System.out.println("anyMatch " + getStringStream().anyMatch(s -> s.startsWith("m")));
        System.out.println("noneMatch " + getStringStream().noneMatch(s -> s.startsWith("m")));
        System.out.println("allMatch " + getStringStream().allMatch(s -> s.startsWith("m")));

        getStringStream().forEach(System.out::print);
        System.out.println();

        System.out.println("reduce " + getStringStream().reduce("", (s, s2) -> s + " " + s2));
        System.out.println("reduce " + getStringStream().reduce("", String::concat));

    }

    private static Stream<String> getStringStream() {
        return Stream.of("monkey", "gorilla", "bonoboo", "monkey");
    }

    private static void optionalDemo() {
        Optional<Double> avg = avg(10, 20, 30);

        if (avg.isPresent()) System.out.println(avg.get());
        avg.ifPresent(value -> System.out.println("" + value));

        System.out.println(avg.orElse(0d));
        System.out.println(avg.orElseGet(() -> 0d));
        System.out.println(avg.orElseThrow(() -> new IllegalStateException()));
    }

    private static Optional<Double> avg(int... a) {
        if (a.length == 0) return Optional.empty();
        int sum = 0;
        for (int i : a) {
            sum +=i;
        }
        return Optional.of((double)(sum / a.length));
//        return Optional.ofNullable((double)(sum / a.length));
}
}
