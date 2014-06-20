package exposed;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Author: Osman Baskaya
 * E-mail: obaskaya@ku.edu.tr
 * Date: 20.Jun.2014 | 17:31
 */
public class PalindromeTest {
    @Test
    public void testIsPalindrome() throws Exception {
        assertTrue(Palindrome.isPalindrome("ara"));
        assertTrue(Palindrome.isPalindrome("aaabaaa"));
        assertFalse(Palindrome.isPalindrome("arsaa"));
        assertTrue(Palindrome.isPalindrome("1aa1"));

    }
}
