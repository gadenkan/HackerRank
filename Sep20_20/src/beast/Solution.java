package beast;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {

			int digits = s.nextInt();
			int noOf5 = digits;
			int noOf3 = 0;
			boolean found = false;
			for (int j = digits; j >= 0; j = j - 5) {
				if (noOf5 % 3 == 0 && noOf3 % 5 == 0) {
					found = true;
					break;
				} else {
					noOf5 = noOf5 - 5;
					noOf3 = noOf3 + 5;
					;
				}
			}
			StringBuffer res = new StringBuffer("");
			if (found) {
				for (int m = 0; m < noOf5; m++) {
					res = res.append("5");
				}
				for (int m = 0; m < noOf3; m++) {
					res = res.append("3");
				}
			} else {
				res.append("-1");
			}
			System.out.println(res);
		}
		s.close();

	}

}
