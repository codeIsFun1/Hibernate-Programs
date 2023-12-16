package org.jsp.UserApp;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteUser {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Id");
		int id = sc.nextInt();
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();){
			User u = s.get(User.class, id);
			if (u != null) {
				Transaction t = s.beginTransaction();
				s.delete(u);
				t.commit();
				System.out.println("Deletion SuccessFull");
			} else {
				System.err.println("Invalid Id");
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		sc.close();
	}

}
