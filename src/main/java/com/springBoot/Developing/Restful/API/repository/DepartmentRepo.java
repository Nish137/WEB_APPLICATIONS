package com.springBoot.Developing.Restful.API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springBoot.Developing.Restful.API.entity.Department;
@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {

	public Department findByDepName(String departmentName);
	public Department findByDepNameIgnoreCase(String departmentName);
	 

}
