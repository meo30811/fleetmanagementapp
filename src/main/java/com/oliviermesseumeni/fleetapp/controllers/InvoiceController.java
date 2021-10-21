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
import com.oliviermesseumeni.fleetapp.models.Invoice;
import com.oliviermesseumeni.fleetapp.models.Invoice;
import com.oliviermesseumeni.fleetapp.models.State;
import com.oliviermesseumeni.fleetapp.services.ClientService;
import com.oliviermesseumeni.fleetapp.services.CountryService;
import com.oliviermesseumeni.fleetapp.services.InvoiceService;
import com.oliviermesseumeni.fleetapp.services.InvoiceStatusService;
import com.oliviermesseumeni.fleetapp.services.InvoiceService;
import com.oliviermesseumeni.fleetapp.services.StateService;

@Controller
public class InvoiceController {
	
	@Autowired
	InvoiceService invoiceService;
	@Autowired
	StateService stateService;
	@Autowired
	CountryService countryService;
	
	@GetMapping("/invoices")
	public String getInvoices(Model model)
	{
	   List<Invoice> invoiceList = invoiceService.getInvoices();
	   List<Country> countryList = countryService.getCountries();
	   List<State> stateList = stateService.getStates();
	   
	   model.addAttribute("invoices", invoiceList);
	   model.addAttribute("states", stateList);
	   model.addAttribute("countries", countryList);
	   return "invoice";
	}
	
	@GetMapping("/invoices/findById")
	@ResponseBody
	public Optional<Invoice> findById(Integer id)
	{
		return invoiceService.findById(id);
		
	}
	
	@PostMapping("/invoices/addNew")
	public String addNew(Invoice invoice)
	{
		invoiceService.save(invoice);
		return "redirect:/invoices";
	}
	
	@RequestMapping(value="/invoices/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(Invoice invoice)
	{
		invoiceService.update(invoice);
		return "redirect:/invoices";
	}
	@RequestMapping(value="/invoices/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id)
	{
		invoiceService.delete(id);
		return "redirect:/invoices";
	}
}
