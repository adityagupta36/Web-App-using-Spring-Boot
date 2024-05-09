package com.aditya.springboot.myFirstWebApp.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SayHelloController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	//"say-hello"  ==>  "Hello! What are u learning today?"

	@RequestMapping("say-hello")                    //http://localhost:8080/say-hello
	@ResponseBody
	public String sayHello() {
		return "Hello! What are u learning today?";
	}
	
	@RequestMapping("say-hello-html")                   
	@ResponseBody
	public StringBuffer sayHelloHtml() {
		
		
		//very complex = HTML Response  => advance version: views(most popular view tech : JSP)
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My first HTML page </title>");		
		sb.append("</head>");
		sb.append("<body>");		
		sb.append("My first HTML page with Body");
		sb.append("</body>");		
		sb.append("</html>");
		
	
		return sb;
	}
	
	
	@RequestMapping("say-hello-jsp")                    
	public String sayHelloJsp(@RequestParam String name , ModelMap model) {
		
		
		logger.debug("Request param is : {}", name );
		logger.info("Info level LOGGER" );
		logger.warn("Warn Level LOGGER");


		
		model.put("namee", name);  //@requestparam String name is linked to ModelMap and with model having key and value
		
//		System.out.println("Request param is : " + name);  //Not recommended for prod code
		
		return "sayHello";    //sayHello=> view name  ==> [front controller]dispatcher servlet map sayHello to sayHello.jsp using view resolver
		
	}
	
	
	
	
	
}
