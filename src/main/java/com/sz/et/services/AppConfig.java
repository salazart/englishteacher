package com.sz.et.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
//	public SessionFactory getSessionFactory(){
//		return sessionFactory;
//	}
}
