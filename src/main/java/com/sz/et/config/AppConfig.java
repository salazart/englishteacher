package com.sz.et.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.sz.et.dao.impl.WordService;
import com.sz.et.dao.interfaces.IWordService;
import com.sz.et.models.Word;

@Configuration
@PropertySource(value="classpath:database.properties")
@EnableTransactionManagement
public class AppConfig {

//	@Bean
//	public PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
//		return new PropertySourcesPlaceholderConfigurer();
//	}
	
	@Value("${db.driverClassName}")
	private String driver;

	@Value("${db.url}")
	private String url;
	
	@Value("${db.username}")
	private String user;
	
	@Value("${db.password}")
	private String pass;

	@Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

	@Bean
	public Word word1() {
		return new Word("hello", "привет", true);
	}

	@Bean
	public IWordService wordService() {
		return new WordService();
	}
	
	@Bean
	public DataSource getDataSource(){
		BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName(driver);
	    dataSource.setUrl(url);
	    dataSource.setUsername(user);
	    dataSource.setPassword(pass);
	    return dataSource;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(){
		JpaTransactionManager transactionManager = new JpaTransactionManager(
				getEntityManagerFactoryBean().getObject());
		return transactionManager;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean(){
		LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		localContainerEntityManagerFactoryBean.setDataSource(getDataSource());
		localContainerEntityManagerFactoryBean.setPersistenceProvider(new HibernatePersistenceProvider());
		localContainerEntityManagerFactoryBean.setPackagesToScan("com.sz.et.models");
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hbm2ddl.auto", "create");
		jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		jpaProperties.setProperty("hibernate.show_sql", "true");
		localContainerEntityManagerFactoryBean.setJpaProperties(jpaProperties);
		return localContainerEntityManagerFactoryBean;
	}
	
	
//	@Bean
//	public WordService wordService() {
//		return new WordService();
//	}
	
//	@Bean
//	public GeneralDao<?> generalDao() {
//		return new GeneralDao<>();
//	}
	
	
	
	
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
