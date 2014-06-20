package exposed;

import java.util.*;

/**
 * Author: Osman Baskaya
 * E-mail: obaskaya@ku.edu.tr
 * Date: 19.Jun.2014 | 13:56
 */
public class Anagrams {


    Map<String, List<String>> lookup = new HashMap<>();

    public Anagrams(final Set<String> words) {
        Iterator<String> it = words.iterator();
        while (it.hasNext()) {
            final String word = it.next();
            final String signature = alphabetize(word);
            if (lookup.containsKey(signature)){
                lookup.get(signature).add(word);
            }
            else {
                final List<String> anagramList = new ArrayList<>();
                anagramList.add(word);
                lookup.put(signature, anagramList);
            }

        }
    }

    public List<String> getAnagrams(final String word){
        final String signature = alphabetize(word);
        final List<String> anagrams = lookup.get(signature);
        return anagrams != null ? anagrams : new ArrayList<String>(0);
    }

    public String alphabetize(final String word) {
        final byte[] bytes = word.getBytes();
        Arrays.sort(bytes);
        return new String(bytes);
    }
}
