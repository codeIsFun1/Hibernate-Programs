package org.jsp.AssignmentWork;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchThePhone {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name");
		String name = sc.next();
		String hql = "select e.phone from Employee e where e.name=?1";
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();) {
			Query<Long> q = s.createQuery(hql);
			q.setParameter(1, name);
			try {
				Long l = q.getSingleResult();
				System.out.println(l);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		sc.close();

	}
}
