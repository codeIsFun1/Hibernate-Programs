package org.jsp.hibernateDemo;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee2 {

	public static void main(String[] args) {
		Employee e = new Employee();// Transient State
		e.setId(7);
		e.setName("Anarkali");
		e.setPhone(987458674L);
		e.setDesg("Murderer");
		e.setSalary(895632.023);
		e.setPassword("BullaRakhtaHoonSabKuchKhulla");
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();) {
			s.saveOrUpdate(e);
			Transaction t = s.beginTransaction();
			t.commit();
		} catch (Exception e2) {
			System.err.println(e2.getMessage());
		}

	}

}
