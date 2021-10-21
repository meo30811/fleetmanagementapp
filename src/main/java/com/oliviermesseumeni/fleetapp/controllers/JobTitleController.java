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
import com.oliviermesseumeni.fleetapp.models.JobTitle;
import com.oliviermesseumeni.fleetapp.models.JobTitle;
import com.oliviermesseumeni.fleetapp.models.State;
import com.oliviermesseumeni.fleetapp.services.CountryService;
import com.oliviermesseumeni.fleetapp.services.JobTitleService;
import com.oliviermesseumeni.fleetapp.services.JobTitleService;
import com.oliviermesseumeni.fleetapp.services.StateService;

@Controller
public class JobTitleController {
	
	@Autowired
	JobTitleService jobTitleService;
	@Autowired
	StateService stateService;
	@Autowired
	CountryService countryService;
	
	@GetMapping("/jobtitles")
	public String getJobTitles(Model model)
	{
	   List<JobTitle> jobTitleList = jobTitleService.getJobTitles();
	   
	   
	   model.addAttribute("jobTitles", jobTitleList);
	   return "jobtitle";
	}
	
	@GetMapping("/jobtitles/findById")
	@ResponseBody
	public Optional<JobTitle> findById(Integer id)
	{
		return jobTitleService.findById(id);
		
	}
	
	@PostMapping("/jobtitles/addNew")
	public String addNew(JobTitle jobTitle)
	{
		jobTitleService.save(jobTitle);
		return "redirect:/jobtitles";
	}
	
	@RequestMapping(value="/jobtitles/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(JobTitle jobTitle)
	{
		jobTitleService.update(jobTitle);
		return "redirect:/jobtitles";
	}
	@RequestMapping(value="/jobtitles/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
		jobTitleService.delete(id);
		return "redirect:/jobtitles";
	}
}
