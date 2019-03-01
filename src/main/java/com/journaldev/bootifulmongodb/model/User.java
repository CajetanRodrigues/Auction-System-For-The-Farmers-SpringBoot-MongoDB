package com.journaldev.bootifulmongodb.model;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user")
public class User {

	@Id
	private int userId;
	private String name;
	private String email;
	private String password;
	private Farmer farmer;
	private FarmEquipmentSeller farmEquipmentSeller;
	private FMGC fmgc;
	private String profileImageUrl;
	private Group groups;
	
	
	

	public Group getGroups() {
		return groups;
	}

	public void setGroups(Group groups) {
		this.groups = groups;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FarmEquipmentSeller getFarmEquipmentSeller() {
		return farmEquipmentSeller;
	}

	public void setFarmEquipmentSeller(FarmEquipmentSeller farmEquipmentSeller) {
		this.farmEquipmentSeller = farmEquipmentSeller;
	}

	public FMGC getFmgc() {
		return fmgc;
	}

	public void setFmgc(FMGC fmgc) {
		this.fmgc = fmgc;
	}

	public Farmer getFarmer() {
		return farmer;
	}

	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	private Date creationDate = new Date();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}



	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


}
