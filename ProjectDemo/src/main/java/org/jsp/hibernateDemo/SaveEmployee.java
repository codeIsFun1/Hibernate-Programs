package org.jsp.hibernateDemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveEmployee {

	public static void main(String[] args) {
		Employee e = new Employee();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name");
		String nm = sc.nextLine();
		System.out.println("Enter Designation");
		String dg = sc.nextLine();
		System.out.println("Enter the Phone number");
		long ph = sc.nextLong();
		System.out.println("Enter the Salary");
		double sal = sc.nextDouble();
		System.out.println("Enter the password");
		String pass = sc.next();
		sc.nextLine();
		e.setName(nm);
		e.setDesg(dg);
		e.setPhone(ph);
		e.setSalary(sal);
		e.setPassword(pass);
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();) {
			int id = (int) s.save(e);
			Transaction t = s.beginTransaction();
			t.commit();
			System.out.println("User Saved with id -> " + id);
		} catch (Exception e2) {
			System.err.println(e2.getMessage());
		}

		sc.close();
	}

}
