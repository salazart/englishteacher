package com.sz.et.models;

import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "translation_word" )
public class Word implements IEntity{
	
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "id")
	private int id;
	
	@Column(name = "eng")
	private String exampleWord;
	
	@Column(name = "rus")
	private String translateWord;
	
	@Column(name = "iterator")
	private int iterator;
	
	@Column(name = "correct_iterator")
	private int correctIterator;
	
	@Transient
	private boolean engToRus = true;
	
	public Word() {}
	
	public Word(String exampleWord, String translateWord, boolean engToRus) {
		setExampleWord(exampleWord);
		setTranslateWord(translateWord);
		setEngToRus(engToRus);
	}

	public String toString() {
		StringJoiner joiner = new StringJoiner(", ");
		joiner.add("id:" + String.valueOf(getId()))
		.add("exampleWord:" + getExampleWord())
		.add("translateWord:" + getTranslateWord())
		.add(String.valueOf(getIterator()))
		.add(String.valueOf(getCorrectIterator()));
		return joiner.toString();
	}
	public void setEngToRus(boolean engToRus) {
		this.engToRus = engToRus;
	}
	
	public void setExampleWord(String exampleWord) {
		this.exampleWord = exampleWord;
	}
	public String getExampleWord() {
		return engToRus ? exampleWord : translateWord;
	}
	public void setTranslateWord(String translateWord) {
		this.translateWord = translateWord;
	}
	public String getTranslateWord() {
		return engToRus ? translateWord : exampleWord;
	}
	@Override
	public int getId() {
		return id;
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
