package com.oliviermesseumeni.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliviermesseumeni.fleetapp.models.InvoiceStatus;
import com.oliviermesseumeni.fleetapp.models.InvoiceStatus;
import com.oliviermesseumeni.fleetapp.repositories.InvoiceStatusRepository;
import com.oliviermesseumeni.fleetapp.repositories.InvoiceStatusRepository;

@Service
public class InvoiceStatusService {
	
	@Autowired
	private InvoiceStatusRepository invoiceStatusRepository;
	
	public List<InvoiceStatus> getInvoiceStatuss()
	{
		return (List<InvoiceStatus>) invoiceStatusRepository.findAll();
	}
	
	public void save(InvoiceStatus invoiceStatus)
	{
		invoiceStatusRepository.save(invoiceStatus);
	}
	
	public void delete(Integer id)
	{
		invoiceStatusRepository.deleteById(id);
	}
	
	public Optional<InvoiceStatus> findById(Integer id)
	{
		return invoiceStatusRepository.findById(id);
	}
	
	public void update(InvoiceStatus invoiceStatus)
	{
		invoiceStatusRepository.save(invoiceStatus);
	}

}
