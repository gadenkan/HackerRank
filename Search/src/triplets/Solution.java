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
		int[][] grArr = new int[len][len];
 		for(int i=0;i<len;i++){
 			for(int j=0;j<len;j++){
 				grArr[i][j] = -1;
 			}
 		}
 		
 		int[] greaterCountArr = new int[len];
 		
 		int greaterCount=0;
		int tempIndex=0;
 		for(int i=0;i<len;i++){
 			if(arr[i]>arr[0]){
 				greaterCount++;
 				grArr[0][tempIndex++]=i;
 			}
 		}
 		greaterCountArr[0]=greaterCount;
 		
		for(int i=1;i<len;i++){
		
			if(arr[i] == arr[i-1]){
				continue;
			}
			greaterCount=0;
			tempIndex=0;
			for(int j=i+1;j<len;j++){
				
				if(arr[j] == arr[j-1]){
					continue;
				}
				//System.out.println(arr[j] + " "+arr[j-1]);
				if(arr[j]>arr[i]){
					greaterCount++;
					grArr[i][tempIndex++]=j;
				}
			}
			greaterCountArr[i] = greaterCount;
		}
		
		for(int i=0;i<len;i++){
			System.out.print(i+" "+greaterCountArr[i]+" - ");
			int tempLen = greaterCountArr[i];
			for(int j=0;j<tempLen;j++){
				System.out.print(" "+grArr[i][j]);
			}
			System.out.println();
		}
		
		
		
		
		
		int sum=0;
		for(int i=0;i<len;i++){
			int tempLen=greaterCountArr[i];
			
			for(int j=0;j<tempLen;j++){
				
				sum = sum + greaterCountArr[grArr[i][j]];
			}
			System.out.println("Intermediate sum: "+sum);
		}
		
		System.out.println(sum);
		s.close();
		
	}

}
