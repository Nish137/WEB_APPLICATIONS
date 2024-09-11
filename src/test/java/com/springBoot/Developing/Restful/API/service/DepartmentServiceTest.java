package com.springBoot.Developing.Restful.API.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springBoot.Developing.Restful.API.entity.Department;
import com.springBoot.Developing.Restful.API.repository.DepartmentRepo;

@SpringBootTest
public class DepartmentServiceTest {
	
	 @Autowired
         private  DepartmentService departmentService;
	 @MockBean
	    private DepartmentRepo departmentRepo;
	 
	 @BeforeEach
	 void Setup() { 
		
		 Department department = new Department((long) 103, "IT", "HYD", "IT-03");
		 
		 Mockito.when(departmentRepo.findByDepNameIgnoreCase("IT")).thenReturn(department);
				
		 
	 }
	 
	 @Test
	 @DisplayName("Get Data based on valid Department Name")
	 public void whenVlaidDepartmentName_thenDepartmentShouldFound(){
		 
		 
		 String departmentName= "IT";
		 Department found= departmentService.fetchDepartmentsByName(departmentName);
		System.out.println(found.getDepName());
		 assertEquals(departmentName, found.getDepName());
		 
		 
	 }

}
