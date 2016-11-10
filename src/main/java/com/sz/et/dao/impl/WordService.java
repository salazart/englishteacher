package com.sz.et.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sz.et.dao.GeneralDao;
import com.sz.et.interfaces.IWordService;
import com.sz.et.models.Word;

@Repository
public class WordService extends GeneralDao<Word> implements IWordService{
	
	public Word get(int id) {
		return super.get(id);
	}

	public void save(Word entity) {
		super.save(entity);
	}

	public void delete(int id) {
		super.delete(id);
	}

	public List<Word> getAll() {
		return super.getAll();
	}

	public void updateCorrectIterator(Word originWord) {
		originWord.setEngToRus(true);
		originWord.updateCorrectStatus();
		super.update(originWord);
	}

	public void updateInCorrectIterator(Word originWord) {
		originWord.setEngToRus(true);
		originWord.updateInCorrectStatus();
		super.update(originWord);
	}
	
//	LocalDate localDate = LocalDate.
//	LocalDate localDate = LocalDate.now();
//	localDate.plusDays(1);
//	Date date = Date.valueOf(localDate);
//	new Date(Calendar.getInstance().getTimeInMillis());
}
