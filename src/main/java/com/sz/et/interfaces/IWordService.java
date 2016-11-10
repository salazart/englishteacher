package com.sz.et.interfaces;

import com.sz.et.models.Word;

public interface IWordService extends IDao<Word>{
	Word get(int id);
	
	void save(Word entity);
	void delete(int id);
	
	void updateCorrectIterator(Word originWord);

	void updateInCorrectIterator(Word originWord);
}
