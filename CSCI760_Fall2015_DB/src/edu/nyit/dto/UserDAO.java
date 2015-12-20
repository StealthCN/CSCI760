package edu.nyit.dto;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Data access object for User
 *
 */
@Repository
public class UserDAO 
{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * Add a new user to database
	 * 
	 * @param user A single user
	 */
	public void addUser(User user)
	{
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
	
	/**
	 * Update a userin database
	 * 
	 * @param user A single user
	 */
	public void updateUser(User user)
	{
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.merge(user);
		session.getTransaction().commit();
	}
	
	/**
	 * Get a user by email
	 * 
	 * @param userName User email
	 * @return User
	 */
	public User getUser(String userName)
	{
		User u = null;
		String sql = "from User U where U.email = :userNameParam";
		Session session = getSessionFactory().openSession();
		Query q = session.createQuery(sql);
		q.setParameter("userNameParam", userName);
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>)q.list();
		if(list.size() == 1)
		{
			u = list.get(0);
		}
		return u;
	}
	
	/**
	 * List all users
	 * 
	 * @return A list of users
	 */
	public List<User> listUsers()
	{
		String sql = "from User";
		Session session = getSessionFactory().openSession();
		Query q = session.createQuery(sql);
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>)q.list();
		return list;
	}
}
