package com.sz.et.controllers;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sz.et.interfaces.IWordService;
import com.sz.et.models.Word;
import com.sz.et.services.AppConfig;

@Controller
public class ViewController {
	
	@Autowired
	private IWordService wordService;
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public String all(Model model) {
		List<Word> words = wordService.getAll();
		model.addAttribute("words", words);
		return "all";
	}

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Word word4 = context.getBean("word3", Word.class);
		
		model.put("message", word4);
		return "welcome";
	}

	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(
			@RequestParam(value = "eng") String engWord, 
			@RequestParam(value = "rus") String rusWord,
			Model model) {

		Word translationWord = new Word(engWord, rusWord, true);
		wordService.save(translationWord);

		if (translationWord.getId() != 0) {
			model.addAttribute("popupMessage", "window.alert('Збережено')");
		} else {
			model.addAttribute("popupMessage", "window.alert('Помилка');");
		}

		return saveForm(model);
	}

	@RequestMapping(value="/save", method = RequestMethod.GET)
	public String saveForm(Model model) {
		return "save";
	}

	@RequestMapping(value="/learn", method = RequestMethod.POST)
	public String learn(
			@RequestParam(value = "id") int id, 
			@RequestParam(value = "exampleWord") String exampleWord,
			@RequestParam(value = "translateWord") String translateWord, 
			@RequestParam(value = "engToRus", required = false, defaultValue = "true") boolean engToRus, Model model) {

		if(id == 0){
			return learn(0, engToRus, model);
		}
			
		Word originWord = wordService.get(id);
		originWord.setEngToRus(engToRus);

		if(originWord.getExampleWord().equals(exampleWord) && originWord.getTranslateWord().equals(translateWord)){
			model.addAttribute("popupMessage", "window.alert('Вірно')");
			wordService.updateCorrectIterator(originWord);
			return learn(0, engToRus, model);
		} else if (translateWord.isEmpty()){
			model.addAttribute("popupMessage", "window.alert('Невірно.Спробуй_ще._Відповідь:_" + originWord.getTranslateWord() + "_');");
			wordService.updateInCorrectIterator(originWord);
			return learn(originWord.getId(), engToRus, model);
		} else {
			model.addAttribute("popupMessage", "window.alert('Невірно.Спробуй_ще.');");
			wordService.updateInCorrectIterator(originWord);
			return learn(originWord.getId(), engToRus, model);
		}
	}
	
	@RequestMapping(value="/learn", method = RequestMethod.GET)
	public String learn(
			@RequestParam(value = "id", required = false, defaultValue = "0") int id,
			@RequestParam(value = "engToRus", required = false, defaultValue = "true") boolean engToRus, Model model) {

		Word word = null;
		if (id == 0) {
			List<Word> translationWords = wordService.getAll();
			word = translationWords.stream()
					.min((word1, word2) -> Integer.compare(word1.getRepeatRange(), word2.getRepeatRange()))
					.get();
		} else {
			word = wordService.get(id);
		}

		model.addAttribute("word", word);
		model.addAttribute("engToRus", engToRus ? "true" : "false");
		
		return "learn";
	}


	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String delete(@RequestParam(value = "id") int id, Model model) {

		wordService.delete(id);
		return "all";
	}

}
