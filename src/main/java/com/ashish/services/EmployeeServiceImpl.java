package com.ashish.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.models.Employee;
import com.ashish.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	@Autowired
	private EmployeeRepository repo;

	@Override
	public void saveRecord(Employee emp) 
	{
		repo.save(emp);
	}

	@Override
	public List<Employee> getList() 
	{
		return repo.findAll();
	}

	@Override
	public void deleteRecord(int eid) 
	{
		repo.deleteById(eid);
	}

	@Override
	public Employee getRecord(int eid) 
	{
		return repo.findById(eid).orElse(null);
	}

	@Override
	public List<String> getAllCity() 
	{
		return repo.findAllCity();
	}

	@Override
	public List<Employee> getListByCity(String city) 
	{
		return repo.findByCity(city);
	}

	@Override
	public List<Employee> getListByName(String name) 
	{
		return repo.findByName(name);
	}

	@Override
	public Employee getEmployeeById(int eid) 
	{
		return repo.findById(eid).orElse(null);
	}
}
