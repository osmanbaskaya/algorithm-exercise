package exposed;

import java.util.Iterator;

/**
 * Author: Osman Baskaya
 * E-mail: obaskaya@ku.edu.tr
 * Date: 20.Jun.2014 | 17:34
 */
public class ListIterator<T> implements Iterator<T> {


    private final Iterator<Iterator<T>> iteratorList;
    private Iterator<T> currentIterator;

    public ListIterator(Iterator<Iterator<T>> iteratorList) {
        this.iteratorList = iteratorList;
        this.currentIterator = this.iteratorList.next();
    }

    @Override
    public boolean hasNext() {
        if (!currentIterator.hasNext())  {
            if (!iteratorList.hasNext()) return false;
            currentIterator = iteratorList.next();
            hasNext();  // recall it.
        }
        return true;
    }

    @Override
    public T next() {
        hasNext();
        return currentIterator.next();
    }

    @Override
    public void remove() {
        hasNext();
        currentIterator.remove();

    }
}
