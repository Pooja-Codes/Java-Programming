
public class FindIndex {

	public static void main(String[] args) {
		int[] intArray = {5, 3, 7, 10 , 15, 22, 60, 12, 45};
		int index=-1;
		for (int i=0; i<intArray.length;i++) {
			if (intArray[i]>20) {
				index=i;
				break;
			}
		}
		System.out.println("First Index grater than 20 is:"+index);

	}

}
