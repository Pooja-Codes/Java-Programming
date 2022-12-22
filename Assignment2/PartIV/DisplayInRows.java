
public class DisplayInRows {

	static final int ROW_LENGTH = 10;
	
	public static void main(String[] args) {
		
		int[] intArray = new int[100];
		int counter=0;
		for (int i=0;i< intArray.length;i++) {
			intArray[i] = (int)(Math.random()*100);
			System.out.print(intArray[i]+" ");
			counter++;
			if(counter==20) {
				System.out.println();
				counter=0;
			}
		}
		
	}
}
