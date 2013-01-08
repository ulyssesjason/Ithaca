package org.ulysses.ithaca;

public class Test {
	public static void main(String[] args) {
//		final List list = new List(1, 2, 3, 5, 6, 5, 2, 32, 32, 434, 2, "a",
//				"b", "c", "ee");
//		final List list2 = new List(1, 2, 3, 7, 6, 8, 2, 32, 32, 434, 2);

		System.out.println(runningTime(new Callback() {

			@Override
			public void execute() {

				List list = new List(1, 2, 3);
				List list2 = new List(1, 2);
				
				list.sort();
				list2.sort();

				List list3=Tool.intersection(list, list2);
				list3.testList();
			}
		}));

	}

	public static long runningTime(Callback callback) {
		long start = System.currentTimeMillis();
		callback.execute();
		long end = System.currentTimeMillis();
		return (end - start) * 1000;
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
