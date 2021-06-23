package com.example.Counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeCounter {
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("counter")==null)
			session.setAttribute("counter", 1);
		else {
			int count = (int) session.getAttribute("counter");
			session.setAttribute("counter", count+1);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(Model model, HttpSession session) { 
		model.addAttribute("counter", session.getAttribute("counter"));
		return "counter.jsp";
	}

}
