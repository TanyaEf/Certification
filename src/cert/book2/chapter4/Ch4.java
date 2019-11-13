package cert.book2.chapter4;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ch4 {

    private static final Consumer<String> printValues = s -> System.out.print(s + " ");

    public static void start() {
        /*optionalDemo();*/

        objectStreamsDemo();
        primitiveStreamsDemo();
        summarizingStatisticDemo();

        /*
        * List.of(1, 2, 3)
  .stream()
  .peek(System.out::println)
  .count();
        * */
    }

    private static void summarizingStatisticDemo() {
        IntSummaryStatistics intSummaryStatistics = IntStream.empty().summaryStatistics();
        intSummaryStatistics.getCount();
        intSummaryStatistics.getMax();
        intSummaryStatistics.getMin();
        intSummaryStatistics.getSum();
    }

    private static void primitiveStreamsDemo() {
        Stream<Integer> integerStream = getIntegerStream();
        System.out.println("sum " + integerStream.mapToInt(value -> value).sum());
        System.out.println("avg " + integerStream.mapToInt(value -> value).average().getAsDouble());
    }

    private static Stream<Integer> getIntegerStream() {
        return Stream.of(10, 20, 30, 50, 100);
    }

    private static IntStream getIntStream() {
        return Stream.of(10, 20, 30, 50, 100).mapToInt(value -> value);
    }

    private static void objectStreamsDemo() {
        sourceOperationsExamples();
        terminalOperationsExamples();
        inttermediateoperationsexamples();


    }

    private static void inttermediateoperationsexamples() {
        // intermediate operations
        System.out.print("\nfilter ");
        getStringStream().filter(s -> s.startsWith("m")).forEach(System.out::print);

        System.out.print("\ndistinct ");
        getStringStream().distinct().forEach(printValues);

        System.out.print("\nlimit ");
        getStringStream().limit(2).forEach(printValues);

        System.out.print("\nskip ");
        getStringStream().skip(1).forEach(printValues);

        System.out.print("\nMAP ");
        getStringStream().map(s -> s + " ").forEach(System.out::print);

        System.out.print("\nMAP ");
        getStringStream().map(String::length).map(Object::toString).forEach(System.out::print);

        System.out.print("\nsorted ");
        getStringStream().sorted().forEach(System.out::print);

        System.out.print("\nsorted ");
        getStringStream().sorted(Comparator.reverseOrder()).forEach(System.out::print);

        System.out.print("\npeek ");
        getStringStream().sorted(Comparator.reverseOrder()).map(s -> s +=" ").peek(System.out::print).count();
    }

    private static void terminalOperationsExamples() {
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

        System.out.println("collect " + getStringStream()
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString());

        System.out.println("collect " + getStringStream()
                .collect(StringBuilder::new, (stringBuilder, s) -> stringBuilder.append(" ").append(s), StringBuilder::append)
                .toString());

        System.out.println("collect " + getStringStream()
                .collect(Collectors.toCollection(LinkedList::new)));

        System.out.println("collect " + getStringStream()
                .collect(Collectors.toSet()));
    }

    private static void sourceOperationsExamples() {
        // source
        Stream<Object> empty = Stream.empty();
        Stream<Integer> integerStream = Stream.of(1);
        Stream<Integer> arrayStream1 = Stream.of(1, 10, 20);
        Stream<Double> generate = Stream.generate(Math::random).limit(10);
        Stream<Integer> iterate = Stream.iterate(1, i -> i + 1).limit(10);
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
