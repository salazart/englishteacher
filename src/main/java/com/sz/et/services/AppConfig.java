package com.sz.et.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sz.et.models.TranslationWord;

@Configuration
public class AppConfig {

	@Bean
	public TranslationWord translationWord(){
		return new TranslationWord();
	}
}
