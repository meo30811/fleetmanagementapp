package com.oliviermesseumeni.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliviermesseumeni.fleetapp.models.VehicleType;
import com.oliviermesseumeni.fleetapp.models.VehicleType;
import com.oliviermesseumeni.fleetapp.repositories.VehicleTypeRepository;
import com.oliviermesseumeni.fleetapp.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {
	
	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;
	
	public List<VehicleType> getVehicleTypes()
	{
		return (List<VehicleType>) vehicleTypeRepository.findAll();
	}
	
	public void save(VehicleType vehicleType)
	{
		vehicleTypeRepository.save(vehicleType);
	}
	
	public void delete(Integer id)
	{
		vehicleTypeRepository.deleteById(id);
	}
	
	public Optional<VehicleType> findById(Integer id)
	{
		return vehicleTypeRepository.findById(id);
	}
	
	public void update(VehicleType vehicleType)
	{
		vehicleTypeRepository.save(vehicleType);
	}
}
