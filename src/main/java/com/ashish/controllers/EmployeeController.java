package com.ashish.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashish.models.Employee;
import com.ashish.services.EmployeeService;

@Controller
public class EmployeeController 
{
	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/")
	public String getHomeView()
	{
		return "home";
	}
	
	@RequestMapping("/add")
	public String getAddEmployeeView()
	{
		return "add-employee";
	}
	
	@RequestMapping("/save-record")
	public String saveEmployeeRecord(Employee emp)
	{
		service.saveRecord(emp);
		return "save-success";
	}
	
	@RequestMapping("list")
	public String employeeList(Model model)
	{
		List<Employee> list = service.getList();
		model.addAttribute("elist", list);
		return "employee-list";
	}
	
	@RequestMapping("/delete-record")
	public String deleteEmployeeRecord(int eid)
	{
		service.deleteRecord(eid);
		return "redirect:/list";
	}
	
	@RequestMapping("/edit-record")
	public String editEmployeeRecord(int eid,Model model)
	{
		Employee emp = service.getRecord(eid);
		model.addAttribute("employee",emp);
		return "edit-employee";
	}
	
	@RequestMapping("/update-record")
	public String updateEmployeeRecord(Employee emp)
	{
		service.saveRecord(emp);
		return "redirect:/list";
	}
	
	@RequestMapping("/search")
	public String getSearchView(Model model)
	{
		List<String> list = service.getAllCity();
		model.addAttribute("list", list);
		return "search";
	}
	
	@RequestMapping("/listByCity")
	public String employeeListByCity(Model model,String city)
	{
		List<Employee> list = service.getListByCity(city);
		model.addAttribute("elist", list);
		return "search-list";
	}
	
	@RequestMapping("/listByName")
	public String employeeListByName(Model model,String name)
	{
		List<Employee> list = service.getListByName(name);
		if(list.isEmpty())
		{
			model.addAttribute("msg","No Emplyee found with "+name+" name");
			return "not-found";
		}
		model.addAttribute("elist", list);
		return "search-list";
	}
	
	@RequestMapping("/byId")
	public String employeeById(Model model,int eid)
	{
		Employee emp = service.getEmployeeById(eid);
		if(emp==null)
		{
			model.addAttribute("msg","Employee with id "+eid+" not found");
			return "not-found";
		}
		model.addAttribute("employee", emp);
		return "show-record";
	}
}
