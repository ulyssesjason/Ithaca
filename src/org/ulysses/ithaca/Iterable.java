package org.ulysses.ithaca;

public interface Iterable {
	boolean hasPrevious();
	boolean hasNext();
	Node getNext();
	void remove();
}
