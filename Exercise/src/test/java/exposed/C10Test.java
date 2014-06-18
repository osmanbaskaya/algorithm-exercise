package exposed;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static exposed.Chapter10.reverseIterative;
import static exposed.Chapter10.reverseRecursive;
import static junit.framework.Assert.assertEquals;

public class C10Test {

    @Test
    public void listReversals() {
        final List<Integer> givenList = Arrays.asList(1, 2, 3, 4, 5);
        final List<Integer> expectedList = Arrays.asList(5, 4, 3, 2, 1);
        assertEquals(expectedList.size(), reverseRecursive(givenList).size());
        assertEquals(expectedList.size(), reverseIterative(givenList).size());
    }


}
