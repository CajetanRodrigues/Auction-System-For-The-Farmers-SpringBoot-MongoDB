package com.journaldev.bootifulmongodb.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.journaldev.bootifulmongodb.dal.GroupRepository;
import com.journaldev.bootifulmongodb.dal.UserRepository;
import com.journaldev.bootifulmongodb.model.Group;
import com.journaldev.bootifulmongodb.model.User;
//edited1
@RestController
@RequestMapping(value="/rest")
public class GroupController {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private GroupRepository groupRepository;
	
	@RequestMapping(value = "/createGroup/{owner_id}/{member_id}", method = RequestMethod.POST)
	public Group createGroup(@PathVariable("owner_id")  int owner_id,@PathVariable("member_id") int member_id) {
		User owner = userRepository.findOne(owner_id);
		User member = userRepository.findOne(member_id);
		Group g = new Group();
		g.setOwner(owner);
		System.out.println(owner + " " + member);
		ArrayList<User> list = new ArrayList<User>();
		if(owner.getGroups()==null) {
			list.add(member);
			g.setMember(list);
//			owner.setGroups(g);
			groupRepository.save(g);
//			userRepository.save(owner);
			
			
		}
		else {
			ArrayList<User> list2 = new ArrayList<>();
			list2 = owner.getGroups().getMember();
			list2.add(member);
			g.setMember(list2);
//			owner.setGroups(g);
			groupRepository.save(g);
//			userRepository.save(owner);
			
		}
		return g;
		
	}
	
}
