package igt.todolist.igttodolist.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import igt.todolist.igttodolist.model.ToDoTask;
import igt.todolist.igttodolist.repo.MyTaskRepo;

/**
 * @file: MainController.java
 * @author: Arun Dhwaj
 * @date: 5th Oct, 2018
 * @purpose: Creating MainController class, which handling all the RestEndPoints. 
 */

public class MainController 
{
	@Autowired
	MyTaskRepo repository;
	
    private static Logger logger = LoggerFactory.getLogger(MainController.class);
	
    @RequestMapping(value = "/saveToDoTask", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<Boolean> process(@RequestBody ToDoTask task)
    {
    	logger.info("Request: Save ToDoTask: ", task.toString());
    	try 
    	{
    		repository.save(task);
    		
    		return MyResponseEntity.ok(Boolean.TRUE);
    	} 
    	catch (Exception ex) 
    	{
    		return MyResponseEntity.error(HttpStatus.BAD_REQUEST,"Error occured during saving: ToDoTask: " + task.toString());
    	}
    }
    
    @RequestMapping(value = "/updateToDoTask", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<Boolean> updateTask(@RequestBody ToDoTask task)
    {
    	logger.info("Request: updating ToDoTask: ", task.toString());

        try 
        {
        	ToDoTask taskNew  = repository.findByTaskId(task.getTaskId());
       	 	taskNew.setTaskType(task.getTaskType());
       	 	repository.save(taskNew);
       	 	
            return MyResponseEntity.ok(Boolean.TRUE);
        } 
        catch (Exception ex) 
        {
            return MyResponseEntity.error(HttpStatus.BAD_REQUEST,"Error occured during: Updating: " + task.toString());
        }
    }
    
    @RequestMapping(path = "/deleteToDoTask/{taskId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteTaskEntity(@PathVariable("taskId") Long taskId) 
    {
        logger.info("Request: deleting ToDoTask with id: ", taskId);
        
        try 
        {
            repository.delete(taskId);
            return MyResponseEntity.ok(Boolean.TRUE);
        } 
        catch (Exception ex) 
        {
            return MyResponseEntity.error(HttpStatus.BAD_REQUEST,"Error occured during: deleting: " + taskId);
        }
    }
}
