package com.sz.et;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sz.et.dao.impl.TranslationWordService;
import com.sz.et.interfaces.IHibernateDao;
import com.sz.et.models.TranslationWord;
import com.sz.et.utils.HibernateUtil;

public class TranslationWordTest {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
	
	public static void main(String[] args) {

		TranslationWord word = new TranslationWord("word", "слово");
		TranslationWord word2 = new TranslationWord("hello", "привет");
		TranslationWord word3 = (TranslationWord) context.getBean("word3");
		
		IHibernateDao<TranslationWord> translationWordService = new TranslationWordService(HibernateUtil.getInstance().getSessionFactory());
		word = translationWordService.save(word);
		word2 = translationWordService.save(word2);
		word3 = translationWordService.save(word3);
		
		List<TranslationWord> words = translationWordService.getAll();
		System.out.println(words.size());
		words.forEach(System.out::println);
		
		HibernateUtil.release();
	}
}
