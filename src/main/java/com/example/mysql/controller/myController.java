package com.example.mysql.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mysql.model.Employee;
import com.example.mysql.serviceImpl.Myserviceimpl;

@RestController
@CrossOrigin
@RequestMapping(value = "employee")
public class myController {

	@Autowired
	private Myserviceimpl service;

	@PostMapping("/newEmployee")
	public String createEmployee(@RequestBody Employee newemp) {
		service.addNewEmployee(newemp);
		return "added successfully";
	}

	@GetMapping("/allEmployee")
	public List<Employee> getAllEmpoyee() {
		return service.getAllEmployee();
	}

	@GetMapping("/getEmployee/{id}")
	public Employee getEmployee(@PathVariable Integer id) throws Exception {
		Optional<Employee> emp = service.getEmployeeById(id);
		if (!emp.isPresent())
			throw new Exception("Id not found " + id);
		return emp.get();
	}

	@PutMapping("/getUpdate/{id}")
	public String getUpdate(@RequestBody Employee emp, @PathVariable Integer id) throws Exception {
		Optional<Employee> empop = service.getEmployeeById(id);
		if (!empop.isPresent()) {
			throw new Exception("not found in database");
		}
		if (emp.getEname() == null || emp.getEname().isEmpty()) {
			emp.setEname(empop.get().getEname());
		}
		if (emp.getDepartment() == null || emp.getDepartment().isEmpty()) {
			emp.setDepartment(empop.get().getDepartment());
		}
		if (emp.getSalary() == 0) {
			emp.setSalary(empop.get().getSalary());
		}
		emp.setId(id);
		service.updateEmployee(emp);
		return "updated successfully";
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployeeById(@PathVariable Integer id) throws Exception {
		Optional<Employee> emp = service.getEmployeeById(id);
		if (!emp.isPresent())
			throw new Exception("id not present");
		service.deleteById(id);
		return "delete successfully";
	}
}
