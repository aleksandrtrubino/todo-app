package com.trubino.todoapp.todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {
    List<Todo> findAllTodos();
    Optional<Todo> findTodoById(long id);
    void deleteAllTodos();
    void deleteTodoById(long id);
    Todo createTodo(Todo todo);
    Optional<Todo> updateTodoById(long id, Todo todo);
}
