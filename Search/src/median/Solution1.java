package median;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < x; i++) {
			char c = s.next().charAt(0);
			// Using Integer class solved the problem of list.remove(n)
			// confusion between index and object.
			Integer n = s.nextInt();
			if (c == 'r') {
				if (list.contains(n)) {
					list.remove(n);
					if (list.size() > 0) {
						printMedian(list);
					} else {
						System.out.println("Wrong!");
					}

				} else {
					System.out.println("Wrong!");
				}
			} else {
				boolean done=false;
				for(int j=0;j<list.size();j++){
					if(list.get(j)>=n){
						list.add(j,n);
						done=true;
						break;
					}
				}
				if(!done)
					list.add(n);
				printMedian(list);
			}
		}

		s.close();
	}

	private static void printMedian(List<Integer> list) {
		//Collections.sort(list);
		if (list.size() % 2 != 0) {
			System.out.println(list.get(list.size() / 2));
		} else {
			long a = list.get(list.size() / 2 - 1);
			long b = list.get(list.size() / 2);
			double c = (double) (a + b) / 2;
			if (c - (int) c == 0) {
				System.out.println((int) c);
			} else {
				System.out.println(new DecimalFormat("#.#").format(c));
			}
		}
	}

}
