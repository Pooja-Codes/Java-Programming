
public class DragCalculator {

	
	public static void main(String[] arguments) {
		double radius = 1.5;
		double rho = 1.2;
		double v0 = 15;
		double v1 = 25;
		double cd = 0.5;
		double pi = Math.PI;
		double A=pi*radius*radius;
		double dragDifference = (cd*(1/2.0)*rho*A)*(Math.pow(v1, 2)-Math.pow(v0, 2));
		 System.out.println("The object's change in drag force after velocity changes from "
		 		+ v0 +
		" m/s to " + v1 + " m/s is " + dragDifference + " N");
	}
}