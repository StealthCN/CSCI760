package edu.nyit.dto;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	
	public void addUser(User user)
	{
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
	
	public void updateUser(User user)
	{
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.merge(user);
		session.getTransaction().commit();
	}
	
	public User getUser(String userName)
	{
		User u = null;
		String sql = "from User U where U.email = :userNameParam";
		Session session = getSessionFactory().openSession();
		Query q = session.createQuery(sql);
		q.setParameter("userNameParam", userName);
		List<User> list = (List<User>)q.list();
		if(list.size() == 1)
		{
			u = list.get(0);
		}
		return u;
	}
	
	public List<User> listUsers()
	{
		String sql = "from User";
		Session session = getSessionFactory().openSession();
		Query q = session.createQuery(sql);
		List<User> list = (List<User>)q.list();
		return list;
	}
}
