package employees;

public class Manager extends SalariedEmployee{
	private int executiveRank=0;
	public Manager() {
		
	}
	public Manager(String name,int managerId,double annualSalary, int executiveRank) {
		super(name,managerId,annualSalary);
		this.executiveRank=executiveRank;
	}
	public int getExecutiveRank() {
		return this.executiveRank;
	}
	public void setExecutiveRank(int executiveRank) {
		this.executiveRank=executiveRank;
	}
	public String toString() {
		return super.toString()+"Class:Manager ExecutiveRank:"+this.executiveRank;
	}
	public boolean equals(Object obj) {
		if(super.equals(obj)) {
			if(obj instanceof Manager) {
				Manager man=(Manager)obj;
				if(this.executiveRank==man.executiveRank) {
					return true;
				}
			}
		}
		return false;
	}
}