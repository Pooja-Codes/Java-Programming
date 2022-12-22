package employees;

public class Inheritance {

	public static void main(String[] args) {
		// Here's some scratch space to experiment/debug your Employee objects
		// note-- do not use this particular class for anything. the intent
		// is to use this main method to write some scratch code.
		String HourlyEmp_name="Pooja";
		int HourlyEmp_managerId=3;
		double hourlyRate=27.50; //exception throw on <=7.25
		double weeklyHours=20;//exception throw on <0
		
		try {
			if (hourlyRate<=7.25) {
				throw new EmployeeException("hourlyRate must be greater than 7.25!");
			}
			else if (weeklyHours <0) {
				throw new EmployeeException("weeklyHours cannot be nagative!");
			}
			else {
				HourlyEmployee he= new HourlyEmployee(HourlyEmp_name,HourlyEmp_managerId,hourlyRate,weeklyHours);
				System.out.println("Successfully HourlyEmployee object created!");
				System.out.println(he);
			}
		}
		catch(EmployeeException e){
			System.out.println(e);
		}
		finally {
			System.out.println("------IN FINALLY-------");
		}
		
		String SalariedEmp_name="PQR";
		int SalariedEmp_managerId=3; 
		double SalariedEmp_annualSalary=12000;//exception throw on <=15080
		
		try {
			if (SalariedEmp_annualSalary<=15080) {
				throw new EmployeeException("annualSalary must be greater than 15080!");
			}
			else {
				SalariedEmployee se= new SalariedEmployee(SalariedEmp_name,SalariedEmp_managerId,SalariedEmp_annualSalary);
				System.out.println("Successfully SalariedEmployee object created!");
				System.out.println(se);
			}
		}
		catch(EmployeeException e){
			System.out.println(e);
		}
		finally {
			System.out.println("------IN FINALLY-------");
		}
		
		String Manager_name="ABC";
		int Manager_managerId=3;
		double Manager_annualSalary=25000;
		int executiveRank=9;//exception throw on <0
		try {
			if (executiveRank<0) {
				throw new EmployeeException("executiveRank cannot be negative!");
			}
			else {
				Manager m= new Manager(Manager_name,Manager_managerId,Manager_annualSalary,executiveRank);
				System.out.println("Successfully Manager object created!");
				System.out.println(m);
			}
		}
		catch(EmployeeException e){
			System.out.println(e);
		}
		finally {
			System.out.println("------IN FINALLY-------");
		}

	}

}
