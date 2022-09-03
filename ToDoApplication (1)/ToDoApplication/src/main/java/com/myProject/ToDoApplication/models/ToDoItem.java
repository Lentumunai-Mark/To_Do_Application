package com.myProject.ToDoApplication.models;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
public class ToDoItem{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @NotBlank(message = "Description required")
    private String description;


    @Getter
    @Setter
    private boolean complete;
    
    //java time instant classes
    @Getter
    @Setter
    private Instant createdDate;

    @Getter
    @Setter
    private Instant modifiedDate;
    //default constructor
    public ToDoItem(){
    }
    //constructor method with just the description.
    public ToDoItem(String description){
        this.description = description;
        this.complete = false;
        this.createdDate = Instant.now();
        this.modifiedDate = Instant.now();
    }

    @Override
    public String toString(){
        return String.format("TodiItem{id = %d,  description = '%s',  complete='%s', createdDate='%s', modifiedDate='%s'}", id, description, complete, createdDate, modifiedDate);
    }

}