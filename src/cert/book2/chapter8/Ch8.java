package cert.book2.chapter8;

import java.io.File;

public class Ch8 {
    public static void start() {
        /*systemSeparatorDemo();*/
        fileDemo(new File("C:\\Users\\Admin\\IdeaProjects\\Certification\\resources\\Zoo.properties"));
        fileDemo(new File("C:\\Users\\Admin\\IdeaProjects\\Certification"));
    }

    private static void fileDemo(File file) {
        System.out.println("Name " + file.getName());
        System.out.println("File exists: " + file.exists());
        if (file.exists()) {
            System.out.println("AbsolutePath " + file.getAbsolutePath());
            System.out.println("isDirectory " + file.isDirectory());
            System.out.println("Parent " + file.getParent());
            if (file.isFile()) {
                System.out.println("length " + file.length());
                System.out.println("lastModified " + file.lastModified());
            } else {
                File[] files = file.listFiles();
                System.out.println("SubFiles: ");
                for (File subFile1 : files) {
                    System.out.println(subFile1.getName());
                }
            }

        }
    }

    private static void systemSeparatorDemo() {
        System.out.println(System.getProperty("file.separator"));
        System.out.println(File.separator);
    }
}
