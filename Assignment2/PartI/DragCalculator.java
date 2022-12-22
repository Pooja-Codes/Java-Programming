
public class DragCalculator {

	public static double calculateDrag(double radius,double rho,double cd,double v0,double v1 ) {
		double pi = Math.PI;
		double A=pi*radius*radius;
		double dragDifference = (cd*(1/2.0)*rho*A)*(Math.pow(v1, 2)-Math.pow(v0, 2));
		return dragDifference;
	}
	
	public static void main(String[] args) {
		double radius = 1.5;
		double rho = 1.2;
		double cd = 0.5;
		double v0 = 15;
		double v1 = 25;
		double dragDifference=calculateDrag(radius,rho,cd,v0,v1);
		System.out.println("The object's change in drag force after velocity changes from "
		 		+ v0 +
		" m/s to " + v1 + " m/s is " + dragDifference + " N");
	}
}
