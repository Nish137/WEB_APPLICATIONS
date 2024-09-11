package com.springBoot.Developing.Restful.API.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springBoot.Developing.Restful.API.entity.Department;
import com.springBoot.Developing.Restful.API.exception.DepartmentNotFoundException;



@Component
public interface DepartmentService {

	Department saveDepartments(Department department);

	public List<Department> getDepartments();

	public Department findDepartmentsById(Long depId) throws DepartmentNotFoundException;

	public void deleteDepartmentsById(Long departmentId);

	public Department updateDepartments(Long departmentId, Department department);

	public Department fetchDepartmentsByName(String departmentName);

}
