package cert.book2.appendixC;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AppC {
    public static void start() {

//        locksDemo();
        watchServiceSample();
    }

    private static void watchServiceSample() {
        try (WatchService service = FileSystems.getDefault().newWatchService()) {
            Path resourcesData = Paths.get("C:\\Users\\Admin\\IdeaProjects\\Certification\\resources");
            Path zooData = Paths.get("C:\\Users\\Admin\\IdeaProjects\\Certification\\zoo");
            resourcesData.register(service,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY);
            zooData.register(service, StandardWatchEventKinds.ENTRY_MODIFY);

            for(;;){
                WatchKey key;
                try {
                    key = service.take();
                } catch (InterruptedException e) {
                    break;
                }
                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    if (kind == StandardWatchEventKinds.OVERFLOW) continue;
                    WatchEvent<Path> watchEvent = (WatchEvent<Path>) event;
                    Path path = watchEvent.context();
                    System.out.println("event path = " + path.getFileName() + ", event type = " + kind);
                }
                if (!key.reset()) break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void locksDemo() {
        ZooEmployeeManager zooEmployeeManager = new ZooEmployeeManager();
        ExecutorService service = null;
        try {
            service = Executors.newFixedThreadPool(20);
            for (int i = 0; i < 100; i++) {
                final int employeeNumber = i;
                service.submit(() -> zooEmployeeManager.readNames(employeeNumber));
                service.submit(() -> zooEmployeeManager.addName("Grace Hopper"));
                service.submit(() -> zooEmployeeManager.addName("Josephine Davis"));
            }
        } finally {
            if (service != null) service.shutdown();
        }
    }
}
