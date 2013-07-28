package redJohn;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Solution {

	static boolean[] isPrime;
	static long previousY;

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		long x = s.nextInt();
		HashMap<Long, Long> primeMap = new LinkedHashMap<Long, Long>();
		HashMap<Long, Long> numberMap = new LinkedHashMap<Long, Long>();

		isPrime = new boolean[176142314];

		isPrime[0] = true;
		isPrime[1] = true;

		for (long i = 0; i < x; i++) {
			long n = s.nextInt();

			if (numberMap.containsKey(n)) {
				System.out.println(numberMap.get(n));
				continue;
			}
			long a = n - 3; // no of bits involved initially
			long b = n / 4; // no of 1's involved
			long y = 1;
			if (n % 4 == 0) {
				b = b - 1;
			}
			for (long k = 0; k < b; k++) {

				long num = 1;
				long den = 1;
				long z = a-(3*k);
				//System.out.println("z="+z);
				for (int g = 0; g <= k; g++) {
					long z2 = z-g;
					num = num * (z2);
					den = den * (g + 1);
					//System.out.println(num+" - "+den);
				}
				//System.out.println(num+" / "+den+" for k="+k);
				y = y + num/den;
			}
			if (n % 4 == 0) {
				y = y + 1;
			}
			//System.out.println("y-" + y);

			long count = 0;
			if (!primeMap.containsKey(y)) {

				for (long j = 2; j * j <= y; j++) {

					if (!isPrime[(int) j]) {
						for (long o = j; j * o <= y; o++) {
							isPrime[(int) (j * o)] = true;
						}
					}
				}
				previousY = y;
				// System.out.println(y);
				for (long l = 2; l <= y; l++) {
					if (!isPrime[(int) l]) {
						 //System.out.print(l + " ");
						count++;
					}
				}
				primeMap.put(y, count);
				numberMap.put(n, count);
			} else {
				count = primeMap.get(y);
			}
			// System.out.println();
			System.out.println(count);
		}

		s.close();
	}
}
