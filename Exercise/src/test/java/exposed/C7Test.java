package exposed;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static exposed.C7.fibonacci;
import static junit.framework.Assert.assertEquals;

/**
 * Author: Osman Baskaya
 * E-mail: obaskaya@ku.edu.tr
 * Date: 19.Jun.2014 | 12:58
 */
public class C7Test {

    C7 c7;


    @Before
    public void createInstance(){
        c7 = new C7();
    }


    @Test
    public void testFibonacci() throws Exception {
        assertEquals(0, fibonacci(0).size());
        assertEquals(Arrays.asList(0), fibonacci(1));
        assertEquals(Arrays.asList(0, 1), fibonacci(2));
        assertEquals(Arrays.asList(0, 1, 1), fibonacci(3));
        assertEquals(Arrays.asList(0, 1, 1, 2), fibonacci(4));
        assertEquals(Arrays.asList(0, 1, 1, 2, 3), fibonacci(5));
        assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5), fibonacci(6));
        assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5, 8), fibonacci(7));
        assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13), fibonacci(8));
    }

    @Test
    public void testFibN(){
        assertEquals(0, c7.fibN(1));
        assertEquals(1, c7.fibN(2));
    }

//    @Test
    public void largeFib() {
        final long nonCachedStart = System.nanoTime();
        assertEquals(1134903170, c7.fibN(46));
        final long nonCachedFinish = System.nanoTime();
        assertEquals(1134903170, c7.cachedFibN(46));
        final long cachedFinish = System.nanoTime();
        System.out.printf(
                "Non cached time: %d nanoseconds%n",
                nonCachedFinish - nonCachedStart);
        System.out.printf(
                "Cached time: %d nanoseconds%n",
                cachedFinish - nonCachedFinish);
    }

    @Test
    public void stringLengths() {
        final List<String> strings = Arrays.asList(
                "acing", "the", "java", "interview"
        );
        final List<Integer> expected = Arrays.asList(5, 3, 4, 9);
        final List<Integer> actual =
                C7.mapList(strings, new StringLengthOperation());
        assertEquals(expected, actual);
    }



}

