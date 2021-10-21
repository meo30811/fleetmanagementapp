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
import com.oliviermesseumeni.fleetapp.services.CountryService;

@Controller
public class CountryController {
	
	@Autowired 
	private CountryService countryservice;
	
	@GetMapping("/countries")
	public String getCountries(Model model)
	{
		List<Country> countryList = countryservice.getCountries();
		model.addAttribute("countries", countryList);
		return "country";
	}
	
	@PostMapping("/countries/addNew")
	public String addNew(Country country)
	{
		countryservice.save(country);
		return "redirect:/countries";
	}
	
	@RequestMapping("/countries/findById")
	@ResponseBody
	public Optional<Country> findById(Integer id)
	{
		return countryservice.findById(id);
	}
	@RequestMapping(value="/countries/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Country country)
	{
		countryservice.update(country);
		return "redirect:/countries";
	}
	@RequestMapping(value="/countries/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
		countryservice.delete(id);
		return "redirect:/countries";
	}
}
