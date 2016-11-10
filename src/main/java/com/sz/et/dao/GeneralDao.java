package com.sz.et.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.sz.et.interfaces.IDao;
import com.sz.et.models.IEntity;
import com.sz.et.models.Word;

@Transactional
public class GeneralDao<T extends IEntity> implements IDao<T>{

	@PersistenceContext
	private EntityManager em;
	
	protected Class<? extends T> clazz;
	
	public GeneralDao() {
		this.clazz = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public T get(int id){
		return em.find(clazz, id);
	}
	
	public void save(T entity) {
		em.persist(entity);
	}

	public void update(Word entity){
		em.merge(entity);
	}
	
	public void delete(int id){
		T entity = em.getReference(clazz, id);
		em.remove(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return em.createQuery("from " + clazz.getName())
				.getResultList();
	}

}
