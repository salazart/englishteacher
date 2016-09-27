package com.sz.et.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static volatile HibernateUtil instance;
	private static volatile SessionFactory sessionFactory;

	 public static HibernateUtil getInstance() {
		 HibernateUtil localInstance = instance;
			if (localInstance == null) {
				synchronized (HibernateUtil.class) {
					localInstance = instance;
					if (localInstance == null) {
						instance = localInstance = new HibernateUtil();
					}
				}
			}
			return localInstance;
		}
	
	private HibernateUtil() {
		if (sessionFactory == null) {
			try {
				sessionFactory = new Configuration().configure().buildSessionFactory();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	 
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void release() {
		sessionFactory.close();
	}
}
