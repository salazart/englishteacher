package com.sz.et.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.sz.et.dao.GeneralDao;
import com.sz.et.dao.interfaces.IWordService;
import com.sz.et.models.Word;

@Repository
public class WordService extends GeneralDao<Word> implements IWordService{
	private static final int COUNT_WORDS = 6;
	
	private Random random = new Random();
	private List<Word> words = new ArrayList<>();
	private Map<Integer, Integer> learnWords = new HashMap<>();
	
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
	
	@Override
	public Word getNextWord() {
		if(words.isEmpty()){
			List<Word> newWords = getLearnWords();
			newWords.forEach(word -> word.setEngToRus(true));
			words.addAll(newWords);
			
			for (int i = 0; i < newWords.size(); i++) {
				try {
					Word cloneWord = newWords.get(i).clone();
					cloneWord.setEngToRus(false);
					newWords.set(i, cloneWord);
				} catch (CloneNotSupportedException e) {
					System.err.println(e);
				}
			}
				
			words.addAll(newWords);
			System.out.println("words is loaded count words are: " + words.size());
		}
		int index = random.nextInt(words.size());
		Word word = words.get(index);
		words.remove(index);
		System.out.println("next word: " + word);
		return word;
	}
	
	public boolean isEmpty(){
		return words.isEmpty();
	}

	@Override
	public List<Word> getLearnWords() {
		return super.getAll().stream()
				.sorted((word1, word2) -> Integer.compare(word1.getRepeatRange(), word2.getRepeatRange()))
				.limit(COUNT_WORDS)
				.collect(Collectors.toList());
	}

	@Override
	public void result(Word word) {
		int countRepeat = 0;
		if(learnWords.containsKey(word.getId())){
			countRepeat = learnWords.get(word.getId());
		}
		learnWords.put(word.getId(), ++countRepeat);
		System.out.println("count map " + learnWords.size());
	}
	
	@Override
	public void resultInCorrect(Word word) {
		System.out.println("result incorrect");
		words.add(word);
		words.add(word);
		result(word);
	}

	@Override
	public void saveResult() {
		learnWords.forEach((k,v) -> {
			Word word = super.get(k);
			System.out.println("update word: " + word);
			if(v == 2){
				word.updateCorrectStatus();
				System.out.println("correct");
			} else {
				word.updateInCorrectStatus();
				System.out.println("incorrect");
			}
			super.update(word);
		});
		learnWords.clear();
	}
}
