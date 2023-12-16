package org.jsp.AssignmentWork;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchTheNamesFromEmployee {

	public static void main(String[] args) {
		String hql = "select e.name from Employee e";
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();) {
			Query<String> q = s.createQuery(hql);
			List<String> names = q.getResultList();
			for (String name : names) {
				System.out.println(name);
			}
		} catch (Exception e) {
			System.err.println();
		}

	}

}
