package com.sz.et.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sz.et.dao.impl.TranslationWordService;
import com.sz.et.models.TranslationWord;

@Configuration
public class AppConfig {
	
//	@Autowired
//	@Qualifier("localSessionFactory")
//	private SessionFactory sessionFactory;

	@Bean
	public TranslationWord translationWord(){
		return new TranslationWord();
	}
	
//	@Bean
//	public TranslationWordService getTranslationWordService(){
//		return new TranslationWordService();
//	}
	
//	@Bean
//	public SessionFactory getSessionFactory(){
//		return sessionFactory;
//	}
}
