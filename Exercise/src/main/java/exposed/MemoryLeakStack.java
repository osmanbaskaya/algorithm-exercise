package exposed;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tyr on 6/17/14.
 */
public class MemoryLeakStack<E> {

    private final List<E> stackValues;

    private int stackPointer;
    public MemoryLeakStack() {

        this.stackValues = new ArrayList<>();
        stackPointer = 0;
    }
    public void push(E element) {
        stackValues.add(stackPointer, element);
        stackPointer++;
    }
    public E pop() {
        stackPointer--;
        return stackValues.get(stackPointer);
    }



}
