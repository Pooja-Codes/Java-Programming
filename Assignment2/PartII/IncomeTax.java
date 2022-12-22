import java.util.Scanner;

public class IncomeTax {

	public static float calculateTax(float income) {
		// this is really only valid for income greater than 0.
		// but for income less than 0, the tax will be 0.
		float tax=0;
		float diff0=9950*0.1f;
		float diff1=(40525-9950)*0.12f;
		float diff2=(86375-40525)*0.22f;
		float diff3=(164925-86375)*0.24f;
		float diff4=(209425-164926)*0.32f;
		float diff5=(523600-209426)*0.35f;
		
		if(income<0) {
			tax=0;
		}
		else if (income<=9950) {
			tax=income*0.1f;
		}
		else if(income<=40525) {
			tax=diff0+(income-9950)*0.12f;
		}
		else if(income<=86375) {
			tax=diff0+diff1+(income-40525)*0.22f;
		}
		else if(income<=164925) {
			tax=diff0+diff1+diff2+(income-86375)*0.24f;
		}
		else if(income<=209425) {
			tax=diff0+diff1+diff2+diff3+(income-164925)*0.32f;
		}
		else if(income<=523600) {
			tax=diff0+diff1+diff2+diff3+diff4+(income-209425)*0.35f;
		}
		else {
			tax=diff0+diff1+diff2+diff3+diff4+diff5+(income-523600)*0.37f;
		}
		return tax;
	}
	
	public static void main(String[] args) {
		
		/* you probably want to use user input for the
		 * income using Scanner because you will have to convert
		 * a command line argument to an float, and we haven't
		 * gotten to string parsing yet
		 * 
		 * But you can also just set the "income" variable
		 * to whatever you want in the code, and that's fine too
		 */
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an income: ");
		float income=input.nextFloat();

		float tax = calculateTax(income);
		
		// if the digits are greater than zero print this out:
		if(tax>0) {
			System.out.println("The income tax for the income " + income + " is " 
		+ tax);}
		else {
			System.out.println("negative tax value!");
		}
		
	}
}
