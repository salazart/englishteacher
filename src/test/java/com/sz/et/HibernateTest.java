package com.sz.et;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateTest {
	private static ApplicationContext xmlContext = new ClassPathXmlApplicationContext("spring-context.xml");
	
	public static void main(String[] args) {
//		IHibernateDao<Word> translationWordService = xmlContext.getBean("translationWordService", WordService.class);
		
//		List<Word> words = translationWordService.getAll();
//		System.out.println(words.size());
//		words.forEach(System.out::println);
		
//		Word translationWord = translationWordService.get(1);
		System.out.println("HELLO");
//		System.out.println(translationWord);
	}

}
