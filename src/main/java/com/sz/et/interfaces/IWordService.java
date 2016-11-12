package com.sz.et.interfaces;

import java.util.List;

import com.sz.et.models.Word;

public interface IWordService extends IDao<Word>{
	Word get(int id);
	void save(Word entity);
	void delete(int id);
	
	Word getNextWord();
	List<Word> getLearnWords();
	boolean isEmpty();
	void result(Word word);
	void resultInCorrect(Word word);
	void saveResult();
}
