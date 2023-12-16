package org.jsp.hibernateDemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FindEmployeeById {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Employee id to display details");
		int eid = sc.nextInt();
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();) {
			Employee e = s.get(Employee.class, eid);
			if (e != null) {
				System.out.println("Employee id: " + e.getId());
				System.out.println("Employee name: " + e.getName());
				System.out.println("Phone Number: " + e.getPhone());
				System.out.println("Designation: " + e.getDesg());
				System.out.println("Salary: " + e.getSalary());
			} else {
				System.out.println("You have enterd an Invalid Id");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		sc.close();
	}

}
