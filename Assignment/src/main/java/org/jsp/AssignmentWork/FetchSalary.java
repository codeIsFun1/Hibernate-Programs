package org.jsp.AssignmentWork;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchSalary {

	public static void main(String[] args) {
		String hql = "select e.salary from Employee e";
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();) {
			Query<Double> q = s.createQuery(hql);
			List<Double> sal = q.getResultList();
			for (Double salary : sal) {
				System.out.println(salary);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
