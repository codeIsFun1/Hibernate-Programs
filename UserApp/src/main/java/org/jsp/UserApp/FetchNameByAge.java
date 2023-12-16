package org.jsp.UserApp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchNameByAge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Age");
		int age = sc.nextInt();
		String hql = "select u.name from User u where u.age=?1";
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();){
		Query<String> q = s.createQuery(hql);
		q.setParameter(1, age);
		List<String> l = q.getResultList();
		if (l.size() > 0) {
			System.out.println("--------Names--------");
			for (String user : l) {
				System.out.println(user);
			}
		} else {
			System.err.println("Invalid Age");
		}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		sc.close();
	}

}
