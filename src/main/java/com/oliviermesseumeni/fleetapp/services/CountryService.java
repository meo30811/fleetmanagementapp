package com.oliviermesseumeni.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oliviermesseumeni.fleetapp.models.Country;
import com.oliviermesseumeni.fleetapp.repositories.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	private CountryRepository countryRepository;
	
	public List<Country> getCountries()
	{
		return countryRepository.findAll();
	}
	
	public void save(Country country)
	{
		countryRepository.save(country);
	}
	
	public Optional<Country> findById(int id)
	{
		return countryRepository.findById(id);
	}
		
	public void update(Country country)
	{
		countryRepository.save(country);
	}
	
	public void delete(Integer id)
	{
		countryRepository.deleteById(id);
	}

}
