package org.jsp.UserApp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindUserByGender {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Gender");
		String gender = sc.next();
		String hql = "select u from User u where u.gender=?1";
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();){
		Query<User> q = s.createQuery(hql);
		q.setParameter(1, gender);
		List<User> users = q.getResultList();
		if (users.size() > 0) {
			for (User user : users) {
				System.out.println("---------------------Users------------------------");
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
			System.err.println("Invalid Gender");
		}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		sc.close();
	}

}
