package employees;

public class Inheritance {

	public static void main(String[] args) {
		// Here's some scratch space to experiment/debug your Employee objects
		// note-- do not use this particular class for anything. the intent
		// is to use this main method to write some scratch code.
		Employee empone=new Employee("Pooja",1);
		System.out.println(empone);
		System.out.println("-------------");
		HourlyEmployee he= new HourlyEmployee("XYZ",3,27.50,20);
		System.out.println(he);
		System.out.println("-------------");
		SalariedEmployee se=new SalariedEmployee("PQR",4,40);
		System.out.println(se);
		System.out.println("-------------");
		IndividualContributor ic=new IndividualContributor("STU",7,80,true);
		System.out.println(ic);
		System.out.println("-------------");
		Manager man=new Manager();
		System.out.println(man);
		System.out.println("-------------");
	}

}
