package employees;
public class Employee {
	private String name="";
	private int managerId=0;
	private static int next_id=0;
	private int id=++next_id;
	
	public Employee(){
		
	}
	public Employee(String name,int managerId){
		this.name=name;
		this.managerId=managerId;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getManagerId() {
		return this.managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId=managerId;
	}
	public int getId() {
		return this.id;
	}
	public String toString() {
		return "Class:Employee ID:"+this.id+" Name:"+this.name+" ManagerID:"+this.managerId+"\n";
	}
	public boolean equals(Object obj) {
		if(this==obj)return true;
		if (obj instanceof Employee) {
			Employee emp=(Employee)obj;
			if(this.managerId==emp.managerId) {
					return true;
			}
		}
		return false;
		
	}
}