package com.mo.todo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mo.todo.model.Priority;
import com.mo.todo.model.Todo;
import com.mo.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public @ResponseBody List<Todo> getTodo(@RequestParam(name = "priority", required=false, defaultValue="") String priority){
        Priority priorityStored;
        try {
            priorityStored = Priority.valueOf(priority);
            return todoService.getAllTodosforPriority(priorityStored);
        } catch(IllegalArgumentException e){
            return todoService.getAllTodos();
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addTodo(@RequestBody  Todo todo) {
        ObjectMapper mapper = new ObjectMapper();
//        Todo todoConverted = mapper.readValue(todo, Todo.class);
        todoService.addTodo(todo);
    }

    @RequestMapping(value = "/removeAll", method = RequestMethod.POST)
    public void removeAllTodo() {
        todoService.removeAll();
    }

    @RequestMapping(value = "/alive", method = RequestMethod.GET)
    public @ResponseBody String health() {
       return "WE ARE ALIVE";
    }
}
