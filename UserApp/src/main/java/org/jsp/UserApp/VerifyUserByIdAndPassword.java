package org.jsp.UserApp;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class VerifyUserByIdAndPassword {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Id and Password");
		int id = sc.nextInt();
		String password = sc.next();
		String hql = "select u from User u where u.id=?1 and u.password=?2";
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();) {
			Query<User> q = s.createQuery(hql);
			q.setParameter(1, id);
			q.setParameter(2, password);
			try {
				User users = q.getSingleResult();
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf(
						"Id -> %-5d | Name -> %-15s | Age -> %-3d | Email -> %-20s | Gender -> %-7s | Phone -> %-12s | Password -> %-10s%n",
						users.getId(), users.getName(), users.getAge(), users.getEmail(), users.getGender(),
						users.getPhone(), users.getPassword());
				System.out.println(
						"-------------------------------------------------------------------------------------------------------------------------------------------------------------");
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		sc.close();
	}

}
