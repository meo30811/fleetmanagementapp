package com.oliviermesseumeni.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliviermesseumeni.fleetapp.models.VehicleStatus;
import com.oliviermesseumeni.fleetapp.models.VehicleStatus;
import com.oliviermesseumeni.fleetapp.repositories.VehicleStatusRepository;
import com.oliviermesseumeni.fleetapp.repositories.VehicleStatusRepository;

@Service
public class VehicleStatusService {
	
	@Autowired
	private VehicleStatusRepository vehicleStatusRepository;
	
	public List<VehicleStatus> getVehicleStatuses()
	{
		return (List<VehicleStatus>) vehicleStatusRepository.findAll();
	}
	
	public void save(VehicleStatus vehicleStatus)
	{
		vehicleStatusRepository.save(vehicleStatus);
	}
	
	public void delete(Integer id)
	{
		vehicleStatusRepository.deleteById(id);
	}
	
	public Optional<VehicleStatus> findById(Integer id)
	{
		return vehicleStatusRepository.findById(id);
	}
	
	public void update(VehicleStatus vehicleStatus)
	{
		vehicleStatusRepository.save(vehicleStatus);
	}

}
