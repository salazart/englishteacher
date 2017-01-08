package com.sz.et.dao.interfaces;

import java.util.List;

import com.sz.et.models.Word;

public interface IWordService extends IDao<Word>{
	Word get(int id);
	void save(Word entity);
	void delete(int id);
	
	Word getNextWord();
	List<Word> getLearnWords();
	boolean isEmpty();
	void correctResult(Word word);
	void inCorrectResult(Word word);
	void saveResult();
}
