package org.jsp.AssignmentWork;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchDataOfEmployeeByName {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Name of Employee");
		String name = sc.next();
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();) {
			Query<Employee> q = s.createQuery("select e from Employee e where e.name=?1");
			q.setParameter(1, name);
			List<Employee> emps = q.getResultList();
			if (emps.size() > 0) {
				for (Employee e : emps) {
					System.out.println("Employee id -->" + e.getId());
					System.out.println("Employee name -->" + e.getName());
					System.out.println("Phone number -->" + e.getPhone());
					System.out.println("Designation -->" + e.getDesg());
					System.out.println("Salary -->" + e.getSalary());
					System.out.println("----------------------");
				}
			} else {
				System.out.println("No employee with the name:" + name);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		sc.close();
	}

}
