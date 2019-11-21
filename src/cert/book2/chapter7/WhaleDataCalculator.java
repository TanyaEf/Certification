package cert.book2.chapter7;

import java.util.List;

public class WhaleDataCalculator {

    public WhaleDataCalculator() {
    }

    public static void processAllData(List<Integer> data) {
        data.stream().map(integer -> processRecord(integer)).count();
    }

    public static void processAllDataInParallel(List<Integer> data) {
        data.parallelStream().map(integer -> processRecord(integer)).count();
    }

    public static int processRecord(int input) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return input++;
    }
}
