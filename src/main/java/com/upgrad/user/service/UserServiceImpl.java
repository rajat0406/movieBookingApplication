package com.upgrad.user.service;

import com.upgrad.user.dao.UserDao;
import com.upgrad.user.dto.UserDTO;
import com.upgrad.user.entities.User;
import java.util.List;

import com.upgrad.user.utils.POJOConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao ;

  @Override
  public User createUser(User user) {
    return userDao.save(user);
  }

  @Override
  public User getUserBasedOnId(int id) {
    return userDao.findById(id).get();
  }

  @Override
  public User updateUser(User user) {
    User savedUser = getUserBasedOnId(user.getUserId());

    if(savedUser != null) {
      return userDao.save(savedUser);
    }
    return null;

  }

  @Override
  public User deleteUser(User user) {
    userDao.delete(user);
    return null;
  }

  @Override
  public List<User> getAllUser() {
    return userDao.findAll();
  }

  public UserDao getUserDao() {
    return userDao;
  }

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }
}
