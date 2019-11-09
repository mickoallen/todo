package com.mo.todo.service;

import com.mo.todo.model.Priority;
import com.mo.todo.model.Todo;
import com.mo.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepository todoRepository;

    @Override
    public List<Todo> getTodo(Priority priority) {
        return todoRepository.findByPriority(priority);

    }

    public void addTodo(Todo todo) {
        if (todoRepository.findByChore(todo.getChore()) == null){
            todoRepository.save(todo);
        } else {
            throw new RuntimeException("NIGGA");
        }
    }

    public List<Todo> getFinishedAndPriority(boolean finished, Priority priority){
        return todoRepository.findByFinishedAndPriority(finished, priority);
    }

    @Override
    public List<Todo> getAllTodosforPriority(Priority priority) {
        return getTodo(priority);
    }

    @Override
    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        for (Priority priorityEnum : Priority.values()) {
            List<Todo> newList = new ArrayList<>( getTodo(priorityEnum));
            todos.addAll(newList);
        }
        return todos;
    }

    @Override
    public void removeAll() {
        todoRepository.deleteAll();
    }
}
