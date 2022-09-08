package com.ashish.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashish.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>
{
	@Query("select distinct e.city from Employee e")
	List<String> findAllCity();
	List<Employee> findByCity(String city);
	List<Employee> findByName(String name);
	List<Employee> findByDepartment(String department);
	
	
}
