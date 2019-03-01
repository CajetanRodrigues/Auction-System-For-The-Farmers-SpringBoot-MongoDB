package com.journaldev.bootifulmongodb.model;



import java.util.List;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class Farmer {
	
	private List<Bank> banks;

	public void setBanks(List<Bank> banks) {
		this.banks = banks;
	}

	public List<Bank> getBanks() {
		return banks;
	}

	

	
}
