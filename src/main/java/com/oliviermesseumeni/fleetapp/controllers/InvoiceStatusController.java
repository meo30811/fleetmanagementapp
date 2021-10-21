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
import com.oliviermesseumeni.fleetapp.models.InvoiceStatus;
import com.oliviermesseumeni.fleetapp.models.InvoiceStatus;
import com.oliviermesseumeni.fleetapp.models.State;
import com.oliviermesseumeni.fleetapp.services.CountryService;
import com.oliviermesseumeni.fleetapp.services.InvoiceStatusService;
import com.oliviermesseumeni.fleetapp.services.InvoiceStatusService;
import com.oliviermesseumeni.fleetapp.services.StateService;

@Controller
public class InvoiceStatusController {

	@Autowired
	InvoiceStatusService invoiceStatusService;
	@Autowired
	StateService stateService;
	@Autowired
	CountryService countryService;
	
	@GetMapping("/invoiceStatuss")
	public String getInvoiceStatuses(Model model)
	{
	   List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuss();
	   List<Country> countryList = countryService.getCountries();
	   List<State> stateList = stateService.getStates();
	   
	   model.addAttribute("invoiceStatuss", invoiceStatusList);
	   model.addAttribute("states", stateList);
	   model.addAttribute("countries", countryList);
	   return "invoicestatus";
	}
	
	@GetMapping("/invoiceStatuses/findById")
	@ResponseBody
	public Optional<InvoiceStatus> findById(Integer id)
	{
		return invoiceStatusService.findById(id);
		
	}
	
	@PostMapping("/invoicestatuses/addNew")
	public String addNew(InvoiceStatus invoiceStatus)
	{
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoicestatuses";
	}
	
	@RequestMapping(value="/invoicestatuses/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(InvoiceStatus invoiceStatus)
	{
		invoiceStatusService.update(invoiceStatus);
		return "redirect:/invoicestatuses";
	}
	@RequestMapping(value="/invoicestatuses/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
		invoiceStatusService.delete(id);
		return "redirect:/invoicestatuses";
	}
}
