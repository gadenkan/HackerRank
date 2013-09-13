package helpmike;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int no = s.nextInt();

		for (int i = 0; i < no; i++) {
			int n = s.nextInt();
			int k = s.nextInt();
			long total = 0;
			// no. of paris is equal to (value-1)/2 until the highest. After that is falls down symmetrically
			for (int j = k; j <= (2 * n) - 1; j = j + k) {

				if (j <= (n + 1)) {
					total = total + (j - 1) / 2;
				} else {
					total = total + (2*n+1-j)/2;
				}
				System.out.println(total);
			}
			System.out.println(total);
		}

		s.close();
	}

}
