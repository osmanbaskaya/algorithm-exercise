package exposed;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;

public class C4Test {

	@Test
	public void sortObjects() {
		final String[] strings = { "z", "x", "y", "abc", "zzz", "zazzy" };
		final String[] expected = { "abc", "x", "y", "z", "zazzy", "zzz" };
		Arrays.sort(strings);
		assertArrayEquals(expected, strings);
	}

	@Test
	public void customSorting() {
		final List<Integer> numbers = Arrays.asList(4, 7, 1, 6, 3, 5, 4);
		final List<Integer> expected = Arrays.asList(7, 6, 5, 4, 4, 3, 1);
		Collections.sort(numbers, new ReverseNumberOrdering());
		assertEquals(expected, numbers);
	}

	@Test
	public void insertionSortTest() {
		int[] numbers = { 1, 2, 0, 3, 88, 7, 5, -2 };
		int[] expected = { -2, 0, 1, 2, 3, 5, 7, 88 };
		C4.insertionSort(numbers);
		assertArrayEquals(expected, numbers);
	}

	@Test
	public void insertSortTest() {
		final List<Integer> numbers = Arrays.asList(4, 7, 1, 6, 3, 5, 4);
		final List<Integer> expected = Arrays.asList(1, 3, 4, 4, 5, 6, 7);
		final List<Integer> orderedNumbers = C4.insertSort(numbers);
		assertEquals(expected, orderedNumbers);
	}

	@Test
	public void qSortTest1() {
		int[] numbers = { 1, 2, 0, 3, 88, 7, 5, -2 };
		int[] expected = { -2, 0, 1, 2, 3, 5, 7, 88 };
		C4.qSort(numbers, 0, numbers.length - 1);
		assertArrayEquals(expected, numbers);
	}

	@Test
	public void qSortTest() {
		final List<Integer> numbers = Arrays.asList(4, 7, 1, 6, 3, 5, 4);
		final List<Integer> expected = Arrays.asList(1, 3, 4, 4, 5, 6, 7);
		final List<Integer> orderedNumbers = C4.qSort(numbers);
		assertEquals(expected, orderedNumbers);
	}

	@Test
	public void mergeSortTest() {
		final List<Integer> numbers = Arrays.asList(4, 7, 1, 6, 3, 5, 4);
		final List<Integer> expected = Arrays.asList(1, 3, 4, 4, 5, 6, 7);
		final List<Integer> orderedNumbers = C4.mergeSort(numbers);
		assertEquals(expected, orderedNumbers);
	}

	@Test
	public void binarySearchTest() {
		final List<Integer> numbers = Arrays.asList(1, 3, 4, 4, 5, 6, 7);
		assertFalse(C4.binarySearch(numbers, 10));
		assertTrue(C4.binarySearch(numbers, 3));
	}

	@Test
	public void binarySearchIndexedTest() {
		int[] numbers = { -2, 0, 1, 2, 3, 5, 7, 88 };
		assertEquals(4,
				C4.binarySearchIndexed(numbers, 3, 0, numbers.length - 1));
		assertEquals(-1,
				C4.binarySearchIndexed(numbers, 10, 0, numbers.length - 1));
		assertEquals(2,
				C4.binarySearchIndexed(numbers, 1, 0, numbers.length - 1));
		assertEquals(numbers.length - 1,
				C4.binarySearchIndexed(numbers, 88, 0, numbers.length - 1));
	}

}