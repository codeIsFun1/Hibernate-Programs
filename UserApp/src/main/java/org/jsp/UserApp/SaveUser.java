package org.jsp.UserApp;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SaveUser {

	public static void main(String[] args) {

		User u = new User();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name");
		String nm = sc.nextLine();
		System.out.println("Enter the Phone number");
		long ph = sc.nextLong();
		System.out.println("Enter the Email");
		String email = sc.next();
		System.out.println("Enter the Age");
		int age = sc.nextInt();
		System.out.println("Enter the Gennder");
		String gender = sc.next();
		System.out.println("Enter the password");
		String pass = sc.next();
		sc.nextLine();
		u.setName(nm);
		u.setPhone(ph);
		u.setEmail(email);
		u.setAge(age);
		u.setGender(gender);
		u.setPassword(pass);
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();) {
			int id = (int) s.save(u);
			Transaction t = s.beginTransaction();
			t.commit();
			System.out.println("User Saved with id -> " + id);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		sc.close();
	}

}
