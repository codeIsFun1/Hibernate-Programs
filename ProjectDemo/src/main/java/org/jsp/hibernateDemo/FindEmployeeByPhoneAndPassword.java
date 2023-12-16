package org.jsp.hibernateDemo;

import java.util.Scanner;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindEmployeeByPhoneAndPassword {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Employee phone number and password to verify employee");
		long phone = sc.nextLong();
		String password = sc.next();
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();) {
			Query<Employee> q = s.createQuery("Select e from Employee e where e.phone=?1 and e.password=?2");
			q.setParameter(1, phone);
			q.setParameter(2, password);
			try {
				Employee e = q.getSingleResult();
				System.out.println("Verification Successfull");
			} catch (NoResultException e) {
				System.err.println("Invalid Phone Number or Password");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		sc.close();
	}

}
