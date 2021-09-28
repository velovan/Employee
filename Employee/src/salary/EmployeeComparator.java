package salary;

import java.util.Comparator;

public class EmployeeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {

		int salaryCompare = Double.compare(e2.getMonthlySalary(), e1.getMonthlySalary());
		if (salaryCompare != 0) {
			return salaryCompare;
		}

		return e1.getFirstName().compareTo(e2.firstName);
	}
}
