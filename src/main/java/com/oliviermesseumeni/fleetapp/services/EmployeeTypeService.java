package com.oliviermesseumeni.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliviermesseumeni.fleetapp.models.EmployeeType;
import com.oliviermesseumeni.fleetapp.models.EmployeeType;
import com.oliviermesseumeni.fleetapp.repositories.EmployeeTypeRepository;
import com.oliviermesseumeni.fleetapp.repositories.EmployeeTypeRepository;

@Service
public class EmployeeTypeService {
	
	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;
	
	public List<EmployeeType> getEmployeeTypes()
	{
		return (List<EmployeeType>) employeeTypeRepository.findAll();
	}
	
	public void save(EmployeeType employeeType)
	{
		employeeTypeRepository.save(employeeType);
	}
	
	public void delete(Integer id)
	{
		employeeTypeRepository.deleteById(id);
	}
	
	public Optional<EmployeeType> findById(Integer id)
	{
		return employeeTypeRepository.findById(id);
	}
	
	public void update(EmployeeType employeeType)
	{
		employeeTypeRepository.save(employeeType);
	}

}
