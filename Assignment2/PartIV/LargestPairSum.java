
public class LargestPairSum {

	public static void main(String[] args) {
		
		int[] intArray = {17, 1, 3, 12, 39, 4, 76, 4, 31, 87};
		int sum = -1;
		
		for(int i=0;i<intArray.length-1;i++) {
			for(int j=i+1;j<intArray.length;j++) {
				int currentsum=intArray[i]+intArray[j];
				if(currentsum>sum) {
					sum=currentsum;
				}
			}
		}
		
		System.out.println("Maximum sum of all pairs in the array: " +
							sum);
	}
}
