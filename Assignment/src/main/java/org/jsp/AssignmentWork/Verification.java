package org.jsp.AssignmentWork;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Verification {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Id and Password of Employee");
		int id = sc.nextInt();
		String password = sc.next();
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();) {
			Query<Employee> q = s.createQuery("select e from Employee e where e.id=?1 and e.password=?2");
			q.setParameter(1, id);
			q.setParameter(2, password);
			try {
				Employee e = q.getSingleResult();
				System.out.println("Employee is Verified");
				System.out.println("********Details********");
				System.out.println("Employee id -->" + e.getId());
				System.out.println("Employee name -->" + e.getName());
				System.out.println("Phone number -->" + e.getPhone());
				System.out.println("Designation -->" + e.getDesg());
				System.out.println("Salary -->" + e.getSalary());

			} catch (NoResultException e) {
				System.err.println("No Records is present with this:" + id + " and this:" + password);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		sc.close();
	}

}
