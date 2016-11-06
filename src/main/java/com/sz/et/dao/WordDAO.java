package com.sz.et.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.sz.et.models.Word;

@Component
public class WordDAO {

	@PersistenceContext
	private EntityManager em;
	
	public List<Word> getAllWords() {
        TypedQuery<Word> query = em.createQuery("from Word", Word.class);
        return query.getResultList();
    }
	
}
