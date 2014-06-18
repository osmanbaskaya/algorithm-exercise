package exposed;

import org.junit.Test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.assertEquals;

/**
 * Created by tyr on 6/18/14.
 */
public class C11Test {

    //    @Test
    public void executorExample() {
        final ExecutorService executor = Executors.newCachedThreadPool();
        final Runnable threadNamePrinter = new InfiniteThreadNamePrinter();
        System.out.println("Main thread: " +
                Thread.currentThread().getName());
        executor.execute(threadNamePrinter);
    }

    private static class InfiniteThreadNamePrinter implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println("Run from thread: " +
                        Thread.currentThread().getName());
            }
        }
    }

    //    @Test
    public void sameThread() {
        final Executor executor = new Executor() {
            @Override
            public void execute(final Runnable command) {
                command.run();
            }
        };
        System.out.println("Main thread: " +
                Thread.currentThread().getName());
        executor.execute(new FiniteThreadNamePrinter());
    }
    private static class FiniteThreadNamePrinter implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 25; i++) {
                System.out.println("Run from thread: " +
                        Thread.currentThread().getName());
            }
        }
    }

    @Test
    public void lockedSharedState() throws InterruptedException {
        final ExecutorService executorService =
                Executors.newCachedThreadPool();
        final SimpleCounter c = new SimpleCounter();
        executorService.execute(new CounterSetter(c));
        synchronized (c) {
            c.setNumber(200);
            assertEquals(200, c.getNumber());
        }
    }
    private static class CounterSetter implements Runnable {
        private final SimpleCounter counter;
        private CounterSetter(SimpleCounter counter) {
            this.counter = counter;
        }
        @Override
        public void run() {
            while(true) {
                synchronized (counter) {
                    counter.setNumber(100);
                }
            }
        }
    }

    public class SimpleCounter {
        private int number = 0;
        public void setNumber(int number) {
            this.number = number;
            System.out.println("Counter is changed to " + number);

        }
        public int getNumber() {
            return number;
        }
    }



}
