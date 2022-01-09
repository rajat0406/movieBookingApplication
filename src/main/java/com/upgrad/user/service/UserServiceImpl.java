package com.upgrad.user.service;

import com.upgrad.user.dao.UserDao;
import com.upgrad.user.entities.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserDao userDao ;

  @Override
  public User createUser(User user) {
    return null;
  }

  @Override
  public User getUserBasedOnId(int id) { return null; }

  @Override
  public User updateUser(User user) { return null; }

  @Override
  public User deleteUser(User user) { return  null ; }

  public UserDao getUserDao() {
    return userDao;
  }

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }
}
