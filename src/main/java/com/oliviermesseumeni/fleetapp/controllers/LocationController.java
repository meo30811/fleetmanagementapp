package com.oliviermesseumeni.fleetapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oliviermesseumeni.fleetapp.models.Country;
import com.oliviermesseumeni.fleetapp.models.Location;
import com.oliviermesseumeni.fleetapp.models.State;
import com.oliviermesseumeni.fleetapp.services.CountryService;
import com.oliviermesseumeni.fleetapp.services.LocationService;
import com.oliviermesseumeni.fleetapp.services.StateService;

@Controller
public class LocationController {
	
	@Autowired
	LocationService locationService;
	@Autowired
	StateService stateService;
	@Autowired
	CountryService countryService;
	
	@GetMapping("/locations")
	public String getLocations(Model model)
	{
	   List<Location> locationList = locationService.getLocations();
	   List<Country> countryList = countryService.getCountries();
	   List<State> stateList = stateService.getStates();
	   
	   model.addAttribute("locations", locationList);
	   model.addAttribute("states", stateList);
	   model.addAttribute("countries", countryList);
	   return "location";
	}
	
	@GetMapping("/locations/findById")
	@ResponseBody
	public Optional<Location> findById(Integer id)
	{
		return locationService.findById(id);
		
	}
	
	@PostMapping("/locations/addNew")
	public String addNew(Location location)
	{
		locationService.save(location);
		return "redirect:/locations";
	}
	
	@RequestMapping(value="/locations/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Location location)
	{
		locationService.update(location);
		return "redirect:/locations";
	}
	@RequestMapping(value="/locations/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
		locationService.delete(id);
		return "redirect:/locations";
	}
}