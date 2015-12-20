package edu.nyit.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	public List<String> getFriends()
	{
		return friends;
	}

	public void setFriends(List<String> friends)
	{
		this.friends = friends;
	}

	public List<String> toList(Set<Post> set)
	{
		List<String> l = new ArrayList<String>();
		for (Post p : set)
		{
			l.add(p.getContent());
		}
		return l;
	}
	
	public List<String> toContentList(List<Post> set)
	{
		List<String> l = new ArrayList<String>();
		for (Post p : set)
		{
			l.add(p.getContent());
		}
		return l;
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
