package com.sz.et.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/all")
	public String test(Model model){
		
		IHibernateDao<TranslationWord> translationWordService = xmlContext.getBean("translationWordService", TranslationWordService.class);
		List<TranslationWord> words = translationWordService.getAll();
		
		model.addAttribute("words", words);
		System.out.println(words.size());
		return "all";
	}
	
	@Value("${application.message:Hello World}")
	private String message = "Hello World";
	
	@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}
	
	@RequestMapping("/hello")
    public ModelAndView hello() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("welcome");
         
        String str = "Hello World!";
        mav.addObject("message", str);
 
        return mav;
    }
	
	@PostMapping("/save")
	public String save(@RequestParam(value="eng") String engWord, @RequestParam(value="rus") String rusWord, Model model){

		TranslationWord translationWord = new TranslationWord(engWord, rusWord);
		IHibernateDao<TranslationWord> translationWordService = xmlContext.getBean("translationWordService", TranslationWordService.class);
		translationWordService.save(translationWord);

		if(translationWord.getId() != 0){
			model.addAttribute("popupMessage", "window.alert('Збережено')");
		} else {
			model.addAttribute("popupMessage", "window.alert('Помилка');");
		}
		
		return saveForm(model);
	}
	
	@GetMapping("/save")
	public String saveForm(Model model){
		return "save";
	}
	
	@PostMapping("/learn")
	public String learn(@RequestParam(value="eng") String engWord, @RequestParam(value="rus") String rusWord, Model model){

		TranslationWord translationWord = new TranslationWord(engWord, rusWord);
		IHibernateDao<TranslationWord> translationWordService = xmlContext.getBean("translationWordService", TranslationWordService.class);
		translationWordService.save(translationWord);

		if(translationWord.getId() != 0){
			model.addAttribute("popupMessage", "window.alert('Збережено')");
		} else {
			model.addAttribute("popupMessage", "window.alert('Помилка');");
		}
		
		return learnForm(model);
	}
	
	@GetMapping("/learn")
	public String learnForm(Model model){
		return "learn";
	}
	
}
