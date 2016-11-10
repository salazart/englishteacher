package com.sz.et.interfaces;

import java.util.List;

import com.sz.et.models.Word;

public interface IWordService extends IDao<Word>{
	public Word get(int id);
	public void save(Word entity);
	public void delete(int id);
	public List<Word> getAll();
	
	public void updateCorrectIterator(Word originWord);

	public void updateInCorrectIterator(Word originWord);
}
