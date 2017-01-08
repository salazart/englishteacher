package com.sz.et.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sz.et.dao.interfaces.IWordService;
import com.sz.et.models.Word;

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
	
	@RequestMapping(value="/save", method = RequestMethod.GET)
	public String saveForm(Model model) {
		return "save";
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

	@RequestMapping(value="/learn", method = RequestMethod.GET)
	public String learn(
			@RequestParam(value = "id", required = false, defaultValue = "0") int id,
			@RequestParam(value = "engToRus", required = false, defaultValue = "true") boolean engToRus, Model model) {

		Word word = null;
		if (id == 0) {
			word = wordService.getNextWord();
		} else {
			word = wordService.get(id);
		}

		model.addAttribute("word", word);
		model.addAttribute("engToRus", word.getEngToRus());
		
		return "learn";
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
			wordService.correctResult(originWord);
			return learn(0, engToRus, model);
		} else {
			System.out.println(translateWord);
			model.addAttribute("popupMessage", "window.alert('Невірно. Правильна відповідь:" + originWord.getTranslateWord() + "');");
			wordService.inCorrectResult(originWord);
			return learn(originWord.getId(), engToRus, model);
		}
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String delete(@RequestParam(value = "id") int id, Model model) {

		wordService.delete(id);
		return "all";
	}

}
