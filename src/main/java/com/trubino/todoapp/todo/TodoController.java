package com.trubino.todoapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {
    @Autowired
    TodoService todoService;
    @GetMapping("/find-all-todos")
    ResponseEntity<List<Todo>> findAllTodos(){
        return new ResponseEntity<>(todoService.findAllTodos(), HttpStatus.OK);
    }
    @GetMapping("/find-todo-by-id/{id}")
    ResponseEntity<Optional<Todo>> findTodoById(@PathVariable long id){
        return new ResponseEntity<>(todoService.findTodoById(id),HttpStatus.OK);
    }
    @DeleteMapping("/delete-all-todos")
    ResponseEntity<Void> deleteAllTodos(){
        todoService.deleteAllTodos();
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete-todo-by-id/{id}")
    ResponseEntity<Void> deleteTodoById(@PathVariable long id) {
        todoService.deleteTodoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/create-todo")
    ResponseEntity<Todo> createTodo(@RequestBody Todo todo){
        return new ResponseEntity<>(todoService.createTodo(todo),HttpStatus.CREATED);
    }
    @PutMapping("/update-todo-by-id/{id}")
    ResponseEntity<Optional<Todo>> updateTodo(@PathVariable long id, @RequestBody Todo todo){
        if(todoService.updateTodoById(id,todo).isPresent())
            return new ResponseEntity<>(todoService.updateTodoById(id,todo),HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
