package salary;

public class EmployeeFixedPayment extends Employee {

	protected double fixedPayment;

	public EmployeeFixedPayment(String firstName, String lastName, int id, double salary) {
		super(firstName, lastName, id);
		this.fixedPayment = salary;
	}

	public double getSalary() {
		return fixedPayment;
	}

	public void setSalary(double salary) {
		this.fixedPayment = salary;
	}

	@Override
	public double getMonthlySalary() {
		// TODO Auto-generated method stub
		
		return fixedPayment;
	}

}
