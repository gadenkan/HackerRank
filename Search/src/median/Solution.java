package median;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Solution {

	static int[] arr;
	static int size;
	static int start;
	static int end;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		arr = new int[2 * x];
		start = x;
		end = x;
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
			arr[start] = n;
		} else {

			if (insIndex > (end - start) / 2) {
				// insert from the end
				for (int i = end; i >= start; i--) {

					if (i == insIndex) {
						arr[i] = n;
						break;
					} else {
						arr[i] = arr[i - 1];
					}
				}
			} else {
				for (int i = start-1; i < end; i--) {

					if (i == insIndex) {
						arr[i] = n;
						break;
					} else {
						arr[i] = arr[i + 1];
					}
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

		int low = start;
		int high = end;
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

		int low = start;
		int high = end;
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
			return low-1;
		else if (arr[high] > n)
			return high;
		else
			return high + 1;
	}

	private static void printMedian() {
		if (size % 2 != 0) {
			System.out.println(arr[start+((end-start) / 2)]);
		} else {
			// System.out.println(size);
			long a = arr[start+((end-start) / 2) - 1];
			long b = arr[start+((end-start) / 2)];
			double c = (double) (a + b) / 2;
			if (c - (int) c == 0) {
				System.out.println((int) c);
			} else {
				System.out.println(new DecimalFormat("#.#").format(c));
			}
		}

	}

	private static void remove(Integer n, int remIndex) {

		boolean removed = false;
		for (int i = start; i < end; i++) {

			if (i == remIndex) {
				removed = true;
			} else {
				if (removed) {
					arr[i - 1] = arr[i];
				}
			}
		}
		size--;
		// System.out.print("[");
		// for (int i = 0; i < size; i++) {
		// System.out.print(" " + arr[i]);
		// }
		// System.out.println("]");

	}

}
