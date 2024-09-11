	package com.springBoot.Developing.Restful.API.controller;
	
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	import org.mockito.Mockito;
	import org.mockito.stubbing.Answer;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
	import org.springframework.boot.test.mock.mockito.MockBean;
	import org.springframework.http.MediaType;
	import org.springframework.test.web.servlet.MockMvc;
	import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
	import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.springBoot.Developing.Restful.API.entity.Department;
import com.springBoot.Developing.Restful.API.service.DepartmentService;
	
	@WebMvcTest
	public class DepartmentControllerTest {
		@Autowired
		private DepartmentController departmentController;
		MockMvc mockMvc;
		
		@MockBean
		private DepartmentService departmentService;
	
		Department inputdepartment = new Department();
		Department department = new Department();
		@BeforeEach
		void setup() {
		            department.setDepID(1l);
					department.setDepAddress("Hyderbad");
					department.setDepCode("IT-033");
					department.setDepName("Information Technology");
			
			
		}
		@Test
		public void saveDepartments() throws Exception {
			
				
				
			
			inputdepartment.setDepAddress("Hyderbad");
				inputdepartment.setDepCode("IT-033");
				inputdepartment.setDepName("Information Technology");
				
			
			Mockito.when(departmentService.saveDepartments(inputdepartment))
			.then((Answer<?>) department);
			
			mockMvc.perform(MockMvcRequestBuilders.post("/departments")
					.contentType(MediaType.APPLICATION_JSON)
					.content("\"depName\": \"Information Technology\",\r\n"
							+ "		\"depAddress\": \"Hyderabad\",\r\n"
							+ "		\"depCode\": \"IT-033\""))
					.andExpect(MockMvcResultMatchers.status().isOk());
			
			
		}
	
	}
