package com.sz.et.models;

import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "translation_word" )
public class TranslationWord implements IEntity{
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "id")
	private int id;
	
	@Column(name = "eng")
	private String engWord;
	
	@Column(name = "rus")
	private String rusWord;
	
	@Column(name = "iterator")
	private int iterator;
	
	@Column(name = "correct_iterator")
	private int correctIterator;
	
	public TranslationWord() {}
	
	public TranslationWord(String engWord, String rusWord) {
		setEngWord(engWord);
		setRusWord(rusWord);
	}

	public String toString() {
		StringJoiner joiner = new StringJoiner(", ");
		joiner.add("id:" + String.valueOf(getId()))
		.add("eng:" + getEngWord())
		.add("rus:" + getRusWord())
		.add(String.valueOf(getIterator()))
		.add(String.valueOf(getCorrectIterator()));
		return joiner.toString();
	}
	
	@Override
	public int getId() {
		return id;
	}

	public String getEngWord() {
		return engWord;
	}

	public void setEngWord(String engWord) {
		this.engWord = engWord;
	}

	public String getRusWord() {
		return rusWord;
	}


	public void setRusWord(String rusWord) {
		this.rusWord = rusWord;
	}


	public int getIterator() {
		return iterator;
	}


	public void setIterator(int iterator) {
		this.iterator = iterator;
	}


	public int getCorrectIterator() {
		return correctIterator;
	}


	public void setCorrectIterator(int correctIterator) {
		this.correctIterator = correctIterator;
	}


	public void setId(int id) {
		this.id = id;
	}
}
