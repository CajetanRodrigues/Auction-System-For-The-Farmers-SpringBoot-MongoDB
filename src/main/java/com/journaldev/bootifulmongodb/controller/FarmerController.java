package com.journaldev.bootifulmongodb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.journaldev.bootifulmongodb.dal.UserRepository;
import com.journaldev.bootifulmongodb.model.Bank;
import com.journaldev.bootifulmongodb.model.Farmer;
import com.journaldev.bootifulmongodb.model.User;

@RestController
@RequestMapping(value="/rest")
public class FarmerController {
	 
	 @Autowired
	 private UserRepository userRepository;
	
	

	@RequestMapping(value = "/addBankDetails/{user_id}", method = RequestMethod.POST)
	public User addBankDetails(@PathVariable("user_id")  int user_id,@RequestBody Bank bank) {
		User u = userRepository.findOne(user_id); // return a object
		System.out.println(u);
		Farmer m = new Farmer();
		List<Bank> list = new ArrayList<Bank>();
		System.out.println("Hello" + list);

		if(u.getFarmer()==null) {
			System.out.println("Hello1"+list);

			list.add(bank);
			m.setBanks(list);
			u.setFarmer(m);
			userRepository.save(u);
		}
		else 
		{
			System.out.println("Hello2"+list);

			list = u.getFarmer().getBanks();
	
			list.add(bank);
			m.setBanks(list);
			u.setFarmer(m);
			userRepository.save(u);
		}
		return u;
	}
	
	@RequestMapping(value = "/viewBankDetails/{farmer_id}", method = RequestMethod.GET)
	public User viewBankDetails(@PathVariable("farmer_id") int farmer_id) {
		return userRepository.findOne(farmer_id) ;// returns an arraylist
	}
	
//	@GetMapping("/viewBank/{id}")
//	public Bank viewBank(@PathVariable("id") int id) {
//		return bankRepository.findOne(id);
//	}
//	@DeleteMapping("/deleteBank/{id}")
//	public void deleteBank(@PathVariable("id") int id) {
//		 bankRepository.delete(id);
//	}
//	@PutMapping("/updateBank/{id}")
//	public Bank updateBank(@PathVariable("id") int id,@RequestBody Bank bank)
//	{
//		
//		Bank fetchedBankObject =  bankRepository.findOne(id);
//		fetchedBankObject.setIfsc(bank.getIfsc());
//		fetchedBankObject.setProfileImageUrl(bank.getProfileImageUrl());
//		return bankRepository.save(fetchedBankObject);
//		
//	}
	
}
