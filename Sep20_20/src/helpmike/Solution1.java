package helpmike;

import java.util.Scanner;

public class Solution1 {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int no = s.nextInt();
		
		for(int i=0;i<no;i++){
			int n = s.nextInt();
			int k = s.nextInt();
			long total=0;
			for(int j=1;j<=n;j++){
				int l = j+1;
				for(;l<=n;l++){
					if((j+l)%k==0){
						int temp=1 + (n-l)/k;

						total = total + temp;
						System.out.println("j:"+j+" l:"+l+" temp:"+temp+" total:"+total);
						
						break;
					}
				}
				//System.out.println(l);
				
			}
			

			System.out.println(total);
		}
		s.close();
	}

}
