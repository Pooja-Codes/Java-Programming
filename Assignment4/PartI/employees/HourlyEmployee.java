package employees;

public class HourlyEmployee extends Employee{
	private double hourlyRate=0;
	private double weeklyHours=0;
	
	public HourlyEmployee() {
		
	}
	public HourlyEmployee(String name,int managerId, double hourlyRate,double weeklyHours) {
		super(name,managerId);
		this.hourlyRate=hourlyRate;
		this.weeklyHours=weeklyHours;
	}
	public double getHourlyRate() {
		return this.hourlyRate;
	}
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	public double getWeeklyHours() {
		return this.weeklyHours;
	}
	public void setWeeklyHours(double weeklyHours) {
		this.weeklyHours = weeklyHours;
	}
	public String toString() {
		return super.toString()+"Class:HourlyEmployee hourlyRate:"+this.hourlyRate+" weeklyHours:"+this.weeklyHours+"\n"; 
	}
	public boolean equals(Object obj) {
		if(super.equals(obj)) {
			if(obj instanceof HourlyEmployee) {
				HourlyEmployee he=(HourlyEmployee)obj;
				if(this.hourlyRate==he.hourlyRate && this.weeklyHours==he.weeklyHours){
					return true;
				}
			}
		}
		return false;
		
	}
}