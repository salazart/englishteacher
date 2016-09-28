package com.sz.et.dao.impl;

import org.hibernate.SessionFactory;

import com.sz.et.dao.AbstractHibernateDao;
import com.sz.et.interfaces.IHibernateDao;
import com.sz.et.models.TranslationWord;

public class TranslationWordService extends AbstractHibernateDao<TranslationWord> implements IHibernateDao<TranslationWord>{
	
	private static final String CONFIG_PROPERTIES = "config.properties";
	
	public TranslationWordService(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
}
