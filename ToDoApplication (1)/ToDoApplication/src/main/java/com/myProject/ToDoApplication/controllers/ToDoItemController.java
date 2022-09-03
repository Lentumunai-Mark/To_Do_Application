package com.myProject.ToDoApplication.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myProject.ToDoApplication.repositories.ToDoItemRepository;

@Controller

public class ToDoItemController {
    private final Logger logger = LoggerFactory.getLogger(ToDoItemController.class);
    @Autowired
    ToDoItemRepository todDoItemRepository;
    // methods
    // root page
    @GetMapping("/")
    public ModelAndView index() {
        logger.info("request to GET index");
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("todoItems", todDoItemRepository.findAll());
        return modelAndView;
    }
}
