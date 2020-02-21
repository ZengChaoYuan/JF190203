package service;

import java.util.List;

import bean.User;
import dao.UserDao;
import dao.UserDaoImpl;

public class UserServiceImpl implements UserService {

	@Override
	public List<User> queryUsers(User user) {
	 UserDao userdao=new UserDaoImpl();
	 return userdao.queryUsers(user);
	}

	@Override
	public int addUser(User user) {
		UserDao userdao=new UserDaoImpl();	  
		return userdao.addUser(user);
	}

}
