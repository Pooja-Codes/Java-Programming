package employees;

public class SalariedEmployee extends Employee{
	private double annualSalary=0;
	
	public SalariedEmployee() {
		
	}
	public SalariedEmployee(String name, int managerId, double annualSalary) {
		super(name,managerId);
		this.annualSalary=annualSalary;
	}
	public double getAnnualSalary() {
		return annualSalary;
	}
	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}
	public String toString() {
		return super.toString()+"Class:SalariedEmployee AnnualSalary:"+this.annualSalary+"\n";
	}
	public boolean equals(Object obj) {
		if(super.equals(obj)){
			if(obj instanceof SalariedEmployee) {
				SalariedEmployee se=(SalariedEmployee)obj;
				if(this.annualSalary==se.annualSalary) {
					return true;
				}
			}
		}
		return false;
	}
}