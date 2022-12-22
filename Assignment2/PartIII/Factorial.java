import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("Enter value:");
		int val = input.nextInt();
		
		int output=1;
		while (val>1) {
			output*=val;
			val-=1;
		}
		System.out.println("Factorial of "+val+" is: "+output);
		
	}
}
