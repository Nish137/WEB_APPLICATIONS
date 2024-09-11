package com.springBoot.Developing.Restful.API.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.Developing.Restful.API.entity.Department;
import com.springBoot.Developing.Restful.API.exception.DepartmentNotFoundException;
import com.springBoot.Developing.Restful.API.service.DepartmentService;

import jakarta.validation.Valid;



@RestController
public class DepartmentController {
	
  // Adding Loggers 
	
	private final Logger LOGGER=LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService departmentService;

   
//    @Value("${welcome.message}")
//    private String welcomeMessage;
	/*
	 * // @RequestMapping(value = "/greetings",method = RequestMethod.GET) // public
	 * String greeting(){ // // System.out.println("Hello SpringBoot"); // return
	 * welcomeMessage; // }
	 *///  
	
	
	@GetMapping("/hekoo")
	public String hello() {
		return "Hello";
	}
   @PostMapping("/departments")
    public Department saveDepartments(@Valid @RequestBody Department department) {
	   LOGGER.info("Controller is in to saveDepartments API");
    	return departmentService.saveDepartments(department);
  }
   
   @GetMapping("/departments")
   public List<Department> getDepartments() {
	   LOGGER.info("Controller is in to getDepartments API");
   	return departmentService.getDepartments();
 }
   
   @GetMapping("/departments/{id}")
   
   public Department findDepartmentsById(@PathVariable("id") Long depId) throws DepartmentNotFoundException {
	   LOGGER.info("Controller is in to findDepartmentsById API");
	  
	return departmentService.findDepartmentsById(depId);
	   
   }
   
   @DeleteMapping("/departments/{id}")
   public String deleteDepartmentsById(@PathVariable("id")Long departmentId) {
	   LOGGER.info("Controller is in to deleteDepartmentsById API");
	   
	   departmentService.deleteDepartmentsById(departmentId);
	   
	return "Department Deleted Successfully";
	   
   }
   
   @PutMapping("/departments/{id}")  
   public Department updateDepartments(@PathVariable("id") Long departmentId, 
		                               @RequestBody Department department) {
	   
	   LOGGER.info("Controller is in to updateDepartments API");
   return departmentService.updateDepartments(departmentId,department);
	   
   }
   
   @GetMapping("/departments/name/{name}")
   public Department fetchDepartmentsByName(@PathVariable("name")String departmentName) {
	   LOGGER.info("Controller is in to fetchDepartmentsByName API");
	return departmentService.fetchDepartmentsByName(departmentName);
	   
   }
   
   
   
   
   
    
   
}
