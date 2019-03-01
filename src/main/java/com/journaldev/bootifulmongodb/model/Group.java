package com.journaldev.bootifulmongodb.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="group")
public class Group {
	@Id
	private int group_id;
	private User owner;
	private ArrayList<User> member;
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public ArrayList<User> getMember() {
		return member;
	}
	public void setMember(ArrayList<User> member) {
		this.member = member;
	}
		

}
