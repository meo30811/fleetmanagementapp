package com.oliviermesseumeni.fleetapp.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.oliviermesseumeni.fleetapp.models.Employee;
import com.oliviermesseumeni.fleetapp.services.CountryService;
import com.oliviermesseumeni.fleetapp.services.EmployeeService;
import com.oliviermesseumeni.fleetapp.services.EmployeeTypeService;
import com.oliviermesseumeni.fleetapp.services.JobTitleService;
import com.oliviermesseumeni.fleetapp.services.StateService;

@Controller
public class EmployeeController {
	
	@Autowired	private EmployeeService employeeService;
	@Autowired	private JobTitleService jobTitleService;
	@Autowired	private EmployeeTypeService employeeTypeService;
	@Autowired	private CountryService countryService;
	@Autowired	private StateService stateService;


	
	

	@GetMapping("/employees")
	public String getEmployees(Model model, String keyword) {	
		
		model.addAttribute("jobTitles", jobTitleService.getJobTitles());		
	    model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());
		model.addAttribute("countries", countryService.getCountries());			
		model.addAttribute("states", stateService.getStates());		

		if(keyword != null){
			model.addAttribute("employees", employeeService.findByKeyword(keyword));
		}
		else 
		{
		     model.addAttribute("employees", employeeService.getEmployees());			
		}
		
		return "Employee";
	}	
	
	@GetMapping("/employeesFiltered")
	public String getEmployeesFiltered(Model model, String keyword) {	
		
		model.addAttribute("jobTitles", jobTitleService.getJobTitles());		
	    model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());
		model.addAttribute("countries", countryService.getCountries());			
		model.addAttribute("states", stateService.getStates());		

	   model.addAttribute("employees", employeeService.getEmployees());			

		
		return "EmployeeFiltered";
	}
	
	
	
	@PostMapping("/employees/addNew")
	public String addNew(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees";
	}
	
	@RequestMapping("employees/findById")
	@ResponseBody
	public Optional<Employee> findById(int id) {
	  return employeeService.findById(id);	
	}	
	
	@RequestMapping(value="/employees/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees";
	}
	
	@RequestMapping(value="/employees/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		employeeService.delete(id);
		return "redirect:/employees";
	}
	
}
