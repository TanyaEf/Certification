package cert.book2.chapter8;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.util.Arrays;

public class Ch8 {
    public static void start() {
        /*systemSeparatorDemo();*/
        /*fileDemo(new File("C:\\Users\\Admin\\IdeaProjects\\Certification\\resources\\Zoo.properties"));*/
        /*fileDemo(new File("C:\\Users\\Admin\\IdeaProjects\\Certification"));*/
        /*bufferedScreamsDemo();*/
        /*printWriterDemo();*/
        /*consoleReaderDemo();*/
        readPasswordSample();
        
    }

    private static void readPasswordSample() {
        Console console = System.console();
        if (console == null) throw  new RuntimeException("Console is not available!");
        char[] password = console.readPassword("Enter your password");
        console.format("Enter your password again");
        console.flush();
        char[] verify= console.readPassword("Enter your password again");
        boolean match = Arrays.equals(password, verify);
        for (int i = 0; i < password.length; i++) {
            password[i] = 'x';
        }
        for (int i = 0; i < verify.length; i++) {
            verify[i] = 'x';
        }
        console.format("Passwords are " + (match ? "correct" : "incorrect"));
    }

    private static void consoleReaderDemo() {
        Console console = System.console();
        if (console == null) {
            throw new RuntimeException("Console is not available");
        } else {
            console.writer().print("How excited about your trip you are today?");
            console.flush();
            String excitementAnswer = console.readLine();
            String name = console.readLine("What is your name? ");
            console.writer().print("What is your name?");
            BufferedReader reader = new BufferedReader(console.reader());
            if (reader != null) {
                try {
                    String age = reader.readLine();
                    Integer ageInt = Integer.valueOf(age);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {

                        }
                    }
                }
            }

        }
    }

    private static void printWriterDemo() {
        try {
            PrintWriter printWriter = new PrintWriter("zoo.log");
            printWriter.print(5);
            printWriter.write(String.valueOf(5));
        } catch (FileNotFoundException e) {

        }
    }

    private static void bufferedScreamsDemo() {
        long start = System.currentTimeMillis();
        BufferedInputStream inputStream = null;
        BufferedOutputStream outputStream = null;
        long end = 0;
        try {
            inputStream = new BufferedInputStream(new FileInputStream("resources/markel_002.jpg"));
            outputStream = new BufferedOutputStream(new FileOutputStream("resources/markel_002_copy.jpg"));
            byte[] buffer = new byte[2048];

            int input;
            while ((input = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, input);
                outputStream.flush();
            }
            end = System.currentTimeMillis();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null && outputStream != null) {
                try {
                    inputStream.close();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            long duration = (end - start);
            System.out.println("duration: " + duration);
        }
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
