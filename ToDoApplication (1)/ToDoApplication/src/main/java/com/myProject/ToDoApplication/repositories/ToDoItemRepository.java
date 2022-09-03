package com.myProject.ToDoApplication.repositories;

import org.springframework.data.repository.CrudRepository;

import com.myProject.ToDoApplication.models.ToDoItem;

public interface ToDoItemRepository extends CrudRepository<ToDoItem, Long>{
    //no method as at now
}
