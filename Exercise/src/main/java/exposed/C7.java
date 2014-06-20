package exposed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: Osman Baskaya
 * E-mail: obaskaya@ku.edu.tr
 * Date: 19.Jun.2014 | 12:37
 */
public class C7 {

    public static void main(String[] args) {
//        System.out.println(fizzBuzz(30));
        System.out.println(fibonacci(10));
    }

    private  Map<Integer, Integer> fibCache = new HashMap<>();


    public int cachedFibN(final int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be bigger than zero");
        }
        fibCache.put(1, 0);
        fibCache.put(2, 1);
        return recursiveCachedFibN(n);
    }

    private int recursiveCachedFibN(int n) {
        if (!fibCache.containsKey(n)){
            int value = recursiveCachedFibN(n-1) + recursiveCachedFibN(n-2);
            fibCache.put(n, value);
        }
        return fibCache.get(n);
    }

    public  int fibN(final int n) {

        if (n <= 0) {
            throw new IllegalArgumentException("n must be bigger than zero");
        }
        if (n == 2) return 1;
        if (n == 1) return 0;
        return fibN(n - 1) + fibN(n-2);
    }


    public static List<Integer> fibonacci(final int n){
        List<Integer> toReturn = new ArrayList<>(n);
        int first = 0;
        int second = 1;
        if (n > 0){
            toReturn.add(first);
        }
        if (n > 1) {
            toReturn.add(second);
        }
        if (n > 2) {
            for (int i = 3; i <= n; i++) {
                int temp = second;
                second =  second + first;
                first = temp;
                toReturn.add(second);
            }
        }
        return toReturn;
    }

    public static List<String> fizzBuzz(final int n) {
        List<String> toReturn = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            final String word = toWord(3, i, "Fizz") + toWord(5, i, "Buzz");
            if (word.isEmpty()){
                toReturn.add(Integer.toString(i));
            }
            else {
                toReturn.add(word);
            }

        }
        return toReturn;
    }

    private static String toWord(final int divisor, final int value, String word) {
        return value % divisor == 0 ? word : "";
    }

    public static <A, B> List<B> mapList (final List<A> values, GenericOperation<A, B> op){

        final List<B> toReturn = new ArrayList<>(values.size());
        for (A value : values){
            toReturn.add(op.performOperation(value));
        }
        return toReturn;

    }


}
