package com.sz.et.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sz.et.models.TranslationWord;

@RestController
public class ModelController {
	@RequestMapping("/eng")
	public TranslationWord getEng(@RequestParam(value="word", defaultValue="World") String word){
		return new TranslationWord(word, "hello");
	}
}
