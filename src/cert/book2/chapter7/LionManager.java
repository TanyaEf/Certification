package cert.book2.chapter7;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class LionManager {
    private void removeAnimal() {
        System.out.println("Removing animal");
    }
    private void cleanPen() {
        System.out.println("Cleaning the pen");
    }
    private void addAnimal() {
        System.out.println("Adding animal");
    }

    public void performTask(CyclicBarrier barrier, CyclicBarrier barrier1) {
        try {
            removeAnimal();
            barrier.await();
            cleanPen();
            barrier.await();
//            barrier1.await();
            addAnimal();

        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

}
