package exposed;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Author: Osman Baskaya
 * E-mail: obaskaya@ku.edu.tr
 * Date: 19.Jun.2014 | 14:07
 */
public class AnagramsTest {

    Anagrams instance;

    @Before
    public void setUp() throws Exception {
        instance = new Anagrams(new HashSet<>(Arrays.asList("car", "door", "rob", "acr")));
    }

    @Test
    public void checkLookupTableCreation(){
        assertTrue(instance.lookup.size() != 0);
    }

    @Test
    public void testGetAnagrams() {
        assertEquals(Arrays.asList("car", "acr"), instance.getAnagrams("car"));
    }

    @Test
    public void testAlphabetize(){
        assertEquals("acr", instance.alphabetize("car"));
        assertEquals("acrrrrr", instance.alphabetize("carrrrr"));
    }


}
