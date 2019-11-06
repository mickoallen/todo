package com.mo.todo.repository;

import com.mo.todo.model.Priority;
import com.mo.todo.model.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

    List<Todo> findByPriority(Priority priority);
    Todo findByChore(String chore);
    List<Todo> findByFinishedAndPriority(Boolean finished, Priority priority);
}

