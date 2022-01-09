package com.upgrad.user.controller;

import com.upgrad.user.dto.UserDTO;
import com.upgrad.user.entities.User;
import com.upgrad.user.service.UserService;
import com.upgrad.user.utils.POJOConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/userDetails")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/createUser", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public RequestEntity createUser(@RequestBody UserDTO userDTO){
		User user = POJOConvertor.covertUserDTOToEntity(userDTO);
		User savedUser = userService.createUser(user);
		UserDTO savedUserDTO = POJOConvertor.covertUserEntityToDTO(savedUser);

		return new RequestEntity(savedUserDTO, HttpStatus.OK);
	}

	@GetMapping(value = "/findAllUsers", produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public RequestEntity getAllUsers(){
		List<User> userList = userService.getAllUser();
		List<UserDTO> userDTOList = new ArrayList<>();

		userDTOList.forEach(userDTO -> {
			POJOConvertor.covertUserDTOToEntity(userDTO);
		});

		return new RequestEntity(userDTOList, HttpStatus.OK);
	}


	@PutMapping(value = "updateMovie/{id}" , produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateMovie(@PathVariable(name = "id") int id, @RequestBody UserDTO userDTO){

		User user = POJOConvertor.covertUserDTOToEntity(userDTO);
		User updateUser = userService.updateUser(user);

		UserDTO updatedUserDTO = POJOConvertor.covertUserEntityToDTO(updateUser);

		return new ResponseEntity(updatedUserDTO, HttpStatus.OK);
	}


}