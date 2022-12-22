import java.util.Arrays;

public class TwoDimensionalArray {

	public static void main(String[] args) {
		
		int[][] twoDimArray = new int[2][5];
		int[] arrayOne = {5, 9, 55, 23, 89};
		int[] arrayTwo = {15, 3, 23, 19, 64};
		
		/* copy arrayOne and arrayTwo into twoDimArray */
		/* print out the first list of 5 numbers in twoDimArray
		 * on one line, and the second list of 5 numbers in twoDimArray
		 * on the next line
		 */
		System.out.println(Arrays.toString(twoDimArray[0]));
		System.out.println(Arrays.toString(twoDimArray[1]));
		
		/* the solution should use nested loops: one loop to loop over
		 * each array in twoDimArray, and one loop to loop over each element
		 * in that array
		 */
		for (int row = 0; row < 2; row++) {
			for (int col = 0; col < arrayOne.length; col++) {
				if(row==0) {
					twoDimArray[row][col] = arrayOne[col];
				}
				else if(row==1){
					twoDimArray[row][col] = arrayTwo[col];
				}
			}
		}
		System.out.println(Arrays.toString(twoDimArray[0]));
		System.out.println(Arrays.toString(twoDimArray[1]));
		System.out.println("twoDimArray is " + Arrays.deepToString(twoDimArray));
	}
}
