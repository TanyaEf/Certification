package cert.book2.chapter5;

import java.time.ZoneId;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class Ch5 {
    public static void start() {
        /*teZoneIdExample();*/
        /*recourseBundleExample();*/
        recourseBundleEnheritanceExample();
        propertyExample();
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
