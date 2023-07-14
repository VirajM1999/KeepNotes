package com.app.services;

import java.util.List;

import com.app.dto.LoginDto;
import com.app.dto.ResponseApi;
import com.app.dto.Userdto;
import com.app.pojo.Notes;
import com.app.pojo.User;

public interface UserService {

	ResponseApi addnewuser(User newuser);

	

	ResponseApi updateUser(Userdto updateuser);



	ResponseApi loginuser(LoginDto user);



	List<Notes> getnotelist(Integer userId);
	
	

}
