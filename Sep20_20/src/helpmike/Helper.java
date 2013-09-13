package helpmike;

import java.util.HashMap;

public class Helper {
	public static void main(String[] args) {


		// no. of paris is equal to (value-1)/2 until the highest. After that is falls down symmetrically
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=1;i<=101;i++){
			
			for(int j=i+1;j<=101;j++){
				
				if(map.containsKey(i+j)){
					int temp = map.get(i+j);
					map.put(i+j, temp+1);
				}else{
					map.put(i+j, 1);
				}
			}
				
		}
		System.out.println(map);
	}

}
