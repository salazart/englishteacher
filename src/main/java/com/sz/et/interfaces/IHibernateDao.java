package com.sz.et.interfaces;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sz.et.models.IEntity;

@Transactional
public interface IHibernateDao<T extends IEntity>{
	T save(T entity);
	T update(T entity);
	void delete(T entity);
	T get(int id);
	List<T> getAll();
}
