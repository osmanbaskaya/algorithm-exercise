package exposed;

public class Leaf<E extends Comparable> implements Tree<E> {
	@Override
	public boolean search(E toFind) {
		return false;
	}

	@Override
	public void insert(E toInsert) {
		// TODO Auto-generated method stub

	}
}