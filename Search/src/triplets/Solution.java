package triplets;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		int len = arr.length;
		int count = 0;
		List<String> sign = new ArrayList<String>();
		for (int i = 0; i < len; i++) {

			for (int j = i; j < len; j++) {

				if (arr[i] < arr[j]) {
					for (int k = j; k < len; k++) {

						if (arr[i] < arr[j] && arr[j] < arr[k]) {
							//System.out.println(i + " " + j + " " + k);
							String signTemp = "" + arr[i] + arr[j] + arr[k];
							if (!sign.contains(signTemp)) {
								count++;
								sign.add(signTemp);
							}
						}
					}
				}
			}
		}

		System.out.println(count);
		s.close();
	}

}
