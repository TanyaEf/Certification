package cert.book2.appendixC;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ZooEmployeeManager {
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private List<String> names = new ArrayList<>();

    public ZooEmployeeManager() {
        names.add("John Smith");
        names.add("Sarah Smith");
        names.add("James Jonson");
    }

    public String readNames(int i) {
        Lock lock = readWriteLock.readLock();
        try {
            lock.lock();
            System.out.println("Read lock obtained!");
            return names.get(i % names.size());
        } finally {
            System.out.println("Read lock released");
            lock.unlock();
        }
    }

    public void addName(String name) {
        Lock lock = readWriteLock.writeLock();
        try {
            lock.lock();
            System.out.println("Write lock obtained!");
            Thread.sleep(1000);
            names.add(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Write lock released");
            lock.unlock();
        }
    }
}
