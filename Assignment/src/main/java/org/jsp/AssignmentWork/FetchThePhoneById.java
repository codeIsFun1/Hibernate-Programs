package org.jsp.AssignmentWork;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchThePhoneById {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id");
		int id = sc.nextInt();
		String hql = "select e.phone from Employee e where e.id=?1";
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();) {
			Query<Long> q = s.createQuery(hql);
			q.setParameter(1, id);
			try {
				Long l = q.getSingleResult();
				System.out.println(l);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
