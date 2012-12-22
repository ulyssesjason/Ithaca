package org.ulysses.ithaca;

public class List extends DataStructure {
	private Node head;
	private Node tail;
	private int size;
	private Node iterator;

	public void clear() {
		head = null;
		tail = null;
		size = 0;
		iterator = null;
		tail = null;
	}

	public List() {
		clear();

	}

	public List(Object... objects) {
		for (Object o : objects) {
			this.append(o);
		}
	}

	public void append(Object object) {
		if (isEmpty()) {
			head = new Node(object);
			size = 1;
			iterator = head;
		} else if (!isBuilt()) {
			tail = new Node(object);
			size = 2;
			head.followBy(tail);
			tail.followBy(head);
			iterator = tail;
		} else {
			Node temp = new Node(object);
			tail.followBy(temp);
			temp.followBy(head);
			tail = temp;
			size++;
		}
	}

	// added a node after a known node(add_before function)
	public boolean insert(int index, Object object) {
		if (index < 0 || index > size - 1) {
			System.err.println("invalid index to insert");
			return false;
		}

		if (index == 0) {
			append(object);
			tail = tail.getPrevious();
			head = head.getPrevious();
		} else {
			Node temp = new Node(object);
			Node target = getNode(index);
			target.getPrevious().followBy(temp);
			temp.followBy(target);
			size++;
		}

		return true;
	}

	public boolean removeIndex(int index) {
		if (index < 0 || index > size - 1) {
			System.err.println("invalid index to remove");
			return false;
		}

		Node target = getNode(index);
		remove(target);

		return true;
	}

	private boolean remove(Node node) {
		if (node == null) {
			System.err.println("node is not existed");
			return false;
		} else if (size == 1) {
			clear();
			return true;
		}
		node.getPrevious().followBy(node.getNext());
		if (node == head)
			head = head.getNext();
		if (node == tail)
			tail = tail.getPrevious();
		size--;
		return true;
	}

	// remove first node whose data is object
	public boolean remove(Object object) {
		iterator = head;
		do {

			if (iterator.getData().equals(object)) {
				remove(iterator);
				return true;
			}
			iterator = iterator.getNext();
		} while (iterator != tail);

		if (tail.getData().equals(object))
			remove(tail);

		return false;
	}

	public boolean removeAll(Object object) {
		iterator = head;
		while (iterator != tail) {
			if (iterator.getData().equals(object)) {
				Node temp = new Node(iterator);
				iterator = temp.getNext();
				remove(temp);
			} else {
				iterator = iterator.getNext();
			}
		}
		if (tail.getData().equals(object))
			remove(tail);

		return true;
	}

	public Object get(int index) {
		return getNode(index).getData();
	}

	public void set(int index, Object object) {
		setNode(index, object);
	}

	private boolean setNode(int index, Object object) {
		if (index < 0 || index > size - 1) {
			System.out.println("invalid index to set");
			return false;
		}

		getNode(index).setData(object);

		return true;

	}

	private Node getNode(int index) {
		int track;
		if (index < (size - 1) / 2) {
			track = size - 1;
			iterator = tail;
			while (track != index) {
				iterator = iterator.getPrevious();
				track--;
			}

		} else {
			track = 0;
			iterator = head;
			while (track != index) {
				iterator = iterator.getNext();
				track++;
			}
		}

		return iterator;

	}

	public boolean isEmpty() {
		return head == null ? true : false;
	}

	public boolean isBuilt() {
		return tail == null ? false : true;
	}

	public int size() {
		return size;
	}

	public String toString() {
		if (isEmpty()) {
			return "";
		} else if (!isBuilt()) {
			return (head.toString());
		} else {
			iterator = head;
			StringBuffer sb = new StringBuffer("");

			while (iterator != tail) {
				sb.append(iterator.toString() + " ");
				iterator = iterator.getNext();
			}
			sb.append(tail.toString());
			return sb.toString();
		}

	}

	public void enqueue(Object object) {
		append(object);
	}

	public Object dequeue() {
		try {
			return dequeueNode().getData();
		} catch (Exception e) {
			return null;
		}
	}

	public Object pop() {

		try {
			return popNode().getData();
		} catch (Exception e) {
			return null;
		}
	}

	public void push(Object object) {
		append(object);
	}

	public Node Iterator() {
		return iterator;
	}

	public void reverse() {
		iterator = tail;
		while (iterator != head) {
			iterator.turn();
			iterator = iterator.getNext();
		}
		head.turn();
		Node temp = new Node();
		temp = tail;
		tail = head;
		head = temp;

	}

	private Node popNode() {
		if (isEmpty()) {
			System.err.println("List is Empty");
			return null;
		}

		if (!isBuilt()) {
			Node temp = new Node(head);
			clear();
			return temp;
		}

		Node temp = new Node(tail);
		remove(tail);

		return temp;
	}

	private Node dequeueNode() {
		if (isEmpty()) {
			System.err.println("List is Empty");
			return null;
		}

		Node temp = head;
		remove(head);
		return temp;
	}

	public boolean testList() {
		if (isEmpty()) {
			System.err.println("List is empty");
			return false;
		} else if (!isBuilt()) {
			System.out.println("Just one Node, header'data is : "
					+ head.getData().toString());
			return true;
		}

		Node tester = new Node();
		tester = head;

		// test the relationship of the list

		System.out.println("Test in order:");
		int index = 0;
		System.out.println("index is :" + index + " Data is :"
				+ tester.getData().toString());
		while (tester != tail) {
			tester = tester.getNext();
			index++;
			System.out.println("index is :" + index + " Data is :"
					+ tester.getData().toString());

		}

		// tester reverse order

		System.out.println("Test reverse order:");

		index = size - 1;
		System.out.println("index is : " + index + " Data is :"
				+ tester.getData().toString());
		while (tester != head) {
			tester = tester.getPrevious();
			index--;
			System.out.println("index is :" + index + " Data is :"
					+ tester.getData().toString());

		}

		System.out.println("head is " + head.getData().toString()
				+ " head's previous is "
				+ head.getPrevious().getData().toString());
		System.out.println("tail is " + tail.getData().toString()
				+ " tail's next is " + tail.getNext().getData().toString());

		return true;

	}

}
