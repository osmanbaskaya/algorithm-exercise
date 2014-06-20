package exposed;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Author: Osman Baskaya
 * E-mail: obaskaya@ku.edu.tr
 * Date: 20.Jun.2014 | 17:04
 */
public class LinkedListTest {
    @Test
    public void testReverse() throws Exception {
        final LinkedList<String> three = new LinkedList<>("3", null);
        final LinkedList<String> two = new LinkedList<>("2", three);
        final LinkedList<String> one = new LinkedList<>("1", two);
        final LinkedList<String> reversed = LinkedList.reverse(one);
        assertEquals("3", reversed.element);
        assertEquals("2", reversed.next.element);
        assertEquals("1", reversed.next.next.element);
    }

    @Test
    public void testReverseIterative() throws Exception {
        final LinkedList<String> three = new LinkedList<>("3", null);
        final LinkedList<String> two = new LinkedList<>("2", three);
        final LinkedList<String> one = new LinkedList<>("1", two);
        final LinkedList<String> reversed = LinkedList.reverseIterative(one);
        assertEquals("3", reversed.element);
        assertEquals("2", reversed.next.element);
        assertEquals("1", reversed.next.next.element);

    }
}
