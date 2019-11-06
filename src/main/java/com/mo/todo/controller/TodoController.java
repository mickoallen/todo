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
            priorityStored = Priority.valueOf(priority.toUpperCase());
        } catch(IllegalArgumentException e){
            priorityStored = Priority.ALL;
        }
//        List<Todo> todos = todoService.getTodo(priorityStored);
        List<Todo> list = new ArrayList<>();
        Todo todo = new Todo();
        todo.setChore("Your mom");
        todo.setId(1);
        Todo todo2 = new Todo();
        todo2.setId(2);
        todo2.setChore("Your mom again");
        list.add(todo);
        list.add(todo2);
        return list;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addTodo(@RequestBody  Todo todo) {
        ObjectMapper mapper = new ObjectMapper();
//        Todo todoConverted = mapper.readValue(todo, Todo.class);
        todoService.addTodo(todo);
    }

    @RequestMapping(value = "/alive", method = RequestMethod.GET)
    public @ResponseBody String health() {
       return "WE ARE ALIVE";
    }
}
