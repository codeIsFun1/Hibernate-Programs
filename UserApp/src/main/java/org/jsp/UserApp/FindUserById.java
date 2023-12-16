package org.jsp.UserApp;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FindUserById {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the id");
		int id = sc.nextInt();
		String hql = "select u from User u where id=?1";
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();){
		Query<User> q = s.createQuery(hql);
		q.setParameter(1, id);
		List<User> l = q.getResultList();
		if (l.size() > 0) {
			System.out.println("User is Present");
			for (User user : l) {
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
			System.err.println("Invalid Id");
		}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		sc.close();
	}

}
