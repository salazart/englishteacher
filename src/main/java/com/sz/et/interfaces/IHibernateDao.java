package com.sz.et.interfaces;

import java.util.List;

import com.sz.et.models.IEntity;

public interface IHibernateDao<T extends IEntity>{
	public T save(T entity);
	
	public T update(T entity);
	
	public List<T> getAll();
	
	public T get(int id);
}
