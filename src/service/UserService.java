package service;

import java.util.List;

import bean.User;

public interface UserService {
  public List<User> queryUsers(User user);
  public int addUser(User user);
}
