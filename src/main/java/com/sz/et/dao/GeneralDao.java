package com.sz.et.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.sz.et.models.Word;

public class GeneralDao{

	@PersistenceContext
	private EntityManager em;
	
//	protected Class<T> clazz;
//	
//	@SuppressWarnings("unchecked")
//	public GeneralDao() {
//		this.clazz = (Class<T>) ((ParameterizedType) getClass()
//				.getGenericSuperclass()).getActualTypeArguments()[0];
//	}
	
	public Word get(int id){
		return em.find(Word.class, id);
	}
	
	@Transactional
	public void save(Word entity) {
		em.persist(entity);
	}

	@Transactional
	public void update(Word entity){
		em.merge(entity);
	}
	
	@Transactional
	public void delete(int id){
		Word entity = em.getReference(Word.class, id);
		em.remove(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<Word> getAll() {
		return em.createQuery("from Word").getResultList();
	}
}
