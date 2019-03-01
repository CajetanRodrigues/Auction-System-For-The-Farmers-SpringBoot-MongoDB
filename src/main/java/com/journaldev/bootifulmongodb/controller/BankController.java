package com.journaldev.bootifulmongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.journaldev.bootifulmongodb.dal.BankRepository;
import com.journaldev.bootifulmongodb.model.Bank;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/rest")
public class BankController {
	
	
	 @Autowired
	 private BankRepository bankRepository;
	 
	
	public void setBankRepository(BankRepository bankRepository) {
		this.bankRepository = bankRepository;
	}

	@RequestMapping(value = "/addBank", method = RequestMethod.POST)
	public Bank addBank(@RequestBody Bank bank) {
		return bankRepository.save(bank); // return a object
	}
	
	@RequestMapping(value = "/viewBanks", method = RequestMethod.GET)
	public List<Bank> viewBanks() {
		return bankRepository.findAll(); // returns an arraylist
	}
	
	@GetMapping("/viewBank/{id}")
	public Bank viewBank(@PathVariable("id") int id) {
		return bankRepository.findOne(id);
	}
	@DeleteMapping("/deleteBank/{id}")
	public void deleteBank(@PathVariable("id") int id) {
		 bankRepository.delete(id);
	}
	@PutMapping("/updateBank/{id}")
	public Bank updateBank(@PathVariable("id") int id,@RequestBody Bank bank)
	{
		
		Bank fetchedBankObject =  bankRepository.findOne(id);
		fetchedBankObject.setIfsc(bank.getIfsc());
		fetchedBankObject.setProfileImageUrl(bank.getProfileImageUrl());
		return bankRepository.save(fetchedBankObject);
		
	}
	

}
