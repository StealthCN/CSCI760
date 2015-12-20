package edu.nyit.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostService
{
	private PostDAO postDAO;

	public void addPost(Post p)
	{
		getPostDAO().addPost(p);
	}

	public PostDAO getPostDAO()
	{
		return postDAO;
	}

	@Autowired
	public void setPostDAO(PostDAO postDAO)
	{
		this.postDAO = postDAO;
	}

}
