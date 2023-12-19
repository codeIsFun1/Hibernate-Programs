package org.jsp.User_NewApp.controller;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class TestCfg {

	public static void main(String[] args) {
		try (Session s = new Configuration().configure().buildSessionFactory().openSession();) {
			System.out.println(s);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

}
