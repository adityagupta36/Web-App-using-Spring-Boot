package com.aditya.springboot.myFirstWebApp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ch.qos.logback.core.model.Model;

@Controller
@SessionAttributes("name_e")            //Session Scope
public class ToDoController {

	private ToDoService todoService;
	
	
	public ToDoController(ToDoService todo) {
		super();
		this.todoService = todo;
	}


	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		
		List <ToDo> todos = todoService.findByUserName("aditya_gupta");
		model.put("todos", todos);
		return "ListTodos";
	}
	
	
	
	@RequestMapping(value="add-todo", method = RequestMethod.GET)
	public String showNewToDoPage() {
		
		return "todo";
	}
	
	
	@RequestMapping(value="add-todo", method = RequestMethod.POST)
	public String addNewToDoPage(@RequestParam String description, ModelMap model) {
		
		String username = (String) model.get("name_e");
		todoService.addToDo(username, description, LocalDate.now().plusYears(1), false);
		
		return "redirect:list-todos";
		
	}
	
	
}
