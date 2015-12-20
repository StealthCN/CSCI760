package edu.nyit.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService
{
	private UserDAO userDAO;

	public void addPerson(User u)
	{
		getUserDAO().addUser(u);
	}

	public List<User> fetchAllPersons()
	{
		return getUserDAO().listUsers();
	}

	public UserDAO getUserDAO()
	{
		return userDAO;
	}

	@Autowired
	public void setUserDAO(UserDAO userDAO)
	{
		this.userDAO = userDAO;
	}

}
