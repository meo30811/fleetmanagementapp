package com.oliviermesseumeni.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliviermesseumeni.fleetapp.models.VehicleMake;
import com.oliviermesseumeni.fleetapp.models.VehicleMake;
import com.oliviermesseumeni.fleetapp.repositories.VehicleMakeRepository;
import com.oliviermesseumeni.fleetapp.repositories.VehicleMakeRepository;

@Service
public class VehicleMakeService {
	
	@Autowired
	private VehicleMakeRepository VehicleMakeRepository;
	
	public List<VehicleMake> getVehicleMakes()
	{
		return (List<VehicleMake>) VehicleMakeRepository.findAll();
	}
	
	public void save(VehicleMake VehicleMake)
	{
		VehicleMakeRepository.save(VehicleMake);
	}
	
	public void delete(Integer id)
	{
		VehicleMakeRepository.deleteById(id);
	}
	
	public Optional<VehicleMake> findById(Integer id)
	{
		return VehicleMakeRepository.findById(id);
	}
	
	public void update(VehicleMake VehicleMake)
	{
		VehicleMakeRepository.save(VehicleMake);
	}
}
