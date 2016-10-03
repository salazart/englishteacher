package com.sz.et.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sz.et.interfaces.IHibernateDao;
import com.sz.et.models.IEntity;

public abstract class AbstractHibernateDao<T extends IEntity> implements IHibernateDao<T>{

	protected SessionFactory sessionFactory;

	protected Class<T> clazz;
	
	public AbstractHibernateDao(SessionFactory sessionFactory) {
		this.clazz = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
		
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public T save(T entity) {
		try (Session session = sessionFactory.openSession();){
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
		}
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		return sessionFactory.openSession()
				.createQuery( "from " + clazz.getName())
				.getResultList();
	}

}
