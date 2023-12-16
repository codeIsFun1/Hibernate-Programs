package org.jsp.hibernateDemo;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindEmployeeByPhone {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the employee Phone number to display details");
		long phone = sc.nextLong();
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();) {
			Query<Employee> q = s.createQuery("select e from Employee e where e.phone=:ph");
			q.setParameter("ph", phone);
			try {
				Employee e = q.getSingleResult();
				System.out.println("Employee id -->" + e.getId());
				System.out.println("Employee name -->" + e.getName());
				System.out.println("Phone number -->" + e.getPhone());
				System.out.println("Designation -->" + e.getDesg());
				System.out.println("Salary -->" + e.getSalary());
				System.out.println("----------------------");
			} catch (NoResultException e) {
				System.out.println("No Employee with the Phone Number");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		sc.close();
	}

}
