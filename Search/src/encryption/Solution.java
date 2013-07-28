package encryption;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.next();
		
		int a = (int) Math.ceil(Math.sqrt(str.length()));
		int b = (int) Math.ceil((str.length()/(double)a));
		int n = Math.max(a, b);
		int m = Math.min(a, b);
		for(int i=0;i<n;i++){
			for(int j=0;j<m && (i+(j*n)) < str.length();j++){
				System.out.print(str.charAt(i+(j*n)));
			}
			if(i!=n-1)
			System.out.print(" ");
		}
		s.close();
	}
}
