package com.example.thecode;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {
	@RequestMapping("/")
	public String index() {
		
		return "index.jsp";
	}
	@RequestMapping(value="/code",method=RequestMethod.POST)
	public String code(Model model,@RequestParam("code") String code,RedirectAttributes redirctAttr	) {
		if(code.equals("bushido")) {
			ArrayList<String> codeDisplay=new ArrayList<String>();
			codeDisplay.add("Loyality");
			codeDisplay.add("Courage");
			codeDisplay.add("Veracity");
			codeDisplay.add("Compation");
			codeDisplay.add("Honor");	
			model.addAttribute("codeDisplay",codeDisplay);
			
			return "code.jsp";
		}else {
			redirctAttr.addFlashAttribute("errorMessage","You must try harder");
		    return "redirect:/";
		}
		
	}

}
