
/* You're going to sum up the numbers 0 to 200 but you are
 * going to skip any number divisible by 2. 
 */
public class SumZeroToTwoHundredSkipTwelves {

	public static void main(String[] args) {
		
		// you can use any kind of loop you want
		// have a counter that counts from 0 to 200
		
		int sum = 0;
		
		// the first loop has the structure of 
		// if (counter is  divisible by 2)
		// then
		//    sum += counter;
		for(int i=0;i<=200;i++) {
			if (i%2==0) {
				sum+=i;
			}
		}
		System.out.println("First loop ans: "+sum);
		sum = 0;
		// the second loop has the structure of:
		// if (counter is not divisible by 12)
		// then
		//  continue
		// and then it adds the counter to the sum if that condition does not execute
		for(int i=0;i<=200;i++) {
			if (i%12==0) {
				continue;
			}
			sum+=i;
		}
		System.out.print("Second loop ans: "+sum);
	}
}

