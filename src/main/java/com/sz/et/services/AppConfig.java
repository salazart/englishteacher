package com.sz.et.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sz.et.models.Word;

@Configuration
@ImportResource("classpath:spring-context.xml")
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
	public Word translationWord() {
		return new Word("take", "брать");
	}
	
//	@Bean
//	public WordService wordService() {
//		return new WordService();
//	}
	
//	@Bean
//	public SessionFactory createSessionFactory() {
//		ApplicationContext xmlContext = new ClassPathXmlApplicationContext("spring-context.xml");
//		return xmlContext.getBean("sessionFactory", SessionFactory.class);
//	}
	
	
	// @Bean
	// public TranslationWordService getTranslationWordService(){
	// return new TranslationWordService();
	// }

	// @Bean
	// public SessionFactory getSessionFactory(){
	// return sessionFactory;
	// }
}
