package com.oliviermesseumeni.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliviermesseumeni.fleetapp.models.State;
import com.oliviermesseumeni.fleetapp.repositories.StateRepository;

@Service
public class StateService {

	@Autowired
	private StateRepository stateRepository;
	
	public void save(State state)
	{
		stateRepository.save(state);
	}
	public List<State> getStates()
	{
		return stateRepository.findAll();
	}
	public void update(State state)
	{
		stateRepository.save(state);
	}
	
	public Optional<State> findById(Integer id)
	{
		return stateRepository.findById(id);
	}
	
	public void delete(Integer id)
	{
		stateRepository.deleteById(id);
	}
}
