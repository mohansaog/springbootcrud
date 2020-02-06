package com.example.mysql.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mysql.model.Employee;

public interface Mydaorepository extends JpaRepository<Employee, Integer> {

}
