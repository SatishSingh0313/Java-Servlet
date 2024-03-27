package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@RequestMapping("/home")
	public ModelAndView  load(){
		
		  ModelAndView view = new ModelAndView() ;
	  view.setViewName("index.jsp");
	  return view;
   }
	
	@RequestMapping("/about")
	public String display() {
		return "about.jsp";
	}
}