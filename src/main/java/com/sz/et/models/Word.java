package com.sz.et.models;

import java.util.Calendar;
import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "words" )
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
	
	@Column(name = "learnDate")
	private long futureLearnDate;
	
	@Column(name = "repeatRange")
	private int repeatRange;
	
	@Transient
	private boolean engToRus = true;
	
	public Word() {
		setRepeatRange(0);
		setFutureLearnDate(Calendar.getInstance().getTimeInMillis());
	}
	
	public Word(String exampleWord, String translateWord, boolean engToRus) {
		this();
		setExampleWord(exampleWord);
		setTranslateWord(translateWord);
		setEngToRus(engToRus);
	}

	public String toString() {
		StringJoiner joiner = new StringJoiner(", ");
		joiner.add("id:" + String.valueOf(getId()))
		.add("exampleWord:" + getExampleWord())
		.add("translateWord:" + getTranslateWord())
		.add(String.valueOf(getFutureLearnDate()))
		.add(String.valueOf(getRepeatRange()));
		return joiner.toString();
	}
	public void updateCorrectStatus(){
		repeatRange++;
		Calendar calendar = Calendar.getInstance();
		switch (repeatRange) {
		case 1:
			calendar.add(Calendar.HOUR_OF_DAY, 1);
			break;
		case 2:
			calendar.add(Calendar.HOUR_OF_DAY, 12);
			break;
		case 3:
			calendar.add(Calendar.HOUR_OF_DAY, 24);
			break;
		case 4:
			calendar.add(Calendar.DAY_OF_MONTH, 3);
			break;
		case 5:
			calendar.add(Calendar.DAY_OF_MONTH, 7);
			break;
		default:
			calendar.add(Calendar.DAY_OF_MONTH, 30);
			break;
		}
		setFutureLearnDate(calendar.getTimeInMillis());
	}
	
	public void updateInCorrectStatus(){
		setRepeatRange(0);
	}
	
	public void setFutureLearnDate(long futureLearnDate) {
		this.futureLearnDate = futureLearnDate;
	}
	public long getFutureLearnDate() {
		return futureLearnDate;
	}
	public void setRepeatRange(int repeatRange) {
		this.repeatRange = repeatRange;
	}
	public int getRepeatRange() {
		return repeatRange;
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

	public void setId(int id) {
		this.id = id;
	}
}
