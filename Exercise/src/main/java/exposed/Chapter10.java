package exposed;

import java.util.ArrayList;
import java.util.List;

public class Chapter10 {

    public static List<Integer> reverseRecursive(List<Integer> list) {
        if (list.size() <= 1) { return list; }
        else {
            List<Integer> reversed = new ArrayList<>();
            reversed.add(list.get(list.size() - 1));
            reversed.addAll(reverseRecursive(list.subList(0, list.size() - 1)));
            return reversed;
        }
    }
    public static List<Integer> reverseIterative(final List<Integer> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            final int tmp = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, tmp);
        }
        return list;
    }


}
