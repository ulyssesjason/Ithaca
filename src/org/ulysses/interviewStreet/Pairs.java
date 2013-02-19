package org.ulysses.interviewStreet;

/* Enter your code here. Read input from STDIN. Print output to STDOUT
 Your class should be named Solution
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pairs {

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		int diff = 0;
		int pairs = 0;

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String s = br.readLine();
			int[] input = new int[2];
			input[0] = Integer.parseInt(s.split(" ")[0]);
			diff = Integer.parseInt(s.split(" ")[1]);

			String s2 = br.readLine();
			String[] array = s2.split(" ");

			for (int i = 0; i < array.length; i++) {
				list.add(Integer.parseInt(array[i]));
			}

			Collections.sort(list);
			Integer[] sortedArray = new Integer[input[0]];
			sortedArray = list.toArray(sortedArray);

			for (int i = 0; i < array.length - diff; i++) {
				for (int k = 0; k < diff; k++) {
					if(sortedArray[i+k+1]-sortedArray[i] == diff){
						pairs++;
						break;
					}
				}
			}

		} catch (Exception e) {
			System.err.println("Error:" + e.getMessage());
		}

		System.out.println(pairs);
	}

}
