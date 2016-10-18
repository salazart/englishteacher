package com.sz.et;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sz.et.dao.impl.TranslationWordService;
import com.sz.et.interfaces.IHibernateDao;
import com.sz.et.models.TranslationWord;

public class HibernateTest {
	private static ApplicationContext xmlContext = new ClassPathXmlApplicationContext("spring-context.xml");
	
	public static void main(String[] args) {
		IHibernateDao<TranslationWord> translationWordService = xmlContext.getBean("translationWordService", TranslationWordService.class);
		
		List<TranslationWord> words = translationWordService.getAll();
		System.out.println(words.size());
		words.forEach(System.out::println);
		
		TranslationWord translationWord = translationWordService.get(1);
		System.out.println("HELLO");
		System.out.println(translationWord);
	}

}
