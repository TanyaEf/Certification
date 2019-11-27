package cert.book2.chapter9;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Ch9 {

    private static final String pathToFile = "C:\\Users\\Admin\\IdeaProjects\\Certification\\resources\\markel_002.jpg";

    public static void start() {
        /*pathDemo();*/
        walkingDirectoryDemo();
    }

    private static void walkingDirectoryDemo() {
        Path path = Paths.get("resources");
        try {
            Files
                    .walk(path, 10)
                    .filter(path1 -> path1.toString().endsWith(".properties"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files
                    .find(path, 10, (path1, basicFileAttributes) -> path1.toString().endsWith(".properties"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void pathDemo() {
        Path path = Paths.get(pathToFile);
        try {
            Path pathFromUri = Paths.get(new URI("ftp:///Users/Admin/IdeaProjects/Certification/resources/markel_002.jpg"));
        } catch (URISyntaxException | FileSystemNotFoundException e) {

        }
        File file = new File(pathToFile);
        Path path1 = file.toPath();
        File file1 = path.toFile();

        Path path2 = Paths.get("Zoo_copy.properties");
        System.out.println("isAbsolute " + path2.isAbsolute());
        System.out.println("toAbsolutePath " + path2.toAbsolutePath());
        System.out.println("relativize  " + path2.relativize(Paths.get("Zoo.properties")));

    }

}
