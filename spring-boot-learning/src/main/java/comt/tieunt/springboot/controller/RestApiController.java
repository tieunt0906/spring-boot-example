package comt.tieunt.springboot.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import comt.tieunt.springboot.model.Todo;
import comt.tieunt.springboot.service.TodoService;

@RestController
@RequestMapping("/api/v1")
public class RestApiController {
	List<Todo> todoList = new CopyOnWriteArrayList<>();
	@Autowired
	private TodoService todoService;

	@GetMapping("/todo")
	public List<Todo> getTodoList() {
		return todoService.findAll(null);
	}

	@PostMapping("/todo")
	public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
		todoList.add(todo);

		return ResponseEntity.ok().body(todo);
	}

	@GetMapping("/todo/{todoId}")
	public Todo getTodo(@PathVariable(name = "todoId") Integer todoId) {
		return todoList.get(todoId);
	}

	@PutMapping("/todo/{todoId}")
	public Todo updateTodo(@PathVariable(name = "todoId") Integer todoId, @RequestBody Todo todo) {
		todoList.set(todoId, todo);
		return todo;
	}
	
	@DeleteMapping("/todo/{todoId}")
	public ResponseEntity<?> deleteTodo(@PathVariable(name = "todoId") Integer todoId) {
		todoList.remove(todoId.intValue());
		return ResponseEntity.ok().build();
	}
}
