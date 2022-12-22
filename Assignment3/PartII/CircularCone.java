
public class CircularCone {
	private static int nextId;
	private int id=++nextId;
	private double radius=0;
	private double height=0;
	
	public CircularCone() {
	}
	public CircularCone(double radius,double height){
		this.radius=radius;
		this.height=height;
	}
	public double getRadius() {
		return this.radius;
	}
	public void setRadius(double radius) {
		this.radius=radius;
	}
	public double getHeight() {
		return this.height;
	}
	public void setHeight(double height) {
		this.height=height;
	}
	public double getSlant() {
		return Math.sqrt(Math.pow(this.height,2)+Math.pow(this.radius,2));
	}
	public double getVolume() {
		return Math.PI*Math.pow(this.radius,2)*(this.height/3);
	}
	public double getArea() {
		return Math.PI*this.radius*(this.radius+Math.sqrt(Math.pow(this.height,2)+Math.pow(this.radius,2)));
	}
	public int getID() {
		return this.id;
	}
}

