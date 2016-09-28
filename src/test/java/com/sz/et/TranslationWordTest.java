package com.sz.et;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sz.et.dao.impl.TranslationWordService;
import com.sz.et.interfaces.IHibernateDao;
import com.sz.et.models.TranslationWord;
import com.sz.et.services.AppConfig;
import com.sz.et.utils.HibernateUtil;

public class TranslationWordTest {
	private static ApplicationContext xmlContext = new ClassPathXmlApplicationContext("spring-context.xml");
	private static ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
	
	public static void main(String[] args) {

		TranslationWord word = new TranslationWord("word", "слово");
		TranslationWord word2 = new TranslationWord("hello", "привет");
		TranslationWord word3 = xmlContext.getBean("word3", TranslationWord.class);
		TranslationWord word4 = context.getBean(TranslationWord.class);
		TranslationWord word5 = xmlContext.getBean("word5", TranslationWord.class);
		
		IHibernateDao<TranslationWord> translationWordService = new TranslationWordService(HibernateUtil.getInstance().getSessionFactory());
		word = translationWordService.save(word);
		word2 = translationWordService.save(word2);
		word3 = translationWordService.save(word3);
		word4 = translationWordService.save(word4);
		word5 = translationWordService.save(word5);
		
		List<TranslationWord> words = translationWordService.getAll();
		System.out.println(words.size());
		words.forEach(System.out::println);
		
		HibernateUtil.release();
	}
}
