package edu.nyit.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User>
{
	public User mapRow(ResultSet rs, int rownNumber) throws SQLException 
	{
		User u = new User();
		u.setFirstName(rs.getString("firstName"));
		u.setLastName(rs.getString("lastName"));
		u.setEmail(rs.getString("email"));
		u.setPassword(rs.getString("password"));
		return u;
	}
}
