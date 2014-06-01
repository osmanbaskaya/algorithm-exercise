package exposed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class C4 {

	public void bubbleSort(int[] numbers) {
		boolean isSwitched;
		do {
			isSwitched = false;
			for (int i = 0; i < numbers.length - 1; i++) {
				if (numbers[i] > numbers[i + 1]) {
					int temp = numbers[i];
					numbers[i] = numbers[i + 1];
					numbers[i + 1] = temp;
					isSwitched = true;
				}
			}
		} while (isSwitched);
	}

	public static void insertionSort(int[] numbers) {

		for (int i = 1; i < numbers.length; i++) {
			int m = i;
			for (int j = i - 1; j >= 0; j--) {
				if (numbers[m] < numbers[j]) {
					int temp = numbers[m];
					numbers[m] = numbers[j];
					numbers[j] = temp;
					m--;
				} else
					break;
			}
		}
	}

	public static List<Integer> insertSort(final List<Integer> numbers) {
		final List<Integer> sortedList = new LinkedList<Integer>();
		originalList: for (Integer number : numbers) {
			for (int i = 0; i < sortedList.size(); i++) {
				if (number < sortedList.get(i)) {
					sortedList.add(i, number);
					continue originalList;
				}
			}
			sortedList.add(sortedList.size(), number);
		}
		return sortedList;
	}

	public static void qSort(int[] numbers, int start, int end) {
		if (start < end) {
			int q = partition(numbers, start, end);
			qSort(numbers, start, q - 1);
			qSort(numbers, q + 1, end);
		}
	}

	public static int randomizedPartition(int[] numbers, int start, int end) {

		int p = r.nextInt(end - start + 1) + start;
		int temp = numbers[p];
		numbers[p] = numbers[end];
		numbers[end] = temp;
		return partition(numbers, start, end);
	}

	private static int partition(int[] numbers, int start, int end) {
		int i = start - 1;
		int pivot = numbers[end];
		for (int j = start; j <= end - 1; j++) {
			if (numbers[j] <= pivot) {
				int temp = numbers[++i];
				numbers[i] = numbers[j];
				numbers[j] = temp;
			}
		}
		int temp = numbers[++i];
		numbers[i] = numbers[end];
		numbers[end] = temp;
		return i;
	}

	public static List<Integer> qSort(List<Integer> numbers) {

		if (numbers.size() < 2) {
			return numbers;
		}
		int p = r.nextInt(numbers.size());
		final Integer pivot = numbers.get(p);
		final List<Integer> lower = new ArrayList<>();
		final List<Integer> higher = new ArrayList<>();
		for (int i = 0; i < numbers.size(); i++) {
			if (p != i) {
				if (numbers.get(i) < pivot) {
					lower.add(numbers.get(i));
				} else {
					higher.add(numbers.get(i));
				}
			}
		}
		final List<Integer> sorted = qSort(lower);
		sorted.add(pivot);
		sorted.addAll(qSort(higher));
		return sorted;
	}

	public static List<Integer> mergeSort(List<Integer> numbers) {
		if (numbers.size() < 2) {
			return numbers;
		}
		List<Integer> leftList = numbers.subList(0, numbers.size() / 2);
		List<Integer> rightList = numbers.subList(numbers.size() / 2,
				numbers.size());

		return merge(mergeSort(leftList), mergeSort(rightList));

	}

	private static List<Integer> merge(List<Integer> left, List<Integer> right) {
		int leftSize = left.size();
		int rightSize = right.size();
		final List<Integer> merged = new ArrayList<Integer>(leftSize
				+ rightSize);

		int leftIndex = 0;
		int rightIndex = 0;

		while (leftIndex < leftSize && rightIndex < rightSize) {
			int leftVal = left.get(leftIndex);
			int rightVal = right.get(rightIndex);
			if (leftVal > rightVal) {
				merged.add(rightVal);
				rightIndex++;
			} else {
				merged.add(leftVal);
				leftIndex++;
			}
		}

		while (leftIndex < leftSize) {
			merged.add(left.get(leftIndex++));
		}
		while (rightIndex < rightSize) {
			merged.add(right.get(rightIndex++));
		}

		return merged;
	}

	final static Random r = new Random();

	public static boolean binarySearch(List<Integer> numbers, int n) {
		int size = numbers.size();
		if (size < 1) {
			return false;
		} else if (size == 1) {
			return numbers.get(0) == n ? true : false;
		} else {
			if (numbers.get(size / 2) > n) {
				return binarySearch(numbers.subList(0, size / 2), n);
			} else if (numbers.get(size / 2) < n) {
				return binarySearch(numbers.subList(size / 2 + 1, size), n);
			} else
				return true;
		}

	}

	public static int binarySearchIndexed(int[] numbers, int n, int start,
			int end) {
		if (start > end) {
			return -1;
		}
		if (start == end && numbers[start] == n) {
			return start;
		}

		int size = end - start + 1;
		int middle = start + size / 2;
		if (numbers[middle] > n) {
			return binarySearchIndexed(numbers, n, start, middle - 1);
		} else if (numbers[middle] < n) {
			return binarySearchIndexed(numbers, n, middle + 1, end);
		} else {
			return middle;
		}

	}

}
