package com.aditya.springboot.myFirstWebApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class ToDoService {
	
	
	private static List<ToDo> todos = new ArrayList<ToDo>();
	
	private static int todosCount = 0;
	
	static {
		
		todos.add(new ToDo( ++todosCount, "aditya_gupta", "Learn AWS", LocalDate.now().plusYears(1), false));
		
		todos.add(new ToDo(++todosCount, "aditya_gupta", "Learn DEVOPS", LocalDate.now().plusYears(2), false));

		todos.add(new ToDo(++todosCount, "aditya_gupta", "Learn SPRING", LocalDate.now().plusYears(3), false));

		todos.add(new ToDo(++todosCount, "aditya_gupta", "Learn SPRING BOOT", LocalDate.now().plusYears(4), false));

		todos.add(new ToDo(++todosCount, "aditya_gupta", "Learn REACT", LocalDate.now().plusYears(5), false));

	}
	
	
	public void addToDo(String username, String description, LocalDate targetDate, boolean done) {
		
		ToDo todo = new ToDo(++todosCount, username, description,targetDate ,done);
		todos.add(todo);
		
	}
	
	public List<ToDo> findByUserName(String username){
		return todos;
	}
	
	
}