package com.myProject.ToDoApplication.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.myProject.ToDoApplication.models.ToDoItem;
import com.myProject.ToDoApplication.repositories.ToDoItemRepository;
//for test purposes upon load up of our application
@Component
public class ToDoItemLoader implements CommandLineRunner{
    private final Logger logger = LoggerFactory.getLogger(ToDoItemLoader.class);
    @Autowired
    ToDoItemRepository toDoItemRepository;

    @Override
    public void run(String... args) throws Exception{
        loadSeedData();
    }
    private void loadSeedData(){
        //check if database is empty
        if(toDoItemRepository.count() == 0){
            ToDoItem toDoItem1 = new ToDoItem("finish up on dynamic programming lecture");
            ToDoItem toDoItem2 =new ToDoItem("Finish up on final year project");
            toDoItemRepository.save(toDoItem1);
            toDoItemRepository.save(toDoItem2);
        }
        logger.info("number of to do items: {}", toDoItemRepository.count());
    }
             
    
}
