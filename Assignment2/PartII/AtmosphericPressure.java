
public class AtmosphericPressure {

	public static double getPressureDifference(double h0, double h1) {
		double e = Math.E;
		double ph0=(Math.log(0.88)/1000)*h0;
		double ph1=(Math.log(0.88)/1000)*h1;
		double pressureDifference=101.325*(Math.pow(e, ph1)-Math.pow(e,ph0));
		return pressureDifference;
	}
	
	public static void main(String[] args) {
		
		double h0=381;
		double h1=8848;
		
		double pressureDifference=getPressureDifference(h0,h1);
		
		//double e = Math.E; // this is e
		// Math.log(d) returns the natural log of d (ln d)
		
		// if the wind chill is valid:
		System.out.println("The difference in pressure between " + h0 + 
							"m and " + h1 + "m is " + pressureDifference + " kPal");
	}
}
