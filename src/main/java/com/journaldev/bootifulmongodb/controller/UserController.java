package com.journaldev.bootifulmongodb.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.journaldev.bootifulmongodb.dal.UserRepository;
import com.journaldev.bootifulmongodb.model.User;

@RestController
@RequestMapping(value = "/rest")
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserRepository userRepository;
	
 
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public User addNewUsers(@RequestBody User user) {
		LOG.info("Saving user.");
		return userRepository.save(user); // return a object
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		LOG.info("Getting all users.");
		return userRepository.findAll(); // returns an arraylist
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public User getUser(@PathVariable("userId") int userId) {
		LOG.info("Getting user with ID: {}.", userId);
		return userRepository.findOne(userId); // returns an object
	}


//	@RequestMapping(value = "/settings/{userId}", method = RequestMethod.GET)
//	public Object getAllUserSettings(@PathVariable String userId) {
//		User user = userRepository.findOne(userId);
//		if (user != null) {
//			return userDAL.getAllUserSettings(userId);
//		} else {
//			return "User not found.";
//		}
//	}

	// @RequestMapping(value = "/settings/{userId}/{key}", method =
	// RequestMethod.GET)
	// public String getUserSetting(@PathVariable String userId, @PathVariable
	// String key) {
	// //User user = userRepository.findOne(userId);
	// String setting = userDAL.getUserSetting(userId, key);
	// LOG.info("Setting = "+setting);
	// if (setting != null) {
	// return setting;
	// } else {
	// return "Setting not found.";
	// }
	// }
//
//	@RequestMapping(value = "/settings/{userId}/{key}", method = RequestMethod.GET)
//	public String getUserSetting(@PathVariable String userId, @PathVariable String key) {
//		User user = userRepository.findOne(userId);
//		return user.getUserSettings();
//	}

}