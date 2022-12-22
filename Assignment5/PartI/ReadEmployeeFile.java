import java.io.*;
import java.util.ArrayList;
import employees.*;

/* your tasks:
 * create a class called EmployeeException
 * createEmployee should throw a EmployeeException
 * in main(), you should catch the EmployeeException
 * 
 */
public class ReadEmployeeFile {

	public static Employee createEmployee(String inString) {
		/* if employee Name is "IndividualContributor" an IndividualContributor 
		 * if employee Name is "HourlyEmployee" return ad HourlyEmployee
		 * if employee Name is "Manager" return a Manager;
		 * if it is not any one of these, it should throw
		 * an EmployeeException
		 */
		String [] emp = inString.split(",");
		if(emp[0].equals("Manager")) {
			Manager Manager = new Manager(emp[1],Integer.parseInt(emp[2]),
					Double.parseDouble(emp[3]),Integer.parseInt(emp[4]));			
			return Manager; 
		}
		if(emp[0].equals("HourlyEmployee")) {
			HourlyEmployee HourlyEmployee = new HourlyEmployee(emp[1],Integer.parseInt(emp[2]),
					Double.parseDouble(emp[3]),Integer.parseInt(emp[4]));			
			return HourlyEmployee; 
		}
		if(emp[0].equals("IndividualContributor")) {
			IndividualContributor IndividualContributor = new IndividualContributor(emp[1],
					Integer.parseInt(emp[2]),Double.parseDouble(emp[3]),Boolean.parseBoolean(emp[4]));			
			return IndividualContributor; 
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		File f = new File("employees.txt");
		
		String inString = null;
		/* create a loop to read the file line-by-line */
		FileReader fr = null;
		try 
		{
			fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			inString = br.readLine();
			while(inString != null) 
			{
				String [] emp = inString.split(",");
				try
				{
					if(emp[0].equals("Manager") || emp[0].equals("HourlyEmployee") || emp[0].equals("IndividualContributor")) {
						Employee employee = createEmployee(inString);
						employeeList.add(employee);
					}
					else {
						throw new EmployeeException(inString);
					}
				}catch (EmployeeException e ) 
				{
					System.err.println("Cannot create Employee: "+inString+"--By EmployeeException");
				}	
				
				inString = br.readLine();
			}
		} 
		catch (Exception e ) 
		{
			System.err.println(e);
		}

		System.out.println(employeeList + "" + employeeList.size());//17 count
		
	}
}