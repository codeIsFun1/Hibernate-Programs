package org.jsp.AssignmentWork;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchDesignation {

	public static void main(String[] args) {
		String hql = "select e.desg from Employee e";
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();) {
			Query<String> q = s.createQuery(hql);
			List<String> desg = q.getResultList();
			for (String d : desg) {
				System.out.println(d);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
