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
import com.oliviermesseumeni.fleetapp.models.State;
import com.oliviermesseumeni.fleetapp.services.CountryService;
import com.oliviermesseumeni.fleetapp.services.StateService;

@Controller
public class StateController {
	
	@Autowired
	private StateService stateservice;
	@Autowired
	private CountryService countryservice;
	
	@GetMapping("/states")
	public String getStates(Model model)
	{
		List<State> stateList = stateservice.getStates();
		List<Country> countryList = countryservice.getCountries();
		model.addAttribute("countries", countryList);
		model.addAttribute("states", stateList);
		return "state";
	}
	
	@GetMapping("/states/findById")
	@ResponseBody
	public Optional<State> findById(Integer id)
	{
		return stateservice.findById(id);
	}
	@PostMapping("/states/addNew")
	public String addNew(State state)
	{
		stateservice.save(state);
		return "redirect:/states";
	}
	@RequestMapping(value="/states/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(State state)
	{
		stateservice.update(state);
		return "redirect:/states";
	}
	@RequestMapping(value="/states/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
		stateservice.delete(id);
		return "redirect:/states";
	}
}
