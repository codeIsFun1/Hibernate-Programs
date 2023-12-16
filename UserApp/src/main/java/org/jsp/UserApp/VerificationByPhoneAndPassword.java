package org.jsp.UserApp;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class VerificationByPhoneAndPassword {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String hql = "select u from User u where u.phone=?1 and u.password=?2";
		System.out.println("Enter the Phone and Password");
		long l = sc.nextLong();
		String password = sc.next();
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();) {
			Query<User> q = s.createQuery(hql);
			q.setParameter(1, l);
			q.setParameter(2, password);
			try {
				User user = q.getSingleResult();
				System.out.println("---------------------UsersFound------------------------");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------------------------------------------------------");
				System.out.printf(
						"Id -> %-5d | Name -> %-15s | Age -> %-3d | Email -> %-20s | Gender -> %-7s | Phone -> %-12s | Password -> %-10s%n",
						user.getId(), user.getName(), user.getAge(), user.getEmail(), user.getGender(), user.getPhone(),
						user.getPassword());
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
