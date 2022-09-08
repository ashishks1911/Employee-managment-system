package com.ashish.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ashish.models.Employee;

@Service
public interface EmployeeService {

	void saveRecord(Employee emp);

	List<Employee> getList();

	void deleteRecord(int eid);

	Employee getRecord(int eid);

	List<String> getAllCity();

	List<Employee> getListByCity(String city);

	List<Employee> getListByName(String name);

	Employee getEmployeeById(int eid);

}
