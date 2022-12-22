package arraylists;
import java.util.ArrayList;

import employees.*;

public class EmployeeArraylist {

	public static void main(String[] args) {
		// this ArrayList MUST be parameterized
		ArrayList<Employee> employeesArrayList=new ArrayList<Employee>();
		
		Employee e1=new Manager("John Smith",0,100000,0);
		Employee e2=new Manager("Bob Jones",0,80000,1);
	    Employee e3=new Manager("Raymond Jones",0,75000,1);
	    Employee e4=new HourlyEmployee("ABC",2,15,25);
	    Employee e5=new HourlyEmployee("XYZ",2,15,25);
	    Employee e6=new HourlyEmployee("Pooja",2,22,30);
	    Employee e7=new HourlyEmployee("Worship",2,22,30);
	    Employee e8=new IndividualContributor("CBA",1,55000,false);
	    Employee e9=new IndividualContributor("ZYX",1,55000,false);
	    Employee e10=new IndividualContributor("Ms.Patel",1,65000,true);
	    Employee e11=new IndividualContributor("Dean",1,65000,true);
	    
	   
	    employeesArrayList.add(e1);
	    employeesArrayList.add(e2);
	    employeesArrayList.add(e3);
	    employeesArrayList.add(e4);
	    employeesArrayList.add(e5);
	    employeesArrayList.add(e6);
	    employeesArrayList.add(e7);
	    employeesArrayList.add(e8);
	    employeesArrayList.add(e9);
	    employeesArrayList.add(e10);
	    employeesArrayList.add(e11);
	    
	    double sumofsalary=0;
	    int count=0;
	    for(int i=0;i<employeesArrayList.size();i++) {
	    	if(employeesArrayList.get(i) instanceof HourlyEmployee) {
	    		count++;
	    		HourlyEmployee he=(HourlyEmployee)employeesArrayList.get(i);
	    		sumofsalary+=he.getHourlyRate()*he.getWeeklyHours();
	    	}
	    }
	    double avg=sumofsalary/count;
	    System.out.println("The average salary of all the HourlyEmployee objects = "+avg);
	    
	    
		// this is the variable you should retain to compare
		// to the other objects in the arraylist
		HourlyEmployee fifteenAnHourTwentyFiveHoursEmployee=(HourlyEmployee)e4;
		for(int i=employeesArrayList.size()-1;i>=0;--i) {
			if(employeesArrayList.get(i) instanceof HourlyEmployee) {
				HourlyEmployee HE=(HourlyEmployee)employeesArrayList.get(i);
				if(HE==fifteenAnHourTwentyFiveHoursEmployee) {
					System.out.println("Same objects: "+HE.toString());
				}
				if(HE.equals(fifteenAnHourTwentyFiveHoursEmployee)) {
					System.out.println("Equal value:"+HE.toString());
					employeesArrayList.remove(i);
					System.out.println("Object with Equal value deleted!"); //e4 and e5 will delete
				}
			}
		}
		
		System.out.println("Remaining list:"); //there will be no e4 and e5
		for(int i=0;i<employeesArrayList.size();i++) {
			System.out.println(employeesArrayList.get(i));
		}
		
	}

}
