package daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import dao.UserDAO;
import model.User;

public class UserDAOImpl implements UserDAO 
{
	
	@Override
	public boolean addUser(User user) 
	{	
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","root");
			PreparedStatement ps=con.prepareStatement("insert into users values(?,?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.executeUpdate();
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
	}

	@Override
	public boolean deleteUser(String username) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","root");
			PreparedStatement ps=con.prepareStatement("delete from users where username=?");
			ps.setString(1, username);
			ps.executeUpdate();
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;	
		}
	}

	@Override
	public boolean updateUser(User user) 
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","root");
			PreparedStatement ps=con.prepareStatement("update users set email=?,password=? where username=?");
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getUsername());
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) 
		{
			System.out.println(e);
			return false;	
		}
		
	}

	@Override
	public User displayUser(String username)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sample","root","root");
			PreparedStatement ps=con.prepareStatement("select * from users where username=?");
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			
			User u=null;
			while(rs.next()) 
			{
				u=new User();
				u.setUsername(rs.getString("username"));
				u.setEmail(rs.getString("email"));
				u.setPassword(rs.getString("password"));
			}
			return u;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return null;
		}
	}
}
