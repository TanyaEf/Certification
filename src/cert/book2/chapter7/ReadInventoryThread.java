package cert.book2.chapter7;

public class ReadInventoryThread extends Thread {
    @Override
    public void run() {
        System.out.println("Printing zoo inventory");
    }
}
