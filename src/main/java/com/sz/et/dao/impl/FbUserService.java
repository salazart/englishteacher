package com.sz.et.dao.impl;

import org.hibernate.SessionFactory;

import com.sz.et.dao.AbstractHibernateDao;
import com.sz.et.interfaces.IHibernateDao;
import com.sz.et.models.FbUser;

public class FbUserService extends AbstractHibernateDao<FbUser> implements IHibernateDao<FbUser>{
	
	private static final String CONFIG_PROPERTIES = "config.properties";
	
	public FbUserService(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
}
