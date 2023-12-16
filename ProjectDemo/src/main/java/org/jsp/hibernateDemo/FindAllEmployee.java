package org.jsp.hibernateDemo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;

public class FindAllEmployee {

	public static void main(String[] args) {
		String hql = "select emp from Employee emp";
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();) {
			Query<Employee> q = s.createQuery(hql);
			List<Employee> emps = q.getResultList();
			for (Employee e : emps) {
				System.out.println("Employee id -->" + e.getId());
				System.out.println("Employee name -->" + e.getName());
				System.out.println("Phone number -->" + e.getPhone());
				System.out.println("Designation -->" + e.getDesg());
				System.out.println("Salary -->" + e.getSalary());
				System.out.println("-----------------------------");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
