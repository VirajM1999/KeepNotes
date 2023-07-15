package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.LoginDto;
import com.app.dto.ResponseApi;
import com.app.dto.Userdto;
import com.app.pojo.Notes;
import com.app.pojo.User;
import com.app.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {
	
	@Autowired
	private UserService userservice;

	@PostMapping("/newuser")
	public ResponseApi addNewUser(@RequestBody User newuser){
			return (userservice.addnewuser(newuser));
	}
	@PostMapping("/updateuserdetails")
	public ResponseApi updateUser(@RequestBody Userdto updateuser) {
		return (userservice.updateUser(updateuser));
	}
	
	@PostMapping("/login")
	public ResponseApi userLogin(@RequestBody  LoginDto user) {
		return userservice.loginuser(user);
	}
	
	@GetMapping("/notelist/{userId}")
	public List<Notes> getNoteList(@PathVariable Integer userId){
		return userservice.getnotelist(userId);
	}
}
