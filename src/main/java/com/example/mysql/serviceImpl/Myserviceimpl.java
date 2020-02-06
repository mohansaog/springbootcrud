package com.example.mysql.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mysql.dao.Mydaorepository;
import com.example.mysql.model.Employee;

@Service
public class Myserviceimpl {
	@Autowired
    Mydaorepository dao;
	
    public Employee addNewEmployee(Employee emp) {
        return dao.save(emp);
    }

    public List<Employee> getAllEmployee() {
    	return dao.findAll();
    }
    
    public Optional<Employee> getEmployeeById(Integer id) {
    	return dao.findById(id);
    }
    
    public Employee updateEmployee(Employee emp) {
    	return dao.save(emp);
    }
    
    public void deleteById(Integer id) {
    	dao.deleteById(id);
    }
}
