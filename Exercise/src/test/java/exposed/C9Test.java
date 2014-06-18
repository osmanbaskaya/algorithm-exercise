package exposed;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
public class C9Test {

    @Test
    public void main() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(1);
        final List<Throwable> exceptions = new ArrayList<>();
        final Runnable highScoreRunnable = new Runnable() {
            @Override
            public void run() {
                final String highScoreDisplay = "Hello";
                try {
                    assertNotNull(highScoreDisplay);
                } catch (Throwable e) {
                    exceptions.add(e);
                }
                latch.countDown();
            }
        };

        new Thread(highScoreRunnable).start();
        assertTrue(latch.await(1, TimeUnit.SECONDS));
        if(!exceptions.isEmpty()) {
            fail("Exceptions thrown in different thread: " + exceptions);
        }
    }


}
