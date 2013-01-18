package org.ulysses.ithaca;

import java.util.Random;

public class Test {
	public static void main(String[] args) {

		final List list = new List(1, 2, 3, 5, 6, 5, 2, 32, 32, 434, 2, "a",
				"b", "c", "ee");
		final List list2 = new List(1, 2, 3, 7, 6, 8, 2, 32, 32, 434, 2);

		System.out.println(Tool.runningTime(new Callback() {

			@Override
			public void execute() {
				List list=new List();
				for(int i=0;i<100000;i++){
					list.append(i);
				}
				for(int i=0;i<99999;i++){
					Random random =new Random();
					
					list.remove(random.nextInt(100000));
				}
				System.out.println(list);
			}
		}));

	}

}

// use two stacks to simulate a queue
class Stack2Queue {
	List stack1 = new List();
	List stack2 = new List();

	public void enqueue(Object object) {
		stack1.push(object);
	}

	public Object dequeue() {
		if (stack2.isEmpty() && stack1.isEmpty())
			return null;

		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}

		return stack2.pop();
	}

}

// Use two queues to simulate a stack
class Queue2Stack {
	List queue1 = new List();
	List queue2 = new List();

	// Key is keep one queue always be empty, and new content is always enqueued
	// into empty one, then make other one empty
	public void push(Object object) {
		if (queue1.isEmpty()) {
			queue1.enqueue(object);
			while (!queue2.isEmpty())
				queue1.enqueue(queue2.dequeue());
		} else {
			queue2.enqueue(object);
			while (!queue1.isEmpty())
				queue2.enqueue(queue1.dequeue());
		}
	}

	public Object pop() {
		if (!queue1.isEmpty()) {
			return queue1.dequeue();
		} else {
			return queue2.dequeue();
		}

	}

}

// Weiss 3.30.a
class arraySelfAdjustList {
	private final static int capacity = 80000;
	private Object[] data;
	private int size;

	public arraySelfAdjustList() {
		data = new Object[capacity];
		size = 0;
	}

	public void insert(Object obj) {

		if (isFull())
			spaceExpand();

		if (isEmpty()) {
			data[0] = obj;
		} else {
			for (int i = size - 1; i >= 0; i--) {
				data[i + 1] = data[i];
			}
			data[0] = obj;

		}
		size++;

	}

	public Object find(Object obj) {
		if (isEmpty())
			return null;
		for (int i = 0; i < size; i++) {
			if (data[i].equals(obj)) {
				return shift2Head(i);
			}
		}

		return null;
	}

	private Object shift2Head(int index) {
		if (index >= size) {
			return null;
		} else {
			Object tmp = data[index];
			for (int i = index - 1; i >= 0; i--) {
				data[i + 1] = data[i];
			}
			data[0] = tmp;
			return data[0];
		}

	}

	private void spaceExpand() {
		Object[] temp = new Object[size * 2];
		for (int i = 0; i < size; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}

	public boolean isEmpty() {
		return size == 0 ? true : false;
	}

	public boolean isFull() {
		return (size % (capacity) == 0 && size > 0) ? true : false;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Object o : data) {
			if (o != null) {
				sb.append(o);
				sb.append("->");
			}

		}

		return sb.toString();
	}
}

// Weiss Chapter 3.30b
class llSelfAdjustList {
	List data;

	public llSelfAdjustList() {
		data = new List();
	}

	public void insert(Object obj) {
		if (data.isEmpty()) {
			data.append(obj);
		} else {
			data.insert(0, obj);
		}

	}

	public Object find(Object obj) {

		int i = data.search(obj);

		if (i != -1) {
			insert(obj);

			data.removeIndex(i + 1);
			return obj;
		} else {
			return null;
		}
		// The reason(of plus 1) is before removing
		// this one, the
		// whole list is actually one more node(node
		// is now in the head)

	}

	public String toString() {
		return data.toString();
	}
}
