package com.oliviermesseumeni.fleetapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliviermesseumeni.fleetapp.models.JobTitle;
import com.oliviermesseumeni.fleetapp.models.JobTitle;
import com.oliviermesseumeni.fleetapp.repositories.JobTitleRepository;
import com.oliviermesseumeni.fleetapp.repositories.JobTitleRepository;

@Service
public class JobTitleService {

	@Autowired
	private JobTitleRepository jobTitleRepository;
	
	public List<JobTitle> getJobTitles()
	{
		return (List<JobTitle>) jobTitleRepository.findAll();
	}
	
	public void save(JobTitle jobTitle)
	{
		jobTitleRepository.save(jobTitle);
	}
	
	public void delete(Integer id)
	{
		jobTitleRepository.deleteById(id);
	}
	
	public Optional<JobTitle> findById(Integer id)
	{
		return jobTitleRepository.findById(id);
	}
	
	public void update(JobTitle jobTitle)
	{
		jobTitleRepository.save(jobTitle);
	}
}
