package com.sz.et.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sz.et.models.TranslationWord;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

	@Bean
	public TranslationWord translationWord() {
		return new TranslationWord();
	}

	// @Bean
	// public TranslationWordService getTranslationWordService(){
	// return new TranslationWordService();
	// }

	// @Bean
	// public SessionFactory getSessionFactory(){
	// return sessionFactory;
	// }
}
