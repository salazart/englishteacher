package com.sz.et.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sz.et.dao.AbstractHibernateDao;
import com.sz.et.interfaces.IHibernateDao;
import com.sz.et.models.TranslationWord;

public class TranslationWordService extends AbstractHibernateDao<TranslationWord> implements IHibernateDao<TranslationWord>{
	
	@Autowired
	public TranslationWordService(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

}
