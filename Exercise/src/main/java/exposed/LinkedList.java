package exposed;

/**
 * Author: Osman Baskaya
 * E-mail: obaskaya@ku.edu.tr
 * Date: 20.Jun.2014 | 16:07
 */
public class LinkedList <T> {

    public LinkedList<T> next;
    public T element;


    public LinkedList(T element, LinkedList<T> next) {
        this.next = next;
        this.element = element;
    }


    public static <T> LinkedList<T> reverse (LinkedList<T> original) {
        if (original == null) {
            throw new IllegalArgumentException("list should not be null");
        }
        if (original.next == null) {
            return original;
        }

        LinkedList<T> next = original.next;
        original.next = null;
        LinkedList<T> otherList = reverse(next);
        next.next = original;
        return otherList;
    }

    public static <T> LinkedList<T> reverseIterative(LinkedList<T> original){
        if (original == null) {
            throw new IllegalArgumentException("list should not be null");
        }
        if (original.next == null) {
            return original;
        }

        LinkedList <T> prev = null, next;
        while(true) {
            next = original.next;
            original.next = prev;
            prev = original;
            if (next == null) break;
            original = next;
        }

        return prev;
    }

}
