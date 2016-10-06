package com.sz.et.dao.impl;

import org.hibernate.SessionFactory;

import com.sz.et.dao.AbstractHibernateDao;
import com.sz.et.interfaces.IHibernateDao;
import com.sz.et.models.TranslationWord;

public class TranslationWordService extends AbstractHibernateDao<TranslationWord> implements IHibernateDao<TranslationWord>{
	
	public TranslationWordService(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

}
