package exposed;

/**
 * Author: Osman Baskaya
 * E-mail: obaskaya@ku.edu.tr
 * Date: 20.Jun.2014 | 17:27
 */
public class Palindrome {


    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        for (;left <= right; right--, left++){
            if (str.charAt(left) != str.charAt(right))
                return false;
        }

        return true;

    }
}
