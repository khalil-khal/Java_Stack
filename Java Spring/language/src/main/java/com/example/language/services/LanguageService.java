package com.example.language.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.language.models.Languages;
import com.example.language.repositores.LanguageRepository;



@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	public LanguageService(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
		
	}
	public List<Languages> allLanguages(){
		return languageRepository.findAll();
		
	}
	public Languages CreateLanguage(Languages lang) {
		return languageRepository.save(lang);
	}
   public Languages findLang(Long id) {
	   Optional<Languages> optionalLang=languageRepository.findById(id);
	   if (optionalLang.isPresent()) {
		   return optionalLang.get();
		
	   }else {
		   return null;
	   }
   }
   public void DeleteLanguage(Long id) {
	   Optional<Languages> optionalLang=languageRepository.findById(id);
	   if (optionalLang.isPresent()) {
		   languageRepository.deleteById(id);
	   }
	   
   }
}
