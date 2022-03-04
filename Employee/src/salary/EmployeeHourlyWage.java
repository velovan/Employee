package salary;

public class EmployeeHourlyWage extends Employee {

	protected double salaryWage;

	public EmployeeHourlyWage(String firstName, String lastName, int id, double salaryRate) {
	       super(firstName, lastName, id);
	       this.salaryWage = 20.8 * 8 * salaryRate;
	}

	public double getSalaryWage() {
	       return salaryWage;
	}

	public void setSalaryRate(double salaryRate) {
	       this.salaryWage = 20.8 * 8 * salaryRate;
	}

	@Override
	public double getMonthlySalary() {
	       return salaryWage * 20.8 * 8;
	}
}
