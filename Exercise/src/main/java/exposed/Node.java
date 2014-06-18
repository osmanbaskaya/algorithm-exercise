package exposed;

public class Node<E extends Comparable> implements Tree<E> {

	E value;
	Tree<E> left;
	Tree<E> right;

	@Override
	public boolean search(E toFind) {
		if (toFind.equals(value)) {
			return true;
		}
		if (toFind.compareTo(value) < 0) {
			return left.search(toFind);
		}
		return right.search(toFind);
	}

	@Override
	public void insert(E toInsert) {

	}
}