package com.springBoot.Developing.Restful.API.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.Developing.Restful.API.entity.Department;
import com.springBoot.Developing.Restful.API.exception.DepartmentNotFoundException;
import com.springBoot.Developing.Restful.API.repository.DepartmentRepo;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	//private final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);
	
	@Autowired
	private DepartmentRepo departmentRepo;

	@Override
	public Department saveDepartments(Department department) {
		
		
		// TODO Auto-generated method stub
		return departmentRepo.save(department) ;
	}

	@Override
	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		return departmentRepo.findAll();
	}

	@Override
	public Department findDepartmentsById(Long depId) throws DepartmentNotFoundException {
		// TODO Auto-generated method stub
		Optional<Department> department=departmentRepo.findById(depId);
		if(!department.isPresent()) {
			throw new DepartmentNotFoundException("Department is not avaliable for the provided Id");
		}
		return department.get();
	}

	@Override
	public void deleteDepartmentsById(Long departmentId) {
          departmentRepo.deleteById(departmentId);
		
	}

	@Override
	public Department updateDepartments(Long departmentId, Department department) {
		
		Department depDb= departmentRepo.findById(departmentId).get();
		
		if((Objects.nonNull(department.getDepID())&&
				!"".equalsIgnoreCase(department.getDepID().toString()))){
			depDb.setDepID(department.getDepID());
				
			}
		if((Objects.nonNull(department.getDepName())&&
			!"".equalsIgnoreCase(department.getDepName()))){
			depDb.setDepName(department.getDepName());
			
		}
		if((Objects.nonNull(department.getDepAddress())&&
				!"".equalsIgnoreCase(department.getDepAddress()))){
				depDb.setDepAddress(department.getDepAddress());
				
			}
		if((Objects.nonNull(department.getDepCode())&&
				!"".equalsIgnoreCase(department.getDepCode()))){
				depDb.setDepCode(department.getDepCode());
				
			}
		// TODO Auto-generated method stub
		return departmentRepo.save(depDb);
	}

	@Override
	public Department fetchDepartmentsByName(String departmentName) {
		// TODO Auto-generated method stub
		return departmentRepo.findByDepNameIgnoreCase(departmentName);
	}



	

}
