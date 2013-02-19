package org.ulysses.interviewStreet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Triplets {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		List<String> resList = new ArrayList<String>();
		int res = 0;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String s = br.readLine();
			int count = Integer.parseInt(s);

			String s2 = br.readLine();
			String[] array = s2.split(" ");

			for (int i = 0; i < count; i++) {
				int temp = Integer.parseInt(array[i]);
				list.add(temp);
			}

			Stack<Integer> store = new Stack<Integer>();
			for (int t = 0; t < count; t++) {
				int i = t;
				store.removeAllElements();
				while (i < count) {
					int item = list.get(i);

					switch (store.size()) {
					case 0:
						store.push(item);
						i++;
						break;
					case 1:
						if (item > store.peek()) {
							store.push(item);
						}
						i++;
						break;
					case 2:
						if (item > store.peek()) {
							store.push(item);
							if (!resList.contains(store.toString())) {
								resList.add(store.toString());
								res++;
							}
							store.pop();
						}
						i++;
						break;
					default:
						break;
					}

				}
			}

		} catch (Exception e) {
			System.err.println("Error:" + e.getMessage());
		}
		System.out.println(res);
	}

}
