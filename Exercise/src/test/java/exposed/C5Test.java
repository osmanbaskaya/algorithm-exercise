package exposed;

import org.junit.Test;
import static org.junit.Assert.*;


public class C5Test {

	@Test
	public void arrayCopy() {
		int[] integers = { 0, 1, 2, 3, 4 };
		int[] newIntegersArray = new int[integers.length + 1];
		System.arraycopy(integers, 0, newIntegersArray, 1, integers.length);
		integers = newIntegersArray;
		integers[5] = 5;

	}


}
