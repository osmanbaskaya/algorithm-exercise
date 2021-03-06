package exposed;

import java.util.ArrayList;
import java.util.List;

import static org.junit.runners.Parameterized.*;

public class ListOfIntegerArraysForTest extends ArrayList<Integer[]> {

        {
            this.add(new Integer[]{1, 2, 3, -1, 2, 0});
            this.add(new Integer[]{0, 1, 1, -1, 0, 0});
            this.add(new Integer[]{-11, 2, -9, -13, -22, -5});
        }

        public ListOfIntegerArraysForTest() {
            super(3);
        }

    @Parameters
    public static List<Integer[]> parameters() {
        return new ListOfIntegerArraysForTest();
    }
}
