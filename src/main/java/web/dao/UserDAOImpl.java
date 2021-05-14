package web.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import web.model.User;

@Component
@Transactional
public class UserDAOImpl implements UserDAO{
	
	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public void removeUser(int id) {
		entityManager.remove(getUserById(id));
	}

	@Override
	public void editUser(int id, User user) {
		entityManager.merge(user);
	}

	@Override
	public User getUserById(int id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public List<User> getAllUsers() {
		return entityManager.createQuery("select u from User u", User.class).getResultList();
	}
	

}
