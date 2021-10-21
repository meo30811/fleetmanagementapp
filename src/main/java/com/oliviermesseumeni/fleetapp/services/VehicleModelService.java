package com.oliviermesseumeni.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliviermesseumeni.fleetapp.models.VehicleModel;
import com.oliviermesseumeni.fleetapp.models.VehicleModel;
import com.oliviermesseumeni.fleetapp.repositories.VehicleModelRepository;
import com.oliviermesseumeni.fleetapp.repositories.VehicleModelRepository;

@Service
public class VehicleModelService {
	
	@Autowired
	private VehicleModelRepository vehicleModelRepository;
	
	public List<VehicleModel> getVehicleModels()
	{
		return (List<VehicleModel>) vehicleModelRepository.findAll();
	}
	
	public void save(VehicleModel vehicleModel)
	{
		vehicleModelRepository.save(vehicleModel);
	}
	
	public void delete(Integer id)
	{
		vehicleModelRepository.deleteById(id);
	}
	
	public Optional<VehicleModel> findById(Integer id)
	{
		return vehicleModelRepository.findById(id);
	}
	
	public void update(VehicleModel vehicleModel)
	{
		vehicleModelRepository.save(vehicleModel);
	}

}
