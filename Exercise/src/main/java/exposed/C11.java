package exposed;

import java.util.concurrent.*;

public class C11 {


    public static class ThreadPrinter implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("From the new thread: "
                        + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void example1() throws InterruptedException {
        final Thread separateThread = new Thread(new ThreadPrinter());
        separateThread.start();
        System.out.println("From the main thread: "
                + Thread.currentThread().getName());
        Thread.sleep(1000);
    }

    public static void example2() {

        final Executor executor = Executors.newCachedThreadPool();
        executor.execute(new ThreadPrinter());
        executor.execute(new ThreadPrinter());
        executor.execute(new ThreadPrinter());
    }

    public static void example3() throws InterruptedException, ExecutionException, TimeoutException {

        final ExecutorService executorService = Executors.newCachedThreadPool();
        final long startTime = System.currentTimeMillis();
        final Future<Double> future = executorService.submit(new PiCalculator());
        final double pi = future.get(10, TimeUnit.SECONDS);
        final long stopTime = System.currentTimeMillis();
        System.out.printf("Calculated Pi in %d milliseconds: %10.9f%n", stopTime - startTime, pi);
        executorService.shutdown();

    }

    private static class PiCalculator implements Callable<Double> {
        public Double call() throws Exception {
            double currVal = 1.0;
            double nextVal = 0.0;
            double denominator = 1.0;
            for (int i = 0; Math.abs(nextVal - currVal) > 0.000000001d; denominator += 2.0, i++) {
                currVal = nextVal;
                if (i % 2 == 1) {
                    nextVal = currVal - (1 / denominator);
                } else {
                    nextVal = currVal + (1 / denominator);
                }
            }
            return currVal * 4;
        }
    }

    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        example3();
    }


}
