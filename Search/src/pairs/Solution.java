package pairs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int count=0;
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<n;i++){
			list.add(s.nextInt());
		}
		Collections.sort(list);
		for(int i=0;i<list.size();i++){
			int temp = list.get(i);
			for(int j=i+1;j<list.size();j++){
				if(Math.abs(temp-list.get(j))>k){
					//list.remove(i);
					break;
				}else if(Math.abs(temp-list.get(j))==k){
					count++;
					break;
				}
			}
		}
		System.out.println(count);
		s.close();
	}
}
