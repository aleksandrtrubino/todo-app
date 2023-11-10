package com.trubino.todoapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
public class TodoServiceImpl implements TodoService {
    @Autowired
    TodoRepository todoRepository;
    @Override
    public List<Todo> findAllTodos() {
        return todoRepository.findAll();
    }

    @Override
    public Optional<Todo> findTodoById(long id) {
        return todoRepository.findById(id);
    }

    @Override
    public void deleteAllTodos() {
        todoRepository.deleteAll();
    }

    @Override
    public void deleteTodoById(long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public Todo createTodo(Todo todo) {
        todo.setLastChangeTime(LocalDateTime.now());
        return todoRepository.save(todo);
    }

    @Override
    public Optional<Todo> updateTodoById(long id, Todo todo) {
        Optional<Todo> todoById =  todoRepository.findById(id);
        if(todoById.isPresent()){
            todoById.get().setTitle(todo.getTitle());
            todoById.get().setDescription(todo.getDescription());
            todoById.get().setIsDone(todo.getIsDone());
            todoById.get().setLastChangeTime(LocalDateTime.now());
            return Optional.of(todoRepository.save(todoById.get()));
        }else
            return Optional.empty();
    }
}
