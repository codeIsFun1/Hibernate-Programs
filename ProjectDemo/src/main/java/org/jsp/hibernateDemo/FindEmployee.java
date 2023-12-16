package org.jsp.hibernateDemo;

import java.util.Scanner;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FindEmployee {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the employee id to display details");
		int eid = sc.nextInt();
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();) {
			Employee e = s.load(Employee.class, eid);
			try {
				System.out.println("Employee id -->" + e.getId());
				System.out.println("Employee name -->" + e.getName());
				System.out.println("Phone number -->" + e.getPhone());
				System.out.println("Designation -->" + e.getDesg());
				System.out.println("Salary -->" + e.getSalary());
			} catch (ObjectNotFoundException e2) {
				System.err.println(e2.getMessage());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		sc.close();
	}

}
