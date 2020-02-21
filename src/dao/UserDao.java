package dao;

import java.util.List;

import bean.User;

public interface UserDao {
  public int addUser(User user);
  public List<User>queryUsers(User user);
  
  
}
