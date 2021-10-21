package com.oliviermesseumeni.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliviermesseumeni.fleetapp.models.Invoice;
import com.oliviermesseumeni.fleetapp.models.Invoice;
import com.oliviermesseumeni.fleetapp.repositories.InvoiceRepository;
import com.oliviermesseumeni.fleetapp.repositories.InvoiceRepository;

@Service
public class InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	public List<Invoice> getInvoices()
	{
		return (List<Invoice>) invoiceRepository.findAll();
	}
	
	public void save(Invoice invoice)
	{
		invoiceRepository.save(invoice);
	}
	
	public void delete(Integer id)
	{
		invoiceRepository.deleteById(id);
	}
	
	public Optional<Invoice> findById(Integer id)
	{
		return invoiceRepository.findById(id);
	}
	
	public void update(Invoice invoice)
	{
		invoiceRepository.save(invoice);
	}
}
