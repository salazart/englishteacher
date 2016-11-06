package com.sz.et.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sz.et.dao.GeneralDao;
import com.sz.et.models.Word;

@Service
public class WordService {
	
	@Autowired
	private GeneralDao dao;

	public void setDao(GeneralDao dao) {
		this.dao = dao;
	}

	public Word get(int id) {
		return dao.get(id);
	}

	public void save(Word entity) {
		dao.save(entity);
	}

	public void update(Word entity) {
		dao.update(entity);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public List<Word> getAll() {
		return dao.getAll();
	}
}
