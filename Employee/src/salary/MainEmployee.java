package salary;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class MainEmployee {

	
	public static void main(String[] args) throws FileNotFoundException {

		List<Employee> coll = new ArrayList<Employee>();

		EmployeeHourlyWage a = new EmployeeHourlyWage("Edd", "Goo", 23, 4);
		EmployeeHourlyWage b = new EmployeeHourlyWage("Tedd", "Foo", 2, 7);
		EmployeeHourlyWage c = new EmployeeHourlyWage("Bob", "Bee", 4, 2);
		EmployeeHourlyWage d = new EmployeeHourlyWage("Kate", "See", 5, 5);
		EmployeeFixedPayment e = new EmployeeFixedPayment("Lisa", "Lee", 7, 500);
		EmployeeFixedPayment f = new EmployeeFixedPayment("Mike", "Ree", 10, 450);
		EmployeeFixedPayment g = new EmployeeFixedPayment("Izia", "Kurz", 13, 1000);
		EmployeeFixedPayment j = new EmployeeFixedPayment("Aisha", "Moore", 20, 800);
		EmployeeFixedPayment k = new EmployeeFixedPayment("SUPER", "VOL", 9, 220);

		coll.add(a);
		coll.add(b);
		coll.add(c);
		coll.add(d);
		coll.add(e);
		coll.add(f);
		coll.add(g);
		coll.add(j);
		coll.add(k);

		Collections.sort(coll, new EmployeeComparator());

		for (Employee emp : coll) {
			System.out.println("First Name: " + emp.getFirstName() + "," + " Last Name: " + emp.getLastName() + ","
					+ " ID: " + emp.getId() + "," + "Salary: " + emp.getMonthlySalary());
		}
  
		Writer writer = null;
		try { 
			writer = new FileWriter("journal.txt");
			for (Employee emp : coll) {
				writer.write(emp.getFirstName() + " | ");
				writer.write(emp.getLastName() + " | ");
				writer.write(Integer.toString(emp.getId()) + " | ");
				writer.write(Integer.toString((int) emp.getMonthlySalary()) + " | ");
			 
				writer.write(System.getProperty("line.separator"));
			}
			writer.flush();
		} catch (Exception e1) {
			Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, e1);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException ex) {
				}
			}
		}
		
		readerFileArr1();
	}

	public static void readerFileArr1() {
		try {
			String[] rows = new Scanner(new File("journal.txt")).useDelimiter("\\Z").next().split("\n");
			for (String s : rows) {
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			// e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Файл не знайдено !!!");
		}
	}
}
