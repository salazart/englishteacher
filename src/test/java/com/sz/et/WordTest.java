package com.sz.et;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sz.et.dao.impl.WordService;
import com.sz.et.models.Word;
import com.sz.et.services.AppConfig;

public class WordTest {
//	private static ApplicationContext xmlContext = new ClassPathXmlApplicationContext("spring-context.xml");
	private static ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	
	public static void main(String[] args) {
		
//		SessionFactory sessionFactory = xmlContext.getBean("localSessionFactory", SessionFactory.class);
		
		Word word1 = context.getBean(Word.class);
		WordService wordService = context.getBean("wordService", WordService.class); 

//		Word oneWord = wordService.get(4);
//		System.out.println(oneWord);
//		wordService.delete(4);
//		wordService.save(word1);
		wordService.save(word1);
		System.out.println(word1);
		
//		wordService.updateCorrectIterator(oneWord);
		
		List<Word> words = wordService.getAll();
		System.out.println(words.size());
		for (Word word : words) {
			System.out.println(word);
		}
		
//		IHibernateDao<TranslationWord> translationWordService = context.getBean(TranslationWordService.class); 
//		IHibernateDao<TranslationWord> translationWordService = new TranslationWordService(HibernateUtil.getInstance().getSessionFactory());
//		IHibernateDao<TranslationWord> translationWordService = new TranslationWordService(sessionFactory);//xmlContext.getBean("wordService", TranslationWordService.class);
//
//		word = translationWordService.save(word);
//		word2 = translationWordService.save(word2);
//		word3 = translationWordService.save(word3);
//		word4 = translationWordService.save(word4);
//		word5 = translationWordService.save(word5);
		
//		System.out.println(word4);
//		for (int i = 0; i < 20; i++) {
//			List<Word> words = wordService.getAll();
//			System.out.println(words.size());
//			words.forEach(System.out::println);
//		}
	}
	
}
