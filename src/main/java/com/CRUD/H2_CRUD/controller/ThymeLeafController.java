package com.CRUD.H2_CRUD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CRUD.H2_CRUD.model.Login;

@Controller
public class ThymeLeafController {
	
	/*@GetMapping(value= "/thymeleafTemplate")
	public String getTemplate(@RequestParam(name="name", required=false, defaultValue="World")String name, Model model ) {
		model.addAttribute("name", name);
		return "thymeleafTemplate";
	}*/
	
	@GetMapping("/login")
	 public String showLogin() {
	  return "login";
	 }
	 //Check for Credentials
	 @PostMapping("/login")
	 public String login(@ModelAttribute(name="loginForm") Login login, Model m) {
	  String uname = login.getUsername();
	  String pass = login.getPassword();
	  if(uname.equals("Admin") && pass.equals("Admin@123")) {
	   m.addAttribute("uname", uname);
	   m.addAttribute("pass", pass);
	   m.addAttribute("error", uname);
	   return "welcome";
	  }
	  m.addAttribute("error", "Incorrect Username & Password");
	  return "login";
	 }
	 
		/*templates
		 * <!DOCTYPE html> <html xmlns:th="http://www.thymeleaf.org"> <head> <meta
		 * http-equiv="Content-Type" content="text/html; charset=UTF-8"/> <title> ISA fy
		 * 7aga ht4t8l f 2om dah project</title> </head> <body> <p
		 * th:text=" 'Hello, ' + ${name} + '!' "/> <h4> ISA fy 7aga ht4t8l f 2om dah
		 * project</h4> </body> </html>
		 */
	 
		/*static
		 * <!DOCTYPE html> <html xmlns:th="http://www.thymeleaf.org"> <head> <meta
		 * http-equiv="Content-Type" content="text/html; charset=UTF-8"/> <title> ISA fy
		 * 7aga ht4t8l f 2om dah project</title> </head> <body> <p
		 * th:text=" 'Hello, ' + ${name} + '!' "/> <h4> ISA fy 7aga ht4t8l f 2om dah
		 * project</h4> </body> </html>
		 */
	 		
	 		

	 		

}
