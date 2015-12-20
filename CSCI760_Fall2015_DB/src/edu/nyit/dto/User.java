package edu.nyit.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Custom object to contain information about a single User
 *
 */
@Entity
@Table(name = "User")
public class User
{
	@Id
	@Column(name = "user_id")
	private String email;

	@Column(name = "firstName")
	private String firstName;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "password")
	private String password;
	
	@ElementCollection
	@CollectionTable(name="Friends", joinColumns=@JoinColumn(name="user_id"))
	@Column(name="friends")
	private List<String> friends = new ArrayList<String>();
	
	@OneToMany(mappedBy="user")
	private Set<Post> posts = new HashSet<>();
	
	/**
	 * Convert post list to content string list
	 * 
	 * @param postList A list of Post objects
	 * @return A list of Post content string
	 */
	public List<String> toContentList(List<Post> postList)
	{
		List<String> l = new ArrayList<String>();
		for (Post p : postList)
		{
			l.add(p.getContent());
		}
		return l;
	}
	
	public List<String> getFriends()
	{
		return friends;
	}

	public void setFriends(List<String> friends)
	{
		this.friends = friends;
	}
	
	public Set<Post> getPosts()
	{
		return posts;
	}

	public void setPosts(Set<Post> posts)
	{
		this.posts = posts;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
}
