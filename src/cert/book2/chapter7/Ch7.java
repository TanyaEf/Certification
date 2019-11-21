package cert.book2.chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ch7 {
    public static int counter;

    public static void start() {
        /*createThreadDemo();*/
        /*executorServiceDemo();*/
        /*futureDemo();*/
        /*synchronizingDataDemo();*/
        /*synchronizingCollectionDemo();*/
        /*parallelStreamDemo();*/
        /*serialToParallelStreamDemo();*/
        /*cyclicBarrierDemo();*/
        /*deadLockDemo();*/
        forkJoinTaskDemo();
    }

    private static void forkJoinTaskDemo() {
        Double[] weights = new Double[10];
        ForkJoinTask<?> task = new WeighAnimalAction(0, weights.length, weights);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);

        System.out.println();
        System.out.println("Weights: ");
        Arrays.asList(weights).stream().forEach(aDouble -> System.out.println(aDouble.intValue() + " "));
    }

    private static void deadLockDemo() {
        Fox foxy = new Fox();
        Fox tails = new Fox();
        Food food = new Food();
        Water water = new Water();

        ExecutorService service = null;
        try {
            service = Executors.newScheduledThreadPool(10);
            service.submit(() -> foxy.eatAndDrink(food, water));
            service.submit(() -> tails.drinkAndEat(food, water));
        } finally {
            if (service != null) service.shutdown();
        }
    }

    private static void cyclicBarrierDemo() {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newFixedThreadPool(4);
            LionManager manager = new LionManager();
            CyclicBarrier barrier = new CyclicBarrier(4);
            CyclicBarrier barrier1 = new CyclicBarrier(4, () -> System.out.println("*** Pen cleaned!!***"));
            for (int i = 0; i < 4; i++) {
                executorService.submit(() -> manager.performTask(barrier, barrier1));
            }
        } finally {
            if (executorService != null) executorService.shutdown();
        }
    }

    private static void serialToParallelStreamDemo() {
        Arrays.asList(1, 2, 3, 4, 5, 6).stream().unordered().parallel();
    }

    private static void parallelStreamDemo() {
        WhaleDataCalculator calculator = new WhaleDataCalculator();
        ArrayList<Integer> list = Stream
                .iterate(0, integer -> ++integer)
                .limit(4000)
                .collect(Collectors.toCollection(ArrayList::new));
        long currentTimeMillis = System.currentTimeMillis();
//        calculator.processAllData(list);
        calculator.processAllDataInParallel(list);
        long duration = (System.currentTimeMillis() - currentTimeMillis) / 1000;
        System.out.println("spend time " + duration + " seconds");
    }

    private static void synchronizingCollectionDemo() {
        List<Integer> list = Collections.synchronizedList(new ArrayList<>(Arrays.asList(4, 53, 48)));
        synchronized (list) {
            for (Integer integer : list) {
                System.out.println(integer + "");
            }
        }


    }

    private static class SheepManager {

        private int sheepCount;
        private AtomicInteger atomicInteger = new AtomicInteger(1);

        private synchronized void incrementAndReport() {
            System.out.println((++sheepCount) + "");
        }

        private synchronized void incrementAndReportAtomic() {
            System.out.println((atomicInteger.incrementAndGet()) + "");
        }

    }

    private static void synchronizingDataDemo() {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newFixedThreadPool(20);
            SheepManager sheepManager = new SheepManager();
            System.out.println("usualInt ");
            for (int i = 0; i < 10; i++)
                executorService.submit(() -> {
                    sheepManager.incrementAndReport();
                });
            System.out.println("AtomicInteger");
            for (int i = 1; i < 10; i++)
                executorService.submit(() -> {
                    sheepManager.incrementAndReportAtomic();
                });

        } finally {
            if (executorService != null) executorService.shutdown();
        }
    }

    private static void futureDemo() {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            Future<?> printing = executorService.submit(() -> {
                for (int i = 0; i < 3; i++) System.out.println(counter++);
            });
            Future<Integer> integerFuture = executorService.submit(() -> 30 + 11);
            System.out.println("isDone " + printing.isDone());
            System.out.println("isCancelled  " + printing.isCancelled());
            System.out.println("get " + printing.get(10, TimeUnit.SECONDS));
            System.out.println("get integer " + integerFuture.get(10, TimeUnit.SECONDS));
            System.out.println("end");
            System.out.println("isDone " + printing.isDone());

        } catch (TimeoutException | InterruptedException | ExecutionException e) {
            System.out.println("Not reached in time");
        } finally {
            if (executorService != null) executorService.shutdown();
        }
        try {
            if (executorService != null) {
                executorService.awaitTermination(1, TimeUnit.SECONDS);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (executorService.isTerminated()) System.out.println("All tasks finished");
            else System.out.println("At least one task is still running");
        }
    }

    private static void executorServiceDemo() {
        ExecutorService executorService = null;
        try {
            executorService = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            executorService.execute(() -> System.out.println("Printing zoo inventory"));
            executorService.execute(() -> {
                for (int i = 0; i < 3; i++) System.out.println(i);
            });
            executorService.execute(() -> System.out.println("Printing zoo inventory"));
            Future<?> printing = executorService.submit(() -> System.out.println("Printing zoo inventory from submit"));
            System.out.println("end");
            System.out.println("isDone " + printing.isDone());
            System.out.println("isCancelled  " + printing.isCancelled());
            System.out.println("get " + printing.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            if (executorService != null) executorService.shutdown();
        }
    }

    private static void createThreadDemo() {
        System.out.println("begin");
        new ReadInventoryThread().start();
        new Thread(new PrintData()).start();
        new ReadInventoryThread().start();
        new Thread(new PrintData()).start();
        new Thread(() -> System.out.println("java 8 style thread")).start();
        System.out.println("end");
    }
}
