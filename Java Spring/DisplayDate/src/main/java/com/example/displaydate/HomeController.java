package com.example.displaydate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
@Controller


public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model viewModel) {
		Date Date = new Date();
		SimpleDateFormat formattedAsDate = new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, YYYY");
		viewModel.addAttribute("theDate", formattedAsDate.format(Date));
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String time(Model viewModel) {
		Date Date = new Date();
		SimpleDateFormat formattedAsTime = new SimpleDateFormat("h:mm a");
		viewModel.addAttribute("theTime", formattedAsTime.format(Date));
		return "time.jsp";
	}
}