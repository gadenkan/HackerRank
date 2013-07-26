package flowers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		List<Integer> c = new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			c.add(s.nextInt());
		}
		Collections.sort(c);
		
		
		int index=c.size()-1;
		long sum=0;
		int round=1;
		while(index>=0){
			
			for(int j=0;j<k && index>=0;j++){
				sum = sum+round*c.get(index);
				index--;
			}
			round++;
		}
		System.out.println(sum);
		s.close();
	}
}
