import java.util.Scanner;

public class LoopSum {

	public static int sum200() {
		int sum=0;
		for(int i=1;i<=200;i++) {
			if (i%5==0) {
				sum+=i;
			}
		}
		return sum;
	}
	
	public static int sumNX() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter N:");
		int N=input.nextInt();
		System.out.print("Enter X:");
		int X=input.nextInt();
		int sum=0;
		for(int i=1;i<=N;i++) {
			if (i%X==0) {
				sum+=i;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println("Answer of sum200: "+sum200());
		System.out.println("Answer of sumNX: "+sumNX());
		
	}
	
}
