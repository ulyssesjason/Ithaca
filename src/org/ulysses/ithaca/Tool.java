package org.ulysses.ithaca;

public class Tool {
	
	public static long runningTime(Callback callback) {
		long start = System.currentTimeMillis();
		callback.execute();
		long end = System.currentTimeMillis();
		return (end - start) * 1000;
	}
	public static List intersection(List l1, List l2) {
		if (l1 == null || l2 == null)
			return null;

		List shortList = l1.size() > l2.size() ? l2 : l1;
		List longList = l1.size() > l2.size() ? l1 : l2;
		int length = l1.size() > l2.size() ? l2.size() : l1.size();

		if (l1.sorted() && l2.sorted()) {
			Node shortIterator = shortList.Iterator();
			Node longIterator = longList.Iterator();
			List res = new List();
			while (!shortList.reachEnd(shortIterator)
					&& !longList.reachEnd(longIterator)) {

				if (shortIterator.compareTo(longIterator) == 0) {

					res.append(shortIterator.getData());
					System.out.println("add " + shortIterator.toString());
					shortIterator = shortIterator.getNext();
					longIterator = longIterator.getNext();
				} else if (shortIterator.compareTo(longIterator) < 0) {
					shortIterator = shortIterator.getNext();

				} else {
					longIterator = longIterator.getNext();
				}
			}

			if (shortIterator.compareTo(longIterator) == 0) {
				res.append(shortIterator.getData());
			}

			return res;

		} else {
			for (int i = 0; i < length; i++) {
				if (!longList.contains(shortList.get(i)))
					shortList.remove(i);

			}

			return shortList;
		}

	}

	public static List Union(List l1, List l2) {
		if (l1 == null || l2 == null)
			return null;

		List shortList = l1.size() > l2.size() ? l2 : l1;
		List longList = l1.size() > l2.size() ? l1 : l2;
		int length = l1.size() > l2.size() ? l2.size() : l1.size();
		List res = new List();
		if (l1.sorted() && l2.sorted()) {
			Node shortIterator = shortList.Iterator();
			Node longIterator = longList.Iterator();

			while (!shortList.reachEnd(shortIterator)) {
				if (shortIterator.compareTo(longIterator) == 0) {
					res.append(shortIterator.getData());
					res.append(longIterator.getData());
					shortIterator = shortIterator.getNext();
					longIterator = longIterator.getNext();
				} else if (shortIterator.compareTo(longIterator) < 0) {
					res.append(shortIterator.getData());
					shortIterator = shortIterator.getNext();
				} else {
					res.append(longIterator.getData());
					longIterator = longIterator.getNext();
				}
			}
			res.append(shortIterator.getData());
			while (!longList.reachEnd(longIterator)) {
				res.append(longIterator.getData());
				longIterator = longIterator.getNext();
			}
			res.append(longIterator.getData());

		} else {
			for (int i = 0; i < length; i++) {

				res.append(shortList.get(i));

			}
			for (int j = 0; j < longList.size(); j++) {
				res.append(longList.get(j));
			}
		}

		return res;
	}

	public static Object[] sortedIntersection(Object[] a1, Object[] a2) {
		if (a1 == null || a2 == null)
			return null;

		int mark = 0;

		int shortlength = a1.length > a2.length ? a2.length : a1.length;
		Object[] shorter = a1.length > a2.length ? a2 : a1;
		Object[] longer = a1.length > a2.length ? a1 : a2;
		Object[] res = new Object[shortlength];

		for (int i = 0; i < shortlength; i++) {
			for (int j = mark; j < longer.length; j++) {
				if (longer[j] == shorter[i]) {
					mark = j;
					res[i] = shorter[i];
					break;
				}

			}
		}

		return res;

	}

	// weiss 3.6, m is step length, n is number of player
	public static Node Josephus(int m, int n) {
		List josephusLoop = new List();

		for (int i = 1; i < n + 1; i++) {
			josephusLoop.append(i);
		}
		Node josephusIterator = josephusLoop.Iterator();
		while (n > 1) {
			int s = m % n;// optimization 1: every time step is prime number of
							// n, and number of n is declining every time.

			if (s < n / 2) {// optimization 2: if step is bigger than half of n,
							// do going previous is reducing steps.
				for (int i = 0; i < s + 1; i++) {
					josephusIterator = josephusIterator.getNext();
				}
			} else {
				for (int i = 0; i < n - s - 1; i++) {
					josephusIterator = josephusIterator.getPrevious();
				}
			}

			System.out.println("removed : " + josephusIterator.getPrevious());
			josephusIterator.getPrevious().remove();
			n--;
		}
		return josephusIterator;

	}

	public static void detectedBalancedSymbol(String statement) {
		List list = new List();

		for (int i = 0; i < statement.length(); i++) {

		}
	}

	public boolean symbolMatch(char c1, char c2) {

		return false;

	}

}
