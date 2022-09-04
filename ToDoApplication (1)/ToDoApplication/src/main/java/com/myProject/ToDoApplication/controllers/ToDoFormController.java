package com.myProject.ToDoApplication.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.myProject.ToDoApplication.models.ToDoItem;
import com.myProject.ToDoApplication.repositories.ToDoItemRepository;

@Controller
public class ToDoFormController {
    Logger logger = LoggerFactory.getLogger(ToDoFormController.class);
    
    @Autowired
    ToDoItemRepository toDoItemRepository;
    
    @GetMapping("/create-todo")
    public String showCreateForm(ToDoItem todoItem){
        return "add-todo-item";
    }
    
    @GetMapping("/edit/{id}")
    public String showUpdatedForm(@PathVariable("id") long id, Model model){
        ToDoItem todoItem = toDoItemRepository
        .findById(id)
        .orElseThrow(()->new IllegalArgumentException("Todo Item " + id + "Not Found"));
        model.addAttribute("todo", todoItem);
        return "update-to-do-item";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") long id, Model model){
        ToDoItem todoItem = toDoItemRepository
        .findById(id)
        .orElseThrow(()->new IllegalArgumentException("Todo Item " + id + "Not Found"));
        toDoItemRepository.delete(todoItem);
        return "redirect:/";
    }
}
  