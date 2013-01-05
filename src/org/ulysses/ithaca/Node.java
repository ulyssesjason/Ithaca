package org.ulysses.ithaca;

public class Node implements Iterable, Comparable {
	private Object data;
	private Node next;
	private Node previous;

	public Node() {
		clear();
	}

	public Node(Node node) {
		clear();
		data = node.getData();
		next = node.getNext();
		previous = node.getPrevious();
	}

	private void clear() {
		data = null;
		next = null;
		previous = null;
	}

	public Node(Object data) {
		clear();
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return previous == null ? false : true;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return next == null ? false : true;
	}

	@Override
	public Node getNext() {
		// TODO Auto-generated method stub
		return next;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		if (hasPrevious() && hasNext()) {
			previous.setNext(this.getNext());
			next.setPrevious(this.getPrevious());

		} else if (hasPrevious()) {
			previous.setNext(null);

		} else if (hasNext()) {
			next.setPrevious(null);

		} else {

		}

		clear();
	}

	public void followBy(Node node) {
		this.setNext(node);
		node.setPrevious(this);
	}

	// change the sequence between this node and next node.
	public void turn() {
		if (this.next != null) {
			Node temp = new Node();
			temp = this.getNext();
			this.setNext(this.getPrevious());
			this.setPrevious(temp);
		}

	}

	public String toString() {
		return data.toString();
	}

	@Override
	public int compareTo(Object o) {

		if (o instanceof Node) {
			// Use getclass to determine if two object belongs to same comparable class
			if (((Node) o).getData() instanceof Comparable
					&& (data.getClass() == ((Node) o).getData().getClass())) {

				Comparable target = (Comparable) ((Node) o).getData();
				return -target.compareTo(data);

			} else {
				return data.toString().charAt(0) > ((Node) o).getData()
						.toString().charAt(0) ? 1 : -1;
			}
		} else {
			return -1;
		}

	}

}
