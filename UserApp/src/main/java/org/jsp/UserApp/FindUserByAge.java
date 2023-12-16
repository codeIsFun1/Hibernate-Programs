package org.jsp.UserApp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindUserByAge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Age");
		int age = sc.nextInt();
		String hql = "select u from User u where age=?1";
		try {
			Session s = new Configuration().configure().buildSessionFactory().openSession();
		Query<User> q = s.createQuery(hql);
		q.setParameter(1, age);
		List<User> l = q.getResultList();
		if (l.size() > 0) {
			System.out.println("----------User----------");
			for (User user : l) {
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf(
						"Id -> %-5d | Name -> %-15s | Age -> %-3d | Email -> %-20s | Gender -> %-7s | Phone -> %-12s | Password -> %-10s%n",
						user.getId(), user.getName(), user.getAge(), user.getEmail(), user.getGender(), user.getPhone(),
						user.getPassword());
				System.out.println(
						"-------------------------------------------------------------------------------------------------------------------------------------------------------------");
			}
		} else {
			System.out.println("Invalid Age " + age);
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		sc.close();
	}

}
