package cert.book2.chapter10;

import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Ch10 {
    public static void start() {
        /*setupDerbyDatabase();*/
        readDataBaseDemo();
        ExecutorService service = Executors.newScheduledThreadPool(10);

    }

    private static void readDataBaseDemo() {
        String uri = "jdbc:derby:zoo;";
        try (Connection conn = DriverManager.getConnection(uri);
             Statement statement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)){
            ResultSet selectNameFromAnimsl = statement.executeQuery("select * from animal");
            while (selectNameFromAnimsl.next()){
                System.out.println(selectNameFromAnimsl.getInt(1) + " " + selectNameFromAnimsl.getString(3));
            }
            selectNameFromAnimsl.beforeFirst();
            System.out.println(selectNameFromAnimsl.previous());
            System.out.println(selectNameFromAnimsl.previous());
            System.out.println(selectNameFromAnimsl.absolute(-3));
            System.out.println(selectNameFromAnimsl.getInt(1) + " " + selectNameFromAnimsl.getString(3));

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static void setupDerbyDatabase() {
        String uri = "jdbc:derby:zoo;create=true";
        try (Connection conn = DriverManager.getConnection(uri);
             Statement statement = conn.createStatement()){
            statement.executeUpdate("CREATE TABLE species (id INTEGER PRIMARY KEY, " +
                    "name VARCHAR(255), num_acres DECIMAL)");
            statement.executeUpdate("CREATE TABLE animal(id INTEGER PRIMARY KEY, " +
                    "species_id INTEGER, name VARCHAR(255), date_born TIMESTAMP)");
            statement.executeUpdate("INSERT INTO species VALUES (1, 'African elephant', 7.5)");
            statement.executeUpdate("INSERT INTO species VALUES (2, 'Zebra', 1.2)");
            statement.executeUpdate("INSERT INTO animal VALUES (1, 1, 'Elsa', '2001-05-06 02:15:00')");
            statement.executeUpdate("INSERT INTO animal VALUES (2, 2, 'Zelda', '2002-08-15 09:12:00')");
            statement.executeUpdate("INSERT INTO animal VALUES (3, 1, 'Ester', '2002-09-09 10:36:00')");
            statement.executeUpdate("INSERT INTO animal VALUES (4, 1, 'Eddie', '2010-06-08 01:24:00')");
            statement.executeUpdate("INSERT INTO animal VALUES (5, 2, 'Zoe', '2001-11-12 03:44:00')");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
