package com.oliviermesseumeni.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oliviermesseumeni.fleetapp.models.Country;
import com.oliviermesseumeni.fleetapp.models.EmployeeType;
import com.oliviermesseumeni.fleetapp.models.EmployeeType;
import com.oliviermesseumeni.fleetapp.models.State;
import com.oliviermesseumeni.fleetapp.services.CountryService;
import com.oliviermesseumeni.fleetapp.services.EmployeeTypeService;
import com.oliviermesseumeni.fleetapp.services.EmployeeTypeService;
import com.oliviermesseumeni.fleetapp.services.StateService;

@Controller
public class EmployeeTypeController {
	
	@Autowired
	EmployeeTypeService employeeTypeService;
	@Autowired
	StateService stateService;
	@Autowired
	CountryService countryService;
	
	@GetMapping("/employeetypes")
	public String getEmployeeTypes(Model model)
	{
	   List<EmployeeType> employeeTypeList = employeeTypeService.getEmployeeTypes();
	   List<Country> countryList = countryService.getCountries();
	   List<State> stateList = stateService.getStates();
	   
	   model.addAttribute("employeeTypes", employeeTypeList);
	   model.addAttribute("states", stateList);
	   model.addAttribute("countries", countryList);
	   return "employeetype";
	}
	
	@GetMapping("/employeetypes/findById")
	@ResponseBody
	public Optional<EmployeeType> findById(Integer id)
	{
		return employeeTypeService.findById(id);
		
	}
	
	@PostMapping("/employeetypes/addNew")
	public String addNew(EmployeeType employeeType)
	{
		employeeTypeService.save(employeeType);
		return "redirect:/employeetypes";
	}
	
	@RequestMapping(value="/employeetypes/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(EmployeeType employeeType)
	{
		employeeTypeService.update(employeeType);
		return "redirect:/employeetypes";
	}
	@RequestMapping(value="/employeetypes/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
		employeeTypeService.delete(id);
		return "redirect:/employeetypes";
	}
}
