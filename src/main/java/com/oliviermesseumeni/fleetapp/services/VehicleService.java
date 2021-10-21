package com.oliviermesseumeni.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliviermesseumeni.fleetapp.models.Vehicle;
import com.oliviermesseumeni.fleetapp.models.Vehicle;
import com.oliviermesseumeni.fleetapp.repositories.VehicleRepository;
import com.oliviermesseumeni.fleetapp.repositories.VehicleRepository;

@Service
public class VehicleService {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public List<Vehicle> getVehicles()
	{
		return (List<Vehicle>) vehicleRepository.findAll();
	}
	
	public void save(Vehicle vehicle)
	{
		vehicleRepository.save(vehicle);
	}
	
	public void delete(Integer id)
	{
		vehicleRepository.deleteById(id);
	}
	
	public Optional<Vehicle> findById(Integer id)
	{
		return vehicleRepository.findById(id);
	}
	
	public void update(Vehicle vehicle)
	{
		vehicleRepository.save(vehicle);
	}

}
