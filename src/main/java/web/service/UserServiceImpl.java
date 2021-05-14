package web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import web.dao.UserDAO;
import web.model.User;

@Component
@Transactional
public class UserServiceImpl implements UserService{
	
	private final UserDAO userDao;
		
	@Autowired
	public UserServiceImpl(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	
	
	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
	
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}
	
	@Override
	public void editUser(int id, User user) {
		userDao.editUser(id, user);
	}
	
	@Override
	public void removeUser(int id) {
		userDao.removeUser(id);
	}
	
}
