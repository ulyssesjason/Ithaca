package org.ulysses.ithaca;

public class Tool {
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
			while (!shortList.reachEnd() && !longList.reachEnd()) {
				System.out.println("short is "+shortIterator.toString());
				System.out.println("long is "+longIterator.toString());
				System.out.println("short reach end "+shortList.reachEnd());
				System.out.println("long reach end "+longList.reachEnd());
				System.out.println("res is "+res.toString());
				if (shortIterator.getData() == longIterator.getData()) {

					res.append(shortIterator.getData());
					shortIterator = shortIterator.getNext();
					longIterator = longIterator.getNext();
				} else if (shortIterator.compareTo(longIterator) < 0) {
					shortIterator = shortIterator.getNext();

				} else {
					longIterator = longIterator.getNext();
				}
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
}
