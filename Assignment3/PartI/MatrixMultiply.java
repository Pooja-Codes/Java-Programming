import java.util.Arrays;

public class MatrixMultiply {

	public static void main(String[] args) {
		
		double[][] matrix = { 
				{6, 4, 897, 23},
				{87, 346, 12, 7},
				{53, 75, 482, 3},
				{34, 473, 65, 2}
		};
		
		double[] vect = {5, 9, 55, 23};
		double[] result= {0,0,0,0};//(4X4 * 4X1 = 4X1 Dimensions)
		
		/* You are going to calculate matrix * vect,
		 * in the same way you'd calculate Ax as seen
		 * in the assignment description.
		 * Put the result in "result"
		 * If you understand your linear algebra
		 * well, you will already know what the dimensions
		 * of the "result" array should be and should
		 * be able to initialize it first.
		 */
		for (int i=0; i<matrix.length;i++) {
			double total=0;
			for(int j=0; j<vect.length;j++) {
				total+=matrix[i][j]*vect[j];
			}
			result[i]=total;
		}
		System.out.println("result is " + Arrays.toString(result));
	}
}
