package org.jsp.AssignmentWork;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchTheIdByName {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name");
		String name = sc.next();
		String hql = "select e.id from Employee e where e.name=?1";
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();) {
			Query<Integer> q = s.createQuery(hql);
			q.setParameter(1, name);
			List<Integer> id = q.getResultList();
			if (id.size() > 0) {
				for (Integer ids : id) {
					System.out.println("Id's --> " + ids);
				}
			} else {
				System.out.println("Result not found for the " + name);
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		sc.close();
	}

}
