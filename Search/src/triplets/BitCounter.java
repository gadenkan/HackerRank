package triplets;

public class BitCounter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int count=1;
		for(int i=0;i<256;i++){
			if(Integer.bitCount(i)==1 || Integer.bitCount(i)==2){
				System.out.println((count++)+" \t"+i+" \t"+Integer.toBinaryString(i));
			}
			
		}
	}

}
