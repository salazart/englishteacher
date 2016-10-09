package com.sz.et.controllers;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sz.et.dao.impl.TranslationWordService;
import com.sz.et.interfaces.IHibernateDao;
import com.sz.et.models.TranslationWord;

@Controller
public class ViewController {
	
	private static ApplicationContext xmlContext = new ClassPathXmlApplicationContext("spring-context.xml");
	
	@RequestMapping("/general")
	public String general(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model){
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@RequestMapping("/words")
	public String getWords(Model model){
		IHibernateDao<TranslationWord> translationWordService = xmlContext.getBean("translationWordService", TranslationWordService.class);
		List<TranslationWord> words = translationWordService.getAll();
		
		model.addAttribute("words", words);
		
		return "words";
	}
	
	@RequestMapping("/test")
	public String test(Model model){
		return "test";
	}
}
