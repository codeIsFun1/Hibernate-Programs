package org.jsp.UserApp;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateUser {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the User id to update details");
		int eid = sc.nextInt();
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();) {
			User u = s.get(User.class, eid);
			if (u != null) {
				System.out.println("Enter the name,phone,email,age,gender,and password");
				u.setName(sc.next());
				u.setPhone(sc.nextLong());
				u.setEmail(sc.next());
				u.setAge(sc.nextInt());
				u.setGender(sc.next());
				u.setPassword(sc.next());
				Transaction t = s.beginTransaction();
				t.commit();
				System.out.println("Updation Successfull");
			} else {
				System.err.println("Cannot update as the entered id is invalid");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		sc.close();
	}

}
