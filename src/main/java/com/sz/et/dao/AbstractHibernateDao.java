package com.sz.et.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sz.et.interfaces.IHibernateDao;
import com.sz.et.models.IEntity;

public abstract class AbstractHibernateDao<T extends IEntity> implements IHibernateDao<T>{

	@Autowired
	protected SessionFactory sessionFactory;
	
	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	protected Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public AbstractHibernateDao() {
		this.clazz = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
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
//		List<T> objects = null;
//		try {
//			getCurrentSession().beginTransaction();
//			objects = getCurrentSession().createQuery( "from " + clazz.getName()).getResultList();
//		} catch (Exception e) {
//			System.err.println(e);
//		} finally {
//			getCurrentSession().close();
//		}
//		return objects;
		return getCurrentSession()
				.createQuery( "from " + clazz.getName())
				.getResultList();
	}
	
	public T update(T entity){
		try (Session session = sessionFactory.openSession();){
			session.beginTransaction();
			session.merge(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
		}
		return entity;
	}
	
	public T get(int id){
		T t = null;
		try (Session session = sessionFactory.openSession();){
			session.beginTransaction();
			t = session.get(clazz, id);
//			Hibernate.initialize(t);
		} catch (Exception e) {
			System.err.println(e);
		}
		return t;
	}
	
	public void delete(T entity){
		try (Session session = sessionFactory.openSession();){
			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
