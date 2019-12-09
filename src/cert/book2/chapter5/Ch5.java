package cert.book2.chapter5;

import java.time.Duration;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class Ch5 {
    public static void start() {
        /*teZoneIdExample();*/
        /*recourseBundleExample();*/
        /*recourseBundleEnheritanceExample();*/
        /*propertyExample();*/

        /*propertiesHierarchyDemo();*/
        chronoUnitsDemo();
    }

    private static void chronoUnitsDemo() {
        System.out.println(Duration.of(1, ChronoUnit.MINUTES));
        System.out.println(Duration.ofMinutes(1));
        System.out.println(Duration.of(60, ChronoUnit.SECONDS ));

        System.out.println(Duration.ofDays(1));
        System.out.println(Period.ofDays(1));
    }

    private static void propertiesHierarchyDemo() {
        Locale locale = new Locale("fr");
        Locale.setDefault(new Locale("en", "US"));
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Dolphins", locale);
        System.out.println(Locale.getDefault().toString());
        System.out.println(resourceBundle.getString("name"));
        System.out.println(resourceBundle.getString("age"));
    }

    private static void recourseBundleEnheritanceExample() {
        Locale locale = new Locale("en", "CA");
        ResourceBundle resourceBundle = ResourceBundle.getBundle("Zoo", locale);
        System.out.print(resourceBundle.getString("hello") + ". ");
        System.out.print(resourceBundle.getString("name") + ". ");
        System.out.print(resourceBundle.getString("open") + ". ");
        System.out.print(resourceBundle.getString("visitor") + ". ");
    }

    private static void propertyExample() {
        Properties properties = new Properties();
    }

    private static void recourseBundleExample() {
        Locale localeUs = new Locale("en", "US");
        Locale localeFr = new Locale("fr", "FR");
        ResourceBundle zooEn = ResourceBundle.getBundle("Zoo", localeUs);
        System.out.println(zooEn.getString("hello"));
        System.out.println(zooEn.getString("open"));
        ResourceBundle zooFr = ResourceBundle.getBundle("Zoo", localeFr);
        System.out.println(zooFr.getString("hello"));
        System.out.println(zooFr.getString("open"));
    }

    private static void teZoneIdExample() {
        ZoneId
                .getAvailableZoneIds()
                .stream()
                .filter(s -> s.contains("US") || s.startsWith("Amer"))
                .sorted().forEach(System.out::println);
    }
}
