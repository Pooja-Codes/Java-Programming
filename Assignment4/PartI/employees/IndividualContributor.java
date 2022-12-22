package employees;

public class IndividualContributor extends SalariedEmployee{
	private boolean senior=false;
	public IndividualContributor() {
		
	}
	public IndividualContributor(String name,int managerId,double annualSalary,boolean senior){
		super(name,managerId,annualSalary);
		this.senior=senior;
	}
	public boolean isSenior() {
		return this.senior;
	}
	public void setSenior(boolean senior) {
		this.senior=senior;
	}
	public String toString() {
		return super.toString()+"Class:IndividualContributor Senior:"+(this.senior?"Yes":"No");
	}
	public boolean equals(Object obj) {
		if(super.equals(obj)) {
			if(obj instanceof IndividualContributor) {
				IndividualContributor ic=(IndividualContributor)obj;
				if(this.senior==ic.senior) {
					return true;
				}
			}
		}
		return false;
	}
	
}