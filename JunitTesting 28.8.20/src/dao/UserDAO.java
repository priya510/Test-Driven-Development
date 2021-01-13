package dao;

import java.util.List;
import model.User;

public interface UserDAO 
{
	public boolean addUser(User user);
	public boolean deleteUser(String username);
	public boolean updateUser(User user);
	public User displayUser(String user);
}
