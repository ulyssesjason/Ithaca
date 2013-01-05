package org.ulysses.ithaca;

public class Tool {
	public static List intersect(List l1, List l2) {
		if (l1 == null || l2 == null)
			return null;

		List shortList = l1.size() > l2.size() ? l2 : l1;
		List longList = l1.size() > l2.size() ? l1 : l2;
		int length = l1.size() > l2.size() ? l2.size() : l1.size();

		if (l1.sorted() && l2.sorted()) {
			int mark = 0;
			for(int i=0;i<length;i++){
				
			}

		} else {
			for (int i = 0; i < length; i++) {
				if (!longList.contains(shortList.get(i)))
					shortList.remove(i);

			}
		}

		return shortList;

	}
}
