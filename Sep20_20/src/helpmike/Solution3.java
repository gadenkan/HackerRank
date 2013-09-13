package helpmike;

import java.util.Scanner;

public class Solution3 {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int no = s.nextInt();

		for (int i = 0; i < no; i++) {
			int n = s.nextInt();
			int k = s.nextInt();
			long total = 0;
			int temp = n/k;
			total = (2*(temp*temp))+temp;
			System.out.println(total);
		}
		s.close();
	}

}
