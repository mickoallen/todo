package com.mo.todo.service;

import com.mo.todo.model.Priority;
import com.mo.todo.model.Todo;

import java.util.List;

public interface TodoService {
    List<Todo> getTodo(Priority priority);
    void addTodo(Todo todo);
    List<Todo> getFinishedAndPriority(boolean finished, Priority priority);
    List<Todo> getAllTodosforPriority(Priority priority);
    List<Todo> getAllTodos();
}
