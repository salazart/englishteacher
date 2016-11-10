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

	public Word get(int id) {
		return dao.get(id);
	}

	public void save(Word entity) {
		dao.save(entity);
	}

	public void delete(int id) {
		dao.delete(id);
	}

	public List<Word> getAll() {
		return dao.getAll();
	}

	public void updateCorrectIterator(Word originWord) {
		originWord.setEngToRus(true);
		originWord.updateCorrectStatus();
		dao.update(originWord);
	}

	public void updateInCorrectIterator(Word originWord) {
		originWord.setEngToRus(true);
		originWord.updateInCorrectStatus();
		dao.update(originWord);
	}
	
//	LocalDate localDate = LocalDate.
//	LocalDate localDate = LocalDate.now();
//	localDate.plusDays(1);
//	Date date = Date.valueOf(localDate);
//	new Date(Calendar.getInstance().getTimeInMillis());
}
