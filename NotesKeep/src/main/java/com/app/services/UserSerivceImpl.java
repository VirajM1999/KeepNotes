package com.app.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.LoginDto;
import com.app.dto.ResponseApi;
import com.app.dto.Userdto;
import com.app.pojo.Notes;
import com.app.pojo.User;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserSerivceImpl implements UserService {
	
	@Autowired
	private UserRepository userrepo;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public ResponseApi addnewuser(User newuser) {
		ResponseApi response = new ResponseApi();
		User existingUser = userrepo.findByUsername(newuser.getUsername());
		try {
			if(existingUser != null) {
				response.setMessage("Username already exists");
				response.setStatuscode(501);
				return response;
			}
			else {
				response = mapper.map(newuser, ResponseApi.class);
				response.setMessage("User registered successfully. Please login.");
				response.setStatuscode(200);
				userrepo.save(newuser);
			}
		} catch (Exception e) {
			response.setMessage("User adddition failed");
			response.setStatuscode(502);
		}
		return response;
	}

	@Override
	public ResponseApi updateUser(Userdto updateuser) {
		ResponseApi response = new ResponseApi();
		
		 User updtuser=userrepo.findById(updateuser.getUserId()).orElseThrow();
		 
		
		try {
			updtuser.setName(updateuser.getName());
			updtuser.setUsername(updateuser.getUsername());
			
			userrepo.save(updtuser);
			response.setStatuscode(200);
			response.setMessage("note updated successfully");
			
		}
		catch(Exception e) {
			response.setStatuscode(400);
			response.setMessage("upadation failed");
		}
		return response;
	}

	
	@Override
	public ResponseApi loginuser(LoginDto user) {
		User existingUser = userrepo.findByUsername(user.getUsername());
		ResponseApi response;
		if(existingUser == null) {
			response = new ResponseApi();
			response.setStatuscode(502);
			response.setMessage("User does not exist");
			return response;
		}
		
		if(existingUser.getPassword().equals(user.getPassword())) {
			response = mapper.map(existingUser, ResponseApi.class);
			response.setUserid(existingUser.getId());
			response.setStatuscode(200);
			response.setMessage("User successfully logged in.");
			return response;
		}
		else {
			response = new ResponseApi();
			response.setStatuscode(501);
			response.setMessage("Invalid password");
			return response;
		}
	}

	@Override
	public List<Notes> getnotelist(Integer userId) {
		User user=userrepo.findById(userId).orElseThrow();
		return user.getNotes();
	}
	
	
	

}
