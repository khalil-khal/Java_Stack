package com.example.language.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;

import com.example.language.models.Languages;
import com.example.language.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
	public LanguageController(LanguageService languageService){
		this.languageService=languageService;
	}
	


@RequestMapping("/")
public String Index() {
	return "redirect:/languages";
}
@RequestMapping("/languages")
public String languageIndex(Model model,@ModelAttribute ("language") Languages language) {
	List<Languages> langs=languageService.allLanguages();
	model.addAttribute("languages",langs);
	return "index.jsp";
	}
	
@RequestMapping("/languages/{id}")
 public String Show(@PathVariable("id") long id , Model model ) {
     Languages lang=languageService.findLang(id);
     model.addAttribute("lang", lang);
     return "show.jsp";
     
	
}
@RequestMapping("/languages/{id}/edit")
public String Edit(@PathVariable("id") long id , Model model ) {
    Languages lang=languageService.findLang(id);
    model.addAttribute("lang", lang);
    return "edit.jsp";
    
	
}
@RequestMapping("/languages/{id}/delete")
public String Delete(@PathVariable("id") long id , Model model ) {
    Languages lang=languageService.findLang(id);
    model.addAttribute("lang", lang);
    return "redirect:/languages";
}
@RequestMapping(value="/create",method=RequestMethod.POST)
public String Create(@Valid @ModelAttribute ("language")Languages language , BindingResult result) {
	if (result.hasErrors()) {
		return "index.jsp";
		
	}else {
		languageService.CreateLanguage(language);
		return "redirect:/languages";
	}

}
@RequestMapping("/update/{id}")
public String update(@Valid @ModelAttribute ("lang")Languages lang, BindingResult result) {
	languageService.CreateLanguage(lang);
	return "redirect:/languages";

}









}