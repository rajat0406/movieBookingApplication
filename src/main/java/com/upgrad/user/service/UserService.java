package com.upgrad.user.service;

import com.upgrad.user.dto.UserDTO;
import com.upgrad.user.entities.User;
import java.util.List;


public interface UserService {

  public User createUser(User user);

  public User getUserBasedOnId(int id);

  public User updateUser(UserDTO userDTO);

  public User deleteUser(User user);

}
