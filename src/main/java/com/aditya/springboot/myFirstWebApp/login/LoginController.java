package com.aditya.springboot.myFirstWebApp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name_e")            //Session Scope
public class LoginController {
	
	private AuthenticationService auth_service;
	
//	//this handles both both GET and POST request
//	@RequestMapping("login")    
//	public String gotoLoginPage() {
//		return "sayLogin";
//	}
	
	
	
	public LoginController(AuthenticationService auth_service) {
		super();
		this.auth_service = auth_service;
	}



	@RequestMapping(value="login" , method = RequestMethod.GET )    
	public String gotoLoginPage() {
		return "sayLogin";
	}
	
	
	
	
	@RequestMapping(value="login" , method = RequestMethod.POST )    
	public String gotoWelcomPage(@RequestParam String name , @RequestParam String password , ModelMap model) {
		
		if (auth_service.authenticate(name, password)) {
		model.put("name_e", name);
		
//		model.put("[pass_s", password);
		
		//Authentication
		//name:Aditya
		//pass:A@1
		
		return "sayWelcome";
		}
		
		
		else {
			
			model.put("error_message", "Please enter valid credentials: Please try again!!");
			return "sayLogin";
		}
		
	}	

}

