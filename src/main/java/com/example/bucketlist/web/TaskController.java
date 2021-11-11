package com.example.bucketlist.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bucketlist.domain.CategoryRepository;
import com.example.bucketlist.domain.Task;
import com.example.bucketlist.domain.TaskRepository;
import com.example.bucketlist.domain.UserRepository;


@Controller
public class TaskController {
	@Autowired
	private TaskRepository repository; 
	
	@Autowired
	private CategoryRepository crepository; 
	
	@Autowired
	private UserRepository urepository; 
	
	
	// Show all tasks
    @RequestMapping(value="/login")
    public String login(Model model) {	
    	 model.addAttribute("tasks", repository.findAll());
        return "login";
    }	
	
	
    @RequestMapping(value= {"/", "/tasklist"})
    public String taskList(Model model) {
    	System.out.println("hei");
    	
        model.addAttribute("tasks", repository.findAll());
        return "tasklist";       
    }
    
    //REST
    @RequestMapping(value="/tasks", method = RequestMethod.GET)
    public @ResponseBody List<Task> taskListRest() {
    return (List<Task>) repository.findAll();
    }
    
    //REST
    @RequestMapping(value="/task/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Task> findTaskRest(@PathVariable("id") Long taskId) {	
    	return repository.findById(taskId);
    } 
    
    
    // Add new task
    @RequestMapping(value = "/add")
    public String addTask(Model model){
    	 System.out.println("moi");
    	
    	model.addAttribute("task", new Task());
    	model.addAttribute("categories", crepository.findAll());
    	model.addAttribute("users", urepository.findByUsername("seppohovi"));
    
        return "addtask";
    }     
    
    // @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}", method= RequestMethod.GET)
    public String editTask(@PathVariable("id") Long taskId, Model model){
    	System.out.println("terve");
    	
    	model.addAttribute("task" , repository.findById(taskId));
    	model.addAttribute("categories", crepository.findAll());
    	
        return "edittask";
    }
    
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Task task){
    	System.out.println("moro");
    	
    	repository.save(task);
           
        return "redirect:tasklist";
    }    

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTask(@PathVariable("id") Long taskId, Model model) {
   	 	System.out.println("tere");
    	
    	repository.deleteById(taskId);
    	
        return "redirect:../tasklist";
    }     
}
