package median;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Solution {

	static int[] arr;
	static int size;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		arr = new int[x];
		for (int i = 0; i < x; i++) {
			char c = s.next().charAt(0);
			// Using Integer class solved the problem of list.remove(n)
			// confusion between index and object.
			Integer n = s.nextInt();
			// System.out.println((i+1)+" "+c+" "+n);
			if (c == 'r') {
				int in = searchForRemove(n);

				if (in != -1) {
					remove(n, in);
					if (size > 0) {
						printMedian();
					} else {
						System.out.println("Wrong!");
					}

				} else {
					System.out.println("Wrong!");
				}
			} else {
				add(n);
				printMedian();
			}
			// System.out.println();
		}

		s.close();
	}

	private static void add(Integer n) {

		int insIndex = search(n);
		// System.out
		// .println("insert index: " + insIndex + " insert number: " + n);
		if (size == 0) {
			arr[0] = n;
		} else {
			for (int i = size; i >= 0; i--) {

				if (i == insIndex) {
					arr[i] = n;
					break;
				} else {
					arr[i] = arr[i - 1];
				}
			}
		}
		size++;
		// System.out.print("[");
		// for (int i = 0; i < size; i++) {
		// System.out.print(" " + arr[i]);
		// }
		// System.out.println("]");

	}

	private static int searchForRemove(Integer n) {

		if (size == 0)
			return -1;

		int low = 0;
		int high = size - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (n < arr[mid])
				high = mid - 1;
			else if (n > arr[mid])
				low = mid + 1;
			else
				return mid;
		}
		return -1;
	}

	private static int search(Integer n) {

		if (size == 0)
			return -1;

		int low = 0;
		int high = size - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (n < arr[mid])
				high = mid - 1;
			else if (n > arr[mid])
				low = mid + 1;
			else
				return mid;
		}
		if (arr[low] > n)
			return low;
		else if (arr[high] > n)
			return high;
		else
			return high + 1;
	}

	private static void printMedian() {
		if (size % 2 != 0) {
			System.out.println(arr[size / 2]);
		} else {
			// System.out.println(size);
			long a = arr[(size / 2) - 1];
			long b = arr[size / 2];
			double c = (double) (a + b) / 2;
			if (c - (int) c == 0) {
				System.out.println((int) c);
			} else {
				System.out.println(new DecimalFormat("#.#").format(c));
			}
		}

	}

	private static void remove(Integer n, int remIndex) {

		for (int i = remIndex + 1; i < size; i++) {
			arr[i - 1] = arr[i];
		}
		size--;
		// System.out.print("[");
		// for (int i = 0; i < size; i++) {
		// System.out.print(" " + arr[i]);
		// }
		// System.out.println("]");

	}

}
