package com.springBoot.Developing.Restful.API.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.springBoot.Developing.Restful.API.entity.Department;

@DataJpaTest
public class DepartmentRepoTest {
	
	@Autowired
	private DepartmentRepo departmentRepo;
	
	@Autowired
	private TestEntityManager entity;
	
	
	@BeforeEach
	void setUp() {
		
		
		
		Department department = new Department(
				1l, "Information Technology", "Hyderabad", "IT-033");
		
		entity.persist(department);
	}
	
	@Test
	public void whenFoundById_thenReturnDepartment() {
		
		Department department = departmentRepo.findById(1l).get();
		
		assertEquals(department.getDepName(), "Information Technology");
		
	}

}
