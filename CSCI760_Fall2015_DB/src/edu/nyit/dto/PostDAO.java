package edu.nyit.dto;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostDAO 
{
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void addPost(Post p)
	{
		Session session = getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
	}
	
	public User getPost(String userName)
	{
		User u = null;
		String sql = "from Post P where P.email = :userNameParam";
		Session session = getSessionFactory().openSession();
		Query q = session.createQuery(sql);
		q.setParameter("userNameParam", userName);
		List<User> list = (List<User>)q.list();
		if(list.size() == 1)
		{
			u = list.get(0);
			System.out.println(u.getEmail()+" "+u.getPassword());
		}
		return u;
	}
	
	public List<User> listPost()
	{
		String sql = "from User";
		Session session = getSessionFactory().openSession();
		Query q = session.createQuery(sql);
		List<User> list = (List<User>)q.list();
		return list;
	}
}
