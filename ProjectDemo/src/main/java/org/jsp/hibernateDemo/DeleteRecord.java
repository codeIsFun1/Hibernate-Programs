package org.jsp.hibernateDemo;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteRecord {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id");
		int eid = sc.nextInt();
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();) {
			Employee e = s.get(Employee.class, eid);
			if (e != null) {
				s.delete(e);
				Transaction t = s.beginTransaction();
				t.commit();
				System.out.println("Deletion Completed!");
			} else {
				System.err.println("Id is invalid");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		sc.close();

	}

}
